package com.hty.spring5.core.model;

public class ResultWrapper<T> {
    public static int SUCCESS = 0;
    public static int FAIL = 1;
    private int code;
    private String msg;
    private T data;

    public ResultWrapper() {
    }

    public ResultWrapper(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultWrapper(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultWrapper asSuccess() {
        return new ResultWrapper(SUCCESS, "");
    }

    public static <T> ResultWrapper asSuccess(T data) {
        return new ResultWrapper(SUCCESS, "", data);
    }

    public static <T> ResultWrapper asError(String msg) {
        return new ResultWrapper(FAIL, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
