package com.oraen.oxygen.common.json.creator;

import com.oraen.oxygen.common.json.Creator;

import java.util.Collection;

@SuppressWarnings("rawtypes")
public class ColJSONCreator extends Creator<Collection> {

    @Override
    public String creatorJSON(Collection col) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Object obj : col){
            sb.append(first.creator(obj));
            sb.append(",");
        }

        closeOff(sb, ']');
        return sb.toString();
    }


}
