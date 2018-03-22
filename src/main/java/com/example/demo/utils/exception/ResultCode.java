package com.example.demo.utils.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuYJ
 * @since 22/03/2018
 */
public class ResultCode {
    private static Map<Integer, String> resultMap = new HashMap<>();

    public static final int REQUEST_NO_RESULT = 0;
    public static final int REQUEST_FAILED = 1;

    public static final int UNKNOWN_ERROR = -99;

    static {
        resultMap.put(REQUEST_NO_RESULT, "请求无响应");
        resultMap.put(REQUEST_FAILED, "请求异常");
        resultMap.put(UNKNOWN_ERROR, "未知错误");
    }

    /**
     * 返回码信息
     *
     * @param code 返回码
     * @return 返回信息
     */
    public static String getMsg(int code) {
        if (resultMap.containsKey(code)) {
            return resultMap.get(code);
        }
        return resultMap.get(UNKNOWN_ERROR);
    }
}
