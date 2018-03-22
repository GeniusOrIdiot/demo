package com.example.demo.utils.exception;

/**
 * @author LiuYJ
 * @since 22/03/2018
 */
public class BaseException extends RuntimeException {
    private int code;
    private String msg;

    BaseException(int code) {
        this.code = code;
        this.msg = ResultCode.getMsg(code);
    }

    BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
