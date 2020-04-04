package com.xfj0911.nine.xmall.core.exception;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * 自定义通用全局异常处理累：customer common global
 */
@Data
public class CCGException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;
    private int code;

    public CCGException(String message) {
        super(message);
        this.message = message;
    }

    public CCGException(Throwable cause, String message) {
        super(message,cause);
        this.message = message;
    }

    public CCGException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public CCGException(String message, Throwable cause, int code) {
        super(message, cause);
        this.message = message;
        this.code = code;
    }
}
