package com.OnlineExam;


/**
 响应码枚举
 */
public enum ResultCode {

    SUCCESS(1000, "SUCCESS"),

    FAILED(1001, "FAILED"),

    VALIDATE_FAILED(1002, "VALIDATE_FAILED"),

    ERROR(5000, "ERROR");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
