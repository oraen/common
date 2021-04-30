package com.oraen.oxygen.common.util;


import com.alibaba.fastjson.JSONObject;
import com.oraen.oxygen.common.enumeration.HttpMethod;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class HttpUtil {

    final static int DEFAULT_TIMEOUT = 5000;
    final static int DEFAULT_READ_TIMEOUT = 5000;

    private static String normalizeUrl(String url){
        url = url.trim();
        if((!"http://".equalsIgnoreCase(url.substring(0,7))) && (!"https://".equalsIgnoreCase(url.substring(0,8)))){
            url = "http://" + url;
        }
        return url;
    }

    private static String getParamStr(@NotNull Map<String, ?> params){
        if(params.size() == 0){
            return "";
        }
        StringBuilder sbUrl = new StringBuilder();
        for(Map.Entry<String, ?> param : params.entrySet()){
            sbUrl.append(param.getKey());
            sbUrl.append("=");
            sbUrl.append(param.getValue().toString());
            sbUrl.append("&");
        }
        int endIndex = sbUrl.length();
        System.out.println(endIndex);
        sbUrl.delete(endIndex-1, endIndex);
        return sbUrl.toString();
    }

    public static HttpURLConnection request(String url, HttpMethod method, int timeOut, int readTimeout) throws IOException {
        URL u = new URL(normalizeUrl(url));
        HttpURLConnection  conn = (HttpURLConnection) u.openConnection();
        conn.setRequestMethod(method.toString());   //设置本次请求的方式 ， 默认是GET方式， 参数要求都是大写字母
        conn.setConnectTimeout(timeOut);//设置连接超时
        conn.setReadTimeout(readTimeout);
        conn.setDoInput(true);//是否打开输入流 ， 此方法默认为true
        conn.setDoOutput(true);//是否打开输出流， 此方法默认为false

        conn.setRequestProperty("connection", "Keep-Alive");
        return conn;
    }


    public static String get(String url, @Nullable Map<String, ?> params) throws IOException {

        StringBuilder sbUrl = new StringBuilder(url);
        HttpURLConnection conn = null;
        InputStream is = null;

        try{
            //参数拼接
            if(params != null){
                if(url.indexOf('?') == -1){
                    sbUrl.append('?');
                }else{
                    if(StringUtil.getAt(url, -1) != '?'){
                        sbUrl.append('&');
                    }
                }

                sbUrl.append(getParamStr(params));
            }
            conn = request(sbUrl.toString(), HttpMethod.GET, DEFAULT_TIMEOUT, DEFAULT_READ_TIMEOUT);
            conn.connect();

            if(conn.getResponseCode() == 200){
                is = conn.getInputStream();
                String re = SteamUtil.get(is);
                return re;
            }else{
                return "{error:" + conn.getResponseCode() +"}";
            }
        }finally {
            if(conn != null){
                conn.disconnect();
            }

            if(is != null){
                is.close();
            }
        }

    }


    public static String post(String url, @Nullable Map<String, ?> params) throws IOException {
        OutputStream os = null;
        InputStream is = null;
        HttpURLConnection conn = null;

        try{
            conn = request(url, HttpMethod.POST, DEFAULT_TIMEOUT, DEFAULT_READ_TIMEOUT);
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //   conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            os = conn.getOutputStream();
            conn.connect();

            String paramStr = getParamStr(params);
            os.write(paramStr.getBytes(StandardCharsets.UTF_8));
            os.flush();
            os.close();

            if(conn.getResponseCode() == 200){
                is = conn.getInputStream();
                return SteamUtil.get(is);

            }else{
                return "{error:" + conn.getResponseCode() +"}";
            }
        }finally {
            if(conn != null){
                conn.disconnect();
            }

            if(is != null){
                is.close();
            }

            if(os != null){
                os.close();
            }
        }

    }



}
