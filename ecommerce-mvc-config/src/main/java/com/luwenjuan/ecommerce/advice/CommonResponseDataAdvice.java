package com.luwenjuan.ecommerce.advice;

import com.luwenjuan.ecommerce.annotation.IgnoreResponseAdvice;
import com.luwenjuan.ecommerce.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <h1>实现统一响应</h1>
 *
 * ResponseBodyAdvice可以对所有Response进行拦截，和处理
 */
@RestControllerAdvice(value = "com.luwenjuan.ecommerce")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    /**
     * <h1>判断是否需要对响应进行处理</h1>
     * 如果返回false，则不进行处理
     * 如果返回true，则通过beforeBodyWrite进行包装
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        //定义最终返回对象
        CommonResponse<Object> response = new CommonResponse<>(0, "");

        if (null == o){
            return response;
        } else if (o instanceof CommonResponse){
            response = (CommonResponse<Object>)o;
        }else {
            response.setData(o);
        }
        return response;
    }
}
