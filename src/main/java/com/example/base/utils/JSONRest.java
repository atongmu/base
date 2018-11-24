package com.example.base.utils;

import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2018-09-14 20:51
 * @Description:
 */
public class JSONRest {
    private Integer code;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JSONRest() {
        super();
    }

    public JSONRest(Integer code,String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
