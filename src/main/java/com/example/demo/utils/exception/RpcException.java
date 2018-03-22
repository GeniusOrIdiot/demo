package com.example.demo.utils.exception;

/**
 * @author LiuYJ
 * @since 22/03/2018
 */
public class RpcException extends BaseException {
    public RpcException(int code) {
        super(code);
    }

    public RpcException(int code, String msg) {
        super(code, msg);
    }
}
