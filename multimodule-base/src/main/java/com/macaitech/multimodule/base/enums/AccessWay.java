package com.macaitech.multimodule.base.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 
 * @author yuhui.tang
 *
 */
public enum AccessWay {
    /**
     * API
     */
    API(1),

    /**
     * 微信
     */
    WEIXIN(2);
    private int type;

    AccessWay(int type) {
        this.type = type;
    }
    @JsonValue
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
