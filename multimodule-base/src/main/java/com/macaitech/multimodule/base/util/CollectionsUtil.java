package com.macaitech.multimodule.base.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务列表转换工具类
 * @author xiexiaogang
 *
 */
public class CollectionsUtil {
	
	/**
	 * list转换为业务结构体
	 * @param list			数据列表
	 * @param propertyName 需要操作的成员变量
	 * @param key1			第一个key
	 * @param key2			第二个key
	 * @param separator		分隔符列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<Map<String, Object>> list2Struct(List<T> list, String propertyName, String key1, String key2, String... separator) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		try {
			if (list.size() > 0) {
				Field field = null;
				for (int i = 0; i < list.size(); i++ ) {
					T t = list.get(i);
					if (field == null) {
						field= t.getClass().getDeclaredField(propertyName);
						field.setAccessible(true);
					}
					String tempKey = String.valueOf(field.get(t));
					/*if (tempKey.length() == 8) {
						if (separator.length == 1) {
							tempKey = tempKey.substring(0, 4) + separator[0] + tempKey.substring(4, 6) + separator[0] + tempKey.substring(6, 8);
						} else {
							tempKey = tempKey.substring(0, 4) + separator[0] + tempKey.substring(4, 6) + separator[1] + tempKey.substring(6, 8) + separator[2];
						}
					}*/
					Map<String, Object> tempMap = null;
					List<T> tempTodays = null;
					if (i == 0) {
						tempTodays = new ArrayList<T>();
						tempMap = new HashMap<String, Object>();
						tempMap.put(key1, tempKey);
						tempMap.put(key2, tempTodays);
						result.add(tempMap);
					} else {
						tempMap = result.get(result.size() - 1);
						if (!tempKey.equals(tempMap.get(key1))) {
							tempTodays = new ArrayList<T>();
							tempMap = new HashMap<String, Object>();
							tempMap.put(key1, tempKey);
							tempMap.put(key2, tempTodays);
							result.add(tempMap);
						} else {
							tempTodays = (List<T>) tempMap.get(key2);
						}
					}
					//field.set(t, null);
					tempTodays.add(t);
				}
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * list to string
	 * @param elements
	 * @param split
	 * @return
	 */
	public static String toString(List<String> a, String split) {
		if (a == null)
            return "null";
        int iMax = a.size() - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a.get(i));
            if (i == iMax)
                return b.toString();
            b.append(split);
        }
	}

}
