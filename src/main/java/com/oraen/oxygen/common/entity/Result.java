package com.oraen.oxygen.common.entity;

import com.oraen.oxygen.common.ToJSON;
import com.oraen.oxygen.common.util.JSON;

import java.util.Map;

public class Result {
    private boolean success;

    private String code;

    private String message;

    private Object data;

    private Map<String, Object> extra;

    public static Result getSuccessResult(Object data){
        Result result = new Result();
        result.setCode("0");
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result getSuccessResult(){
        return getSuccessResult(null);
    }

    public static Result getFailResult(String message, String code){
        Result result = new Result();
        result.setMessage(message);
        result.setCode(code);
        result.setSuccess(false);
        return result;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
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
}
