package com.course.backend.utils;

import lombok.Data;

@Data
public class R<T> {
    private int success;
    private int code;
    private String message;
    private T data;

    public static <T> R<T> success(ResultCode resultCode, T data) {
        R<T> r = new R<>();
        r.success = 1;
        r.setCode((int) resultCode.getCode());
        r.setMessage(resultCode.getMsg());
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(ResultCode resultCode, T data) {
        R<T> r = new R<>();
        r.success = 0;
        r.setCode((int) resultCode.getCode());
        r.setMessage(resultCode.getMsg());
        r.setData(data);
        return r;
    }

}
