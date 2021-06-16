package com.oraen.oxygen.common.json.creator;


import com.oraen.oxygen.common.json.Creator;

public class JSONCreator {

    Creator<?> creators;

    public JSONCreator(){
        this.creators = new ValueJSONCreator()
                .append(new MapJSONCreator())
                .append(new ColJSONCreator())
                .append(new EntJSONCreator())
                .first;
    }

    public String stringify(Object o){
        return creators.creator(o);
    }

}
