package com.okex.c2c.web;

import java.io.Serializable;

public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int CODE_SUCCESS = 0;

    private static final int CODE_ERROR = 1;

    private Integer code;

    private T data;

    private String msg;

    private String detailMsg;

    public static <T> Result<T> success(T t) {
        Result<T> result = new Result<T>();
        result.setCode(CODE_SUCCESS);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> error(T t) {
        Result<T> result = new Result<T>();
        result.setCode(CODE_ERROR);
        result.setData(t);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

}
