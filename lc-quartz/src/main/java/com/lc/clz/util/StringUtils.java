package com.lc.clz.util;

import java.util.List;
import java.util.Map;

public enum StringUtils {
    getStringUtil;
    //是否为空
    public boolean isEmpty(String str) {
        return (str == null) || (str.length() == 0) || (str.equals(""));
    }
    //去空格
    public String trim(String str) {
        return str == null ? null : str.trim();
    }
    //获取Map参数值
    public String getMapString(Map<String, String> map) {
        String result = "";
        for (Map.Entry entry : map.entrySet()) {
            result += entry.getValue() + " ";
        }
        return result;
    }
    //获取List参数值
    public String getListString(List<String> list) {
        String result = "";
        for (String s : list) {
            result += s + " ";
        }
        return result;
    }
}

