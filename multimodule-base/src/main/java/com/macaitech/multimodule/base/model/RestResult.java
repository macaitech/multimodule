package com.macaitech.multimodule.base.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * 统一返回结果RestResult.
 * @author yuhui.tang
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResult<T extends Object> implements Serializable{

	private static final long serialVersionUID = 5484827864359309770L;

	protected static final Logger LOGGER = LoggerFactory.getLogger(RestResult.class);

    /**
     * 返回编码
     */
    @JSONField(ordinal = 1)
    private int status;

    /**
     * 返回消息
     */
    @JSONField(ordinal = 2)
    private String message;

    /**
     * 返回数据
     */
    @JSONField(ordinal = 3)
    private T data;

    public RestResult() {

    }

    public RestResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return StringUtils.trimToEmpty(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestResult(status=" + this.status + ", message=" + this
                .message + ", data=" + JSON.toJSONString(this.data) + ")";
    }
}
