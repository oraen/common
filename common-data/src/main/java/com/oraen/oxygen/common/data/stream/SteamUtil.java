package com.oraen.oxygen.common.data.stream;


import com.oraen.oxygen.common.data.collection.box.ByteBox;
import com.oraen.oxygen.common.model.exception.ExceptionWrap;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SteamUtil {

    public static String get(InputStream is) {
        return new String(getBytes(is), StandardCharsets.UTF_8);
    }

    public static byte[] getBytes(InputStream is) {
        try {
            return getByteBox(is).get();
        }catch (Exception e){
            throw new ExceptionWrap(e);
        }
    }

    public static ByteBox getByteBox(InputStream is) {
        return new ByteBox(is);
    }




}
