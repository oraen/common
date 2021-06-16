package com.oraen.oxygen.common.json.creator;

import com.oraen.oxygen.common.exception.UnexpectedException;
import com.oraen.oxygen.common.json.Creator;
import com.oraen.oxygen.common.json.ToJSON;

import java.lang.reflect.Field;

public class EntJSONCreator extends Creator<Object> {

    @Override
    public String creatorJSON(Object obj) {
        if(obj instanceof ToJSON){
            return ((ToJSON) obj).toJSON();
        }
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Field f : fields) {
                sb.append(first.creator(f.getName()));
                sb.append(":");
                sb.append(first.creator(f.get(obj)));
                sb.append(",");
            }
            closeOff(sb, '}');
            return sb.toString();
        } catch (IllegalAccessException e) {
            throw new UnexpectedException("解析实体类对象失败");
        }
    }
}
