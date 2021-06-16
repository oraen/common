package com.oraen.oxygen.common.json.creator;

import com.oraen.oxygen.common.exception.OutOfTaskException;
import com.oraen.oxygen.common.json.Creator;

public class ValueJSONCreator extends Creator<Object> {

    Creator<?> creators;

    @Override
    public String creatorJSON(Object o) {
        if(o == null){
            return "null";
        }
        if(o instanceof String){
            return "\"" + o + "\"";
        }else if(o instanceof Number){
            if(((Number) o).intValue() == ((Number) o).doubleValue()){
                return String.valueOf(((Number) o).intValue());
            }else{
                return String.valueOf(o);
            }
        }else if(o instanceof Boolean) {
            return o.toString();
        }

        throw new OutOfTaskException();

    }
}
