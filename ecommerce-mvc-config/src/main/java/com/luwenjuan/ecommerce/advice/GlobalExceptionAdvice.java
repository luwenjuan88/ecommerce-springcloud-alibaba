package com.luwenjuan.ecommerce.advice;

import com.luwenjuan.ecommerce.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <h1>全局异常捕获处理</h1>
 * 除了用这种方式，还可以选其他方式，比如aop
 *
 * 进行打印日志
 * 对所有包的异常进行捕获
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 这个注解可以对系统中所有异常进行拦截
     * 拦截之后，获取到两个参数，通过这个处理函数进行返回
     * 可以根据value值的设定，捕获自定义异常
     * @param req
     * @param exp
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommerceException(
            HttpServletRequest req, Exception exp
    ){
        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(exp.getMessage());
        log.error("commerce service has error: [{}]", exp.getMessage(), exp);
        return response;
    }
}
