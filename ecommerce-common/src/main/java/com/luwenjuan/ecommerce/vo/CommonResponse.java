package com.luwenjuan.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <h1>通用响应对象定义</h1>
 *
 * {
 *     "code": 0,
 *     "message": "",
 *     "data": {}
 * }
 *
 * 由于有很多controler，都回不同的json，前端很难有统一的标识去解析他们，所以需要通用的响应对象
 * data通常是范型
 *
 * 采用lombok注解，自动生成get，set函数等等
 *
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    /** 错误码 */
    private Integer code;

    /** 错误消息 */
    private String message;

    /** 泛型响应数据 */
    private T data;

    public CommonResponse(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
