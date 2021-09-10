package com.oraen.oxygen.common.data.stream;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SteamUtil {

    private static int BUFFER_SIZE = 8192;

    public static String get(InputStream is) throws IOException {
        return new String(getBytes(is), StandardCharsets.UTF_8);
    }

    public static byte[] getBytes(InputStream is) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] bytes = new byte[BUFFER_SIZE];
        while(true){
            int read = bis.read(bytes);
            if(read == -1){
                bis.close();
                break;
            }

        }

        return null;
    }

}
