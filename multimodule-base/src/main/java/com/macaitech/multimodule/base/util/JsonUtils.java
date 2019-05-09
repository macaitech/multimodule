package com.macaitech.multimodule.base.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * JSON Utils
 * @author yuhui.tang
 *
 */
public class JsonUtils {
    protected final static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    /**
     * 对象转JSON
     *
     * @param t
     * @return
     */
    public static String buildToJson(Object t) {
        if (t == null) {
            return null;
        }
        String json = null;
        try {
            json = mapper.writeValueAsString(t);
            return json;
        } catch (Exception e) {
            logger.error(":>>> buildToJson error,[errorMag] is:\n{}",e.getMessage());

        }

        return json;
    }

    //TODO:
    public static Object buildFromJson(String data, Object clazz) {
        try {
            return mapper.readValue(data, clazz.getClass());
        } catch (IOException e) {
            logger.error(":>>> buildFromJson error,[errorMag] is:\n{}", e.getMessage());
        }
        return null;

    }

    public static Object buildFromJson(String data, Object clazz, Object... args) {
        try {
            for (Object o : args) {
                mapper.getTypeFactory().constructParametricType(List.class, o.getClass());
            }
            return mapper.readValue(data, clazz.getClass());
        } catch (IOException e) {
            logger.error(":>>> buildFromJson error,[errorMag] is:\n{}",e.getMessage());
        }
        return null;

    }
}
