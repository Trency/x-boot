package cn.exrick.xboot.config.interceptor;


import cn.exrick.xboot.common.annotation.LoginRequired;
import cn.exrick.xboot.common.utils.TokenManager;
import cn.exrick.xboot.common.utils.WebContextHolder;
import cn.exrick.xboot.config.enums.EnumHttp401Error;
import cn.exrick.xboot.config.exception.APIException;
import cn.exrick.xboot.config.redis.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        // 判断接口是否需要登录
        LoginRequired annotation = handlerMethod.getMethodAnnotation(LoginRequired.class);
        if (annotation == null) {
            annotation = handlerMethod.getBeanType().getAnnotation(LoginRequired.class);
        }
        if (annotation == null) {
            return true;
        }
        // 有 @LoginRequired 注解，需要认证
        String token = TokenManager.getRequestToken(request);
        if (StringUtils.isEmpty(token)) {
            throw new APIException(EnumHttp401Error.NEED_LOGIN);
        }
        RedisService redisService = WebContextHolder.get().getRedisService();
        try {
            Claims claims = TokenManager.parseJWT(token);
            String claimsId = claims.getId();

            // 判断token是否可用
            /*boolean exists = redisService.exists(TokenManager.genAvailableTokenKey(claimsId, token));
            if (!exists) {
                throw new APIException(EnumHttp401Error.TOKEN_EXPIRED);
            }*/

            // 是否需要刷新token
            Date now = new Date();

            if (now.after(DateUtils.parseDate(claims.getSubject(), "yyyy-MM-dd HH:mm:ss"))) {
                String refreshTokenKey = TokenManager.genRefreshTokenKey(claimsId);
                String refreshToken = redisService.get(refreshTokenKey);
                // 如果 token 未被刷新过，生成新token
                if (StringUtils.isEmpty(refreshToken)) {
                    refreshToken = TokenManager.createJWT(claimsId);
                    redisService.set(refreshTokenKey, refreshToken, TokenManager.REDIS_REFRESH_TOKEN_EXPIRE);
                    String availableTokenKey = TokenManager.genAvailableTokenKey(claimsId, refreshToken);
                    redisService.set(availableTokenKey, refreshToken, TokenManager.REDIS_AVAILABLE_TOKEN_EXPIRE);
                    redisService.sadd(TokenManager.genTokenHistoryKey(claimsId), availableTokenKey);
                }
                TokenManager.setResponseToken(response, refreshToken);
            }

        } catch (ExpiredJwtException e) {
            throw new APIException(EnumHttp401Error.LOGIN_EXPIRED);
        } catch (SignatureException e) {
            throw new APIException(EnumHttp401Error.NEED_LOGIN);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
