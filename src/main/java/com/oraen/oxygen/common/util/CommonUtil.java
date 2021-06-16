package com.oraen.oxygen.common.util;


import java.util.List;
import java.util.Map;
import com.oraen.oxygen.common.util.JSON;

@SuppressWarnings("unchecked")
public class CommonUtil {
    public static<T> T create(Class<T> clazz) {
        try{
            return clazz.getDeclaredConstructor().newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static<T> T translate(Object source, Class<T> clazz){
        if(source == null || clazz == null){
            return null;
        }

        if(clazz.isInstance(source)){
            return (T)source;
        }else{
            String serialization;
            if(source instanceof String){
                serialization = (String)source;
                if(StringUtil.isBlank(serialization)){
                    return null;
                }
            }else{
                serialization = JSON.stringify(source);
            }

            if(clazz == String.class){
                return (T)serialization;
            }else if(clazz == Integer.class || clazz == int.class){
                return (T)Integer.valueOf(Double.valueOf(serialization).intValue());
            }else if(clazz == Float.class || clazz == float.class){
                return (T)Float.valueOf(serialization);
            }else if(clazz == Double.class || clazz == double.class){
                return (T)Double.valueOf(serialization);
            }else if(clazz == Long.class || clazz == long.class){
                return (T)Long.valueOf(Double.valueOf(serialization).intValue());
            }else if(clazz == Short.class || clazz == short.class){
                return (T)Short.valueOf(Double.valueOf(serialization).shortValue());
            }else if(clazz == Byte.class || clazz == byte.class){
                return (T)Byte.valueOf(serialization);
            }else if(clazz == Boolean.class || clazz == boolean.class){
                if(StringUtil.isBlank(serialization) || "false".equalsIgnoreCase(serialization) || "null".equalsIgnoreCase(serialization)){
                    return (T)Boolean.FALSE;
                }else{
                    return (T)Boolean.TRUE;
                }
            }else if(Map.class.isAssignableFrom(clazz)){
                return (T)JSON.parseMap(serialization);
            }else if(List.class.isAssignableFrom(clazz)){
                return (T)JSON.parseList(serialization);
            }else{
                return JSON.parse(serialization, clazz);
            }
        }

    }

}
