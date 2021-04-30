package com.oraen.oxygen.common.util;

import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.common.ToJSON;
import com.oraen.oxygen.common.enumeration.JSONType;
import com.oraen.oxygen.common.exception.StringAnalysisException;
import com.oraen.oxygen.common.exception.UnexpectedException;
import com.sun.istack.internal.NotNull;
import java.lang.reflect.Field;
import java.util.*;

@SuppressWarnings("unchecked")
public class JSON {
    public static String stringify(Object o) {
        if(o == null){
            return "null";
        }
        if(o instanceof String){
            return "\"" + o + "\"";
        }else if(o instanceof Boolean) {
            return o.toString();
        }else if(o instanceof Number){
            String re = o.toString();
            if(StringUtil.getAt(re, -1) == '0' && StringUtil.getAt(re, -2) == '.'){
                re = re.substring(0, re.length()-2);
            }
            return re;
        }else if(o instanceof ToJSON){
            return ((ToJSON) o).toJSON();
        }else if(o instanceof Map){
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for(Map.Entry<?,?> entry : ((Map<?,?>) o).entrySet()){
                sb.append(stringify(entry.getKey().toString()));
                sb.append(":");
                sb.append(stringify(entry.getValue()));
                sb.append(",");
            }

            closeOff(sb, '}');
            return sb.toString();
        }else if(o instanceof Collection){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for(Object obj : (Collection<?>)o){
                sb.append(stringify(obj));
                sb.append(",");
            }

            closeOff(sb, ']');
            return sb.toString();
        }else {
            try{
                Field[] fields = o.getClass().getDeclaredFields();
                StringBuilder sb = new StringBuilder();
                sb.append("{");
                for(Field f : fields){
                    f.setAccessible(true);
                    sb.append(stringify(f.getName()));
                    sb.append(":");
                    sb.append(stringify(f.get(o)));
                    sb.append(",");
                }
                closeOff(sb, '}');
                return sb.toString();
            }catch (IllegalAccessException e){
                throw new UnexpectedException("解析实体类对象失败");
            }
        }

    }

    private static void closeOff(StringBuilder sb, char end){
        if(StringUtil.getAt(sb.toString(), -1) == ','){
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(end);

    }

    public static Map<String, Object> parseMap(@NotNull String jsonStr){
        Object re = parse(jsonStr);
        if(re instanceof Map){
            return (Map<String, Object>) re;
        }
        throw new StringAnalysisException("字符串 " + jsonStr + " 格式不合法， 不能转化为map");
    }

    public static List<Object> parseList(@NotNull String jsonStr){
        Object re = parse(jsonStr);
        if(re instanceof List){
            return (List<Object>) re;
        }
        throw new StringAnalysisException("字符串 " + jsonStr + " 格式不合法， 不能转化为list");
    }


    public static Object parse(@NotNull String jsonStr) {
        String trim = jsonStr.trim();

        JSONType type = JsonAnalyzerAssistant.getTypeRough(trim);
        switch (type){
            case STRING:{
                return trim.substring(1, trim.length()-1);
            } case DEFAULT:{
                return trim;
            } case NUMBER:{
                return Double.parseDouble(trim);
            } case OBJECT:{
                Map<String, Object> re = new HashMap<>();
                String meat = trim.substring(1, trim.length()-1);
                String[] items = meat.split(",");
                for(String item : items) {
                    String[] entry = item.split(":");
                    if(entry.length == 2){
                        String key = parse(entry[0]).toString();
                        Object value = parse(entry[1]);
                        re.put(key, value);
                    }else{
                        throw new StringAnalysisException("字符串 " + jsonStr + "无法被解析， 在 " + item + " 处无法解析");
                    }
                }
                return re;

            } case ARRAY:{
                List<Object> re = new ArrayList<>(10);
                String meat = trim.substring(1, trim.length()-1);
                String[] items = meat.split(",");
                for(String item : items) {
                    re.add(parse(item));
                }
                return re;
            } default:{
                throw new StringAnalysisException("字符串 " + jsonStr + "解析时出现未知异常");
            }

        }


    }


    public static<T> T parse(String jsonStr, Class<T> clazz){
        Map<String, Object> map = parseMap(jsonStr);
        return MapUtil.createEntity(map, clazz);

    }


}

class JsonAnalyzerAssistant{

    public static JSONType getTypeRough(@NotNull String str) {
        if(StringUtil.isBlank(str)) {
            return JSONType.DEFAULT;
        }

        String trim = str.trim();
        int first = StringUtil.getAt(trim, 0);
        int end = StringUtil.getAt(trim, -1);
        if(first == '\'' || first == '"') {
            if(trim.length() > 1 || first == end){
                return JSONType.STRING;
            }else {
                return JSONType.DEFAULT;
            }
        }else if(first == '{') {
            if(end == '}'){
                return JSONType.OBJECT;
            }else {
                return JSONType.DEFAULT;
            }
        }else if(first == '[') {
            if(end == ']'){
                return JSONType.ARRAY;
            }else {
                return JSONType.DEFAULT;
            }
        }else {
            try{
                Double.parseDouble(trim);
                return JSONType.NUMBER;
            }catch (NumberFormatException e){
                return JSONType.DEFAULT;
            }
        }
    }

}
