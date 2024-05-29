package com.course.backend.utils;

public enum ResultCode {
    /**
     * 默认成功值
     */
    SUCCESS(1000, "响应成功"),
    FAIL(1001, "响应失败"),

    /**
     * 数据库操作
     */
    PARAMETER_ERROR(804, "参数错误"),
    REPEAT_RECORD(807, "重复记录"),
    RECORD_NOT_EXIST(808, "记录不存在"),
    RECORD_EXISTS(809, "记录已存在"),

    /**
     * 用户操作
     */
    USER_SUCCESS(3000, "操作成功"),
    USER_NOT_EXIST(3001, "用户不存在"),
    USER_EXISTS(3005, "用户已存在"),
    USER_PASSWORD_ERROR(3002, "密码错误"),
    USER_PERMISSION_DENIED(3004, "权限不足");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}