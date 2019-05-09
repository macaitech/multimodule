package com.macaitech.multimodule.base.model;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author yuhui.tang
 *
 */
public class JsonResult {
    private int status;
    private String message;
    private JSON data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSON getData() {
        return data;
    }

    public void setData(JSON data) {
        this.data = data;
    }
}
