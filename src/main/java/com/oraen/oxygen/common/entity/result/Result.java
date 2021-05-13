package com.oraen.oxygen.common.entity.result;

import com.oraen.oxygen.common.util.JSON;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private boolean success;

    private String code;

    private String message;

    private Map<String, Object> extra;

    public Result(boolean success, String code, String message, Map<String, Object> extra) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.extra = extra;
    }

    public Result() {
    }

    public static Result getSuccessResult(String message){
        return new Result(true, "0", message, null);
    }

    public static Result getSuccessResult(){
        return getSuccessResult(null);
    }

    public static Result getFailResult(String message, String code){
        return new Result(false, code, message, null);
    }

    public static Result getFailResult(String message){
        return getFailResult(message, "-1");
    }

    public static Result getFailResult(){
        return getFailResult("");
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return JSON.stringify(this);
    }

    public Result addExtra(Object... objects){
        if(extra == null){
            extra = new HashMap<String, Object>();
        }

        for(int i=0; i<objects.length-1; i+=2){
            extra.put(objects[i].toString(), objects[i+1]);
        }

        return this;

    }
}
