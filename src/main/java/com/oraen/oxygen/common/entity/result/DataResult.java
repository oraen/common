package com.oraen.oxygen.common.entity.result;

import java.util.HashMap;
import java.util.Map;

public class DataResult extends Result {

    private Object data;

    public DataResult(boolean success, Object data, String code, String message, Map<String, Object> extra) {
        super(success, code, message, extra);
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DataResult addExtra(Object... objects){
        super.addExtra(objects);

        return this;

    }
}
