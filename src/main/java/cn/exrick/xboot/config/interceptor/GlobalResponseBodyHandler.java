package cn.exrick.xboot.config.interceptor;

import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.Result;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.File;

@RestControllerAdvice("com.sudao")
public class GlobalResponseBodyHandler implements ResponseBodyAdvice<Object> {

    private static final Logger logger = LoggerFactory.getLogger(GlobalResponseBodyHandler.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        logger.debug("MyResponseBodyAdvice==>supports:" + converterType);
        logger.debug("MyResponseBodyAdvice==>supports:" + methodParameter.getClass());
        logger.debug("MyResponseBodyAdvice==>supports:" + MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType));
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body == null) {
            return null;
        }
        if (body instanceof Result || body instanceof File) {
            return body;
        } else {
            logger.debug("MyResponseBodyAdvice==>beforeBodyWrite:" + returnType + "," + body);
            Result<Object> result = ResultUtil.data(body);
            return (body instanceof String) ? JSONUtil.toJsonStr(result) : result;
        }
    }
}
