package com.yy.enums;

public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(1, "成功"),
    PRIMARY_SCHOOL(100, "上小学"),
    MIDDLE_SCHOOL(101, "上初中"),
    ERROR(0, "失败"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
