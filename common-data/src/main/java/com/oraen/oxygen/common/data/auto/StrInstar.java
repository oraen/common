package com.oraen.oxygen.common.data.auto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.common.data.collection.ListConverterUtil;
import com.oraen.oxygen.common.data.map.Shelf;
import com.oraen.oxygen.common.data.string.StringUtil;
import com.oraen.oxygen.common.model.GlobalConfig;
import com.oraen.oxygen.common.model.exception.TypeTransitionException;
import com.oraen.oxygen.common.model.exception.UnexpectedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrInstar implements Instar{
    private String value;

    private Object data;

    private Type type;

    private Object jsonCache;

    public StrInstar(Object data){
        this.data = data;
        this.value = JSON.toJSONString(data);
   // 懒加载type提高性能    this.type = Type.classify(this.value);
    }

    @Override
    public double getNum() {
        Type type = getType();
        try{
            if(type == Type.DATA){
                return Double.parseDouble(StringUtil.compress(value));

            }else if(type == Type.LIST){
                return new StrInstar(((JSONArray)jsonCache).get(0)).getNum();
            }else if(type == Type.OBJ){
                return new StrInstar(((JSONObject)jsonCache).get("value")).getNum();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        throw new TypeTransitionException(data, double.class);
    }

    @Override
    public int getInt() {
        return (int)getNum();
    }

    @Override
    public boolean getBoolean() {
        return ! (data == null);
    }

    @Override
    public byte[] getBytes() {
        return value == null ? new byte[0] : value.getBytes(GlobalConfig.getDefaultCharset());
    }

    @Override
    public String getString() {
        return value;
    }

    @Override
    public Map<String, Object> getMap() {
        Type type = getType();
        if(type == Type.OBJ){
            return (JSONObject)jsonCache;
        }else if(type == Type.LIST){
            return ListConverterUtil.toSKMap((JSONArray)jsonCache);
        }else if(type == Type.NULL){
            return new Shelf();
        }else{
            return new Shelf("value", data);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> getList(Class<T> clazz) {
        Type type = getType();
        try{
            if(type == Type.LIST){
                return ((JSONArray)jsonCache).toJavaList(clazz);
            }else if(type == Type.OBJ){
                T t = ((JSONObject)jsonCache).toJavaObject(clazz);
                List<T> re =  new ArrayList<>();
                re.add(t);
                return  re;
            }else if(type == Type.NULL){
                return new ArrayList<>();
            }else{
                List<T> re = new ArrayList<>();
                re.add(getEntity(clazz));
                return re;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        throw new TypeTransitionException(data, Map.class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getEntity(Class<T> clazz) {
        Type type = getType();
        try{
            if(type == Type.LIST){
                return new StrInstar(((JSONArray)jsonCache).get(0)).getEntity(clazz);
            }else if(type == Type.OBJ){
                return  ((JSONObject)jsonCache).toJavaObject(clazz);
            }else if(type == Type.NULL){
                return JSON.parseObject("{}", clazz);
            }else{
                if(clazz == String.class){
                    return  (T)value;
                }else{
                    return JSON.parseObject(value, clazz);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        throw new TypeTransitionException(data, Map.class);
    }

    public String getValue(){
        return value;
    }

    public Object getData() {
        return data;
    }

    public Type getType() {
        if(type == null){
            classify();
        }
        return type;
    }

    private void classify(){
        if(StringUtil.isBlank(value)){
            type = Type.NULL;
        }

        try{
            Object jsonObj = JSON.parse(value);
            if (jsonObj instanceof JSONObject) {
                type = Type.OBJ;
            }else if(jsonObj instanceof JSONArray){
                type = Type.LIST;
            }else {
                throw new UnexpectedException("未知的类型 " + jsonObj.getClass().getName());
            }

            jsonCache = jsonObj;
        }catch (JSONException e){
            type = Type.DATA;
        }

    }


    enum Type {
        LIST
        ,OBJ
        ,DATA
        ,NULL;

    }


}
