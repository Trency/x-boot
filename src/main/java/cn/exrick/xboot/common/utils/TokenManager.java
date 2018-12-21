package cn.exrick.xboot.common.utils;

import cn.exrick.xboot.config.enums.EnumHttp403Error;
import cn.exrick.xboot.config.exception.APIException;
import cn.exrick.xboot.config.redis.RedisService;
import cn.exrick.xboot.modules.back.entity.SdLoanUser;
import cn.exrick.xboot.modules.back.service.SdLoanUserService;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.SecretKey;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Set;

public class TokenManager {

    private static final String JWT_SECRET = "sudao_&*%$#@!1111111111111";

    private static final String TOKEN = "token";

    private static final int TOKEN_NOT_BEFORE_EXPIRE = 5 * 24 * 60 * 60 * 1000;

    private static final int TOKEN_EXPIRE = 7 * 24 * 60 * 60 * 1000;

    private static final int COOKIE_EXPIRE = 7 * 24 * 60 * 60;

    private static final int REDIS_USER_EXPIRE = 7 * 24 * 60 * 60;

    public static final int REDIS_REFRESH_TOKEN_EXPIRE = 60 * 60;

    public static final int REDIS_AVAILABLE_TOKEN_EXPIRE = 7 * 24 * 60 * 60 + 60 * 60;

    public static final int REDIS_HISTORY_TOKEN_EXPIRE = 365 * 24 * 60 * 60;

    private static WebContextHolder webContextHolder = WebContextHolder.get();


    /**
     * 由字符串生成加密key
     *
     * @return
     */
    private static SecretKey generalKey() {
        byte[] encodedKey = Base64.encodeBase64(JWT_SECRET.getBytes());
        return Keys.hmacShaKeyFor(encodedKey);
    }

    /**
     * 创建jwt
     *
     * @param id 用户主键id
     * @return
     */
    public static String createJWT(String id) {
        return createJWT(id, null);
    }

    /**
     * 创建jwt
     *
     * @param id      用户主键id
     * @param subject json对象
     * @return
     */
    public static String createJWT(String id, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + TOKEN_EXPIRE;
        Date exp = new Date(expMillis);
        long notBeforeMillis = nowMillis + TOKEN_NOT_BEFORE_EXPIRE;
        Date refreshDate = new Date(notBeforeMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("")
                .setIssuedAt(now)
                .setSubject(DateUtil.format(refreshDate, "yyyy-MM-dd HH:mm:ss"))
                .setExpiration(exp)
                .signWith(key);
        return builder.compact();
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt) {
        SecretKey key = generalKey();
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static SdLoanUser getCurrentUser() {
        try {
            HttpServletRequest request = webContextHolder.getRequest();
            String token = getRequestToken(request);
            if (StringUtils.isEmpty(token)) {
                return null;
            }
            Claims claims = parseJWT(token);
            String id = claims.getId();
            if (StringUtils.isEmpty(id)) {
                return null;
            }
            RedisService redisService = webContextHolder.getRedisService();
            String userStr = redisService.get(genUserKey(id));
            if (StringUtils.isEmpty(userStr)) {
                // get user from db
                SdLoanUserService sdLoadUserService = webContextHolder.getSdLoadUserService();
                SdLoanUser sdLoanUser = sdLoadUserService.get(id);
                if (sdLoanUser == null) {
                    return null;
                }
                redisService.set(genUserKey(id), JSONUtil.toJsonStr(sdLoanUser), REDIS_USER_EXPIRE);
                return sdLoanUser;
            }
            return JSONUtil.toBean(userStr, SdLoanUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRequestToken(HttpServletRequest request) {

        String parameter = request.getParameter(TOKEN);
        if (StringUtils.isNotEmpty(parameter)) {
            return parameter;
        }
        String header = request.getHeader(TOKEN);
        if (StringUtils.isNotEmpty(header)) {
            return header;
        }

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if (TOKEN.equals(name)) {
                return cookie.getValue();
            }
        }

        return null;
    }

    public static void setResponseToken(HttpServletResponse response, String token) {

        response.setHeader(TOKEN, token);

        Cookie cookie = new Cookie(TOKEN, token);
        cookie.setMaxAge(COOKIE_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 设置token
     *
     * @param response
     * @param user
     * @return
     */
    public static String setToken(HttpServletResponse response, SdLoanUser user) {

        if (user == null || user.getUserId() == null) {
            throw new APIException(EnumHttp403Error.USER_NOT_FOUND);
        }

        delToken(response, user.getUserId());

        String id = user.getUserId().toString();
        String token = createJWT(id);

        setResponseToken(response, token);

        RedisService redisService = webContextHolder.getRedisService();

        // 缓存用户信息
        String userKey = genUserKey(id);
        // 缓存用户可用token，用户同时可能有多个可用token
        String availableTokenKey = genAvailableTokenKey(id, token);
        // 缓存用户历史token
        String tokenHistoryKey = genTokenHistoryKey(id);

        // 缓存用户信息
        redisService.set(userKey, JSONUtil.toJsonStr(user), REDIS_USER_EXPIRE);
        // 设置用户可用token
        redisService.set(availableTokenKey, token, REDIS_AVAILABLE_TOKEN_EXPIRE);
        // 设置用户历史token
        redisService.sadd(tokenHistoryKey, REDIS_HISTORY_TOKEN_EXPIRE, availableTokenKey);

        return token;
    }

    /**
     * 删除token
     *
     * @return
     */
    public static void delToken(HttpServletResponse response, String userId) {

        if (userId == null) {
            throw new APIException(EnumHttp403Error.USER_NOT_FOUND);
        }

        response.setHeader(TOKEN, null);

        Cookie cookie = new Cookie(TOKEN, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        RedisService redisService = webContextHolder.getRedisService();

        // 删除用户缓存信息
        redisService.del(genUserKey(userId));

        // 删除用户所有token
        String tokenHistoryKey = genTokenHistoryKey(userId);
        Set<String> smembers = redisService.smembers(tokenHistoryKey);
        if (CollectionUtils.isNotEmpty(smembers)) {
            for (String member : smembers) {
                redisService.del(member);
            }
            redisService.del(tokenHistoryKey);
        }
    }

    private static String genUserKey(String id) {
        return String.format("session_user:%s", id);
    }

    public static String genTokenHistoryKey(String id) {
        return String.format("token:%s:h_available", id);
    }

    public static String genRefreshTokenKey(String id) {
        return String.format("token:%s:refresh", id);
    }

    public static String genAvailableTokenKey(String id, String token) {
        return String.format("token:%s:available:%s", id, token.split("\\.")[1].substring(0, 6));
    }

}
