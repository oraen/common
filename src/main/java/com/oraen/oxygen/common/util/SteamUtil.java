package com.oraen.oxygen.common.util;

import com.oraen.oxygen.common.exception.UnexpectedException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class SteamUtil {

    private static int BUFFER_SIZE = 8192;

    public static String get(InputStream is) throws IOException {
        return new String(getBytes(is), StandardCharsets.UTF_8);
    }

    public static byte[] getBytes(InputStream is) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        int size = is.available();
        byte[] bytes = new byte[size];
        int read = bis.read(bytes);
        bis.close();
        if(size == read){
            return bytes;
        }else{
            throw new UnexpectedException("获取byte数组时发生异常 大小为" + size + "，实际上是 " + read);
        }
    }

}
