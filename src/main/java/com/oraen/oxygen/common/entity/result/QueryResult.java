package com.oraen.oxygen.common.entity.result;

import java.util.List;
import java.util.Map;

public class QueryResult extends DataResult{

    private Integer length;

    public QueryResult(boolean success, List<Map<String, Object>> data, String code, String message, Map<String, Object> extra) {
        super(success, data, code, message, extra);
        if(data == null){
            this.length = 0;
        }else{
            this.length = data.size();
        }
    }

    @Override
    public void setData(Object data){
        if(data instanceof List){
            this.setData(data);
            this.length = ((List<?>) data).size();
        }
        throw new IllegalArgumentException("只能接收List<Map<String, Object>> 类型的data");
    }

    public static QueryResult getSuccessResult(List<Map<String, Object>> data){
        return getSuccessResult(data, null);
    }

    public static QueryResult getSuccessResult(List<Map<String, Object>> data, String message){
        return new QueryResult(true, data, "0", message, null);
    }

    public static QueryResult getFailResult(String message, String code){
        return new QueryResult(false, null, code, message, null);
    }

    public static QueryResult getFailResult(String message){
        return getFailResult(message, "-1");
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getData() {
        return (List<Map<String, Object>>)super.getData();
    }

    public Integer getLength() {
        return length;
    }

    public QueryResult addExtra(Object... objects){
        super.addExtra(objects);
        return this;

    }
}
