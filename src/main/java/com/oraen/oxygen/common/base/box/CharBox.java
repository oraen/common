package com.oraen.oxygen.common.base.box;

import com.oraen.oxygen.common.util.StatisticsUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CharBox {

    private char[] chars;

    private int size;

    public CharBox(String str){
        this(str.toCharArray());
    }

    public CharBox(char c){
        this(new char[]{c});
    }

    public CharBox(char[] chars){
        this.chars = chars;
        this.size = chars.length;
    }

    public CharBox(){
        this(16);
    }

    public CharBox(int size){
        this.chars = new char[size];
    }

    /* 增 */
    public void add(int index, char c){
        index = StatisticsUtil.astrict(index, size+1);

        if(chars.length > size+1){
            for(int i=size; i>index; i--){
                chars[i] = chars[i-1];
            }
            chars[index] = c;
        }else{
            char[] newChars = new char[(chars.length + 1)*2];
            for(char i=0; i<index; i++){
                newChars[i] = chars[i];
            }
            newChars[index] = c;
            for(int i=index+1; i<size+1; i++){
                newChars[i] = chars[i-1];
            }
            chars = newChars;
        }
        size++;
    }

    public void add(char c){
        add(size, c);
    }

    public void add(int index, char[] chars){
        index = StatisticsUtil.astrict(index, size+1);
        int len = chars.length;

        if(this.chars.length > size + len){
            //向后移位
            for(int i=size; i>index; i--){
                this.chars[i + len -1] = this.chars[i-1];
            }

            //插入
            for(int i=index, j=0; j<len; i++, j++){
                this.chars[i] = chars[j];
            }
        }else{
            char[] newChars = new char[(this.chars.length + len)*2];
            for(int i=0; i<index; i++){
                newChars[i] = this.chars[i];
            }
            for(int i=index, j=0; j<len; i++, j++){
                newChars[i] = chars[j];
            }
            for(int i=index+len, j=index; j<size; i++, j++){
                newChars[i] = this.chars[j];
            }
            this.chars = newChars;
        }
        size += len;
    }

    public void add(int index, String str){
        add(index, str.toCharArray());
    }

    public void add(String str){
        add(size, str);
    }


    /* 删 */
    public void remove(int index){

        for(int i=index; i<size-1; i++){
            chars[i] = chars[i+1];
        }

        size--;
    }

    public void remove(int start, int end){
        start = StatisticsUtil.astrict(start, size);
        end = StatisticsUtil.astrict(end, size);
        if(end < start){
            throw new IllegalArgumentException();
        }

        int round = end  - start + 1;

        for(int i=start; i<size-round-1; i++){
            chars[i] = chars[i+round];
        }

        size = size - round;
    }

    public void pop(){
        size--;
    }

    /* 改查 */
    public void set(int index, char c){
        index = StatisticsUtil.astrict(index, size);
        chars[index] = c;
    }

    public void set(int index, char[] chars){
        index = StatisticsUtil.astrict(index, size);
        remove(index);
        add(index, chars);
    }

    public void set(int index, String str){
        set(index, str.toCharArray());
    }

    /* 查 */
    public char get(int index){
        index = StatisticsUtil.astrict(index, size);
        return chars[index];
    }

    /* 查 */
    public char[] get(int start, int end){
        start = StatisticsUtil.astrict(start, size);
        end = StatisticsUtil.astrict(end, size);
        return Arrays.copyOfRange(chars, start, end);
    }

    /* 查 */
    public char[] get(){
        return get(0, size-1);
    }

    @Override
    public String toString(){
        return String.valueOf(chars, 0, size);
    }

    public int getSize() {
        return size;
    }
}
