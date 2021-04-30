package com.oraen.oxygen.common.util;


import com.sun.istack.internal.NotNull;
import java.util.List;
import java.util.Map;

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

    public static<T> T translate(@NotNull Object source, Class<T> clazz){
        if(clazz.isInstance(source)){
            return (T)source;
        }else{
            String serialization;
            if(source instanceof String){
                serialization = (String)source;
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
            }else if(clazz == Map.class){
                return (T)JSON.parseMap(serialization);
            }else if(clazz == List.class){
                return (T)JSON.parseList(serialization);
            }else{
                return JSON.parse(serialization, clazz);
            }
        }

    }
}
