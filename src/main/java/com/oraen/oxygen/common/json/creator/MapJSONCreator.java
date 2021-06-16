package com.oraen.oxygen.common.json.creator;

import com.oraen.oxygen.common.json.Creator;

import java.util.Map;

@SuppressWarnings("rawtypes")
public class MapJSONCreator extends Creator<Map> {

    @Override
    public String creatorJSON(Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(Map.Entry<?,?> entry : ((Map<?,?>) map).entrySet()){
            sb.append(first.creator(entry.getKey()));
            sb.append(":");
            sb.append(first.creator(entry.getValue()));
            sb.append(",");
        }

        closeOff(sb, '}');
        return sb.toString();
    }





}
