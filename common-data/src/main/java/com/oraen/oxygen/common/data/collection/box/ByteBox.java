package com.oraen.oxygen.common.data.collection.box;

import com.oraen.oxygen.common.math.statistics.StatisticsUtil;
import jdk.jfr.Threshold;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ByteBox {
    public static double THRESHOLD = 0.75;

    public static int EXPAND = 2;

    public static int DEFAULT_SIZE = 16384;

    public static Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private byte[] bytes;

    private int size = 0;

    public ByteBox add(byte b){
        checkAddSpace(1);
        bytes[size] = b;
        size ++;
        return this;
    }

    public ByteBox add(byte[] bs){
        int len = bs.length;
        checkAddSpace(len);
        System.arraycopy(bs, 0, bytes, size, len);
        size += len;
        return this;
    }

    public ByteBox remove(int index){
        checkIndex(index);
        int end = size - 1;
        System.arraycopy(bytes, index + 1, bytes, index, end - index);
        size --;
        return this;
    }

    public ByteBox remove(int startIndex, int endIndex){
        checkArg(startIndex, endIndex);
        int len = endIndex - startIndex;
        int end = size - 1;
        System.arraycopy(bytes, startIndex + len, bytes, startIndex, end - endIndex);
        size -= len;
        return this;
    }

    public ByteBox clear(){
        size = 0;
        return this;
    }

    public ByteBox set(int index, byte b){
        checkIndex(index);
        bytes[index]  = b;
        return this;
    }

    public ByteBox set(int index, byte[] bs){
        int len = bs.length;
        int canSize = index + len + 1;
        checkIndex(index);
        checkSpace(canSize);
        System.arraycopy(bs, 0, bytes, index, len);
        size = StatisticsUtil.max(size, canSize);
        return this;
    }

    public ByteBox insert(int index, byte b){
        checkIndex(index);
        checkAddSpace(1);
        int end = size - 1;
        System.arraycopy(bytes, index, bytes, index + 1, end - index);
        size ++;
        return this;

    }

    public ByteBox insert(int index, byte[] bytes){
        return this;
    }

    public byte get(int index){
        checkIndex(index);
        return bytes[index];
    }

    public byte[] get(int startIndex, int endIndex){
        checkArg(startIndex, endIndex);
        int len = endIndex - startIndex;
        byte[] re = new byte[len];
        System.arraycopy(bytes, startIndex, re, 0, len);
        return re;
    }

    public byte[] get(){
        return get(0, size);
    }

    public int size(){
        return size;
    }

    public byte[] toBytes(){
        byte[] re = new byte[size];
        System.arraycopy(bytes, 0, re, 0, size);
        return re;
    }

    @Override
    public String toString(){
        return new String(bytes, 0, size, DEFAULT_CHARSET);
    }

    private void checkAddSpace(int willAdd){
        checkSpace(size + willAdd);
    }

    private void checkSpace(int will){
        int space = bytes.length;
        int need = space;
        while(will > need * THRESHOLD){
            need = need * EXPAND;
        }

        if(need > space){
            expand(need);
        }
    }

    private void checkArg(int... indexes){
        for(int index : indexes){
            if(index > size || index < 0){
                throw new IllegalArgumentException("传入参数 " + index + " 无效");
            }
        }
    }

    private void checkIndex(int index){
        if(index >= size || index < 0){
            throw new IllegalArgumentException("访问的索引不得超过size的值 " + size + "  或小于0");
        }
    }

    private void expand(int size){
        byte[] newBytes = new byte[size];
        System.arraycopy(bytes, 0, newBytes, 0, size);
        this.bytes = newBytes;
    }


}
