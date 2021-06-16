package com.oraen.oxygen.common.base;

import com.oraen.oxygen.common.base.box.CharBox;
import com.oraen.oxygen.common.exception.CannotGetException;
import com.oraen.oxygen.common.util.StatisticsUtil;

import java.util.Arrays;

public class OString {

    private CharBox value;

    private int current = 0 ;

    public OString(String source){
        this.value = new CharBox(source);
    }

    public OString(char[] chars){
        this.value = new CharBox(chars);
    }

    public OString(){
        this.value = new CharBox();
    }

    /* 增 */
    public void add(int index, char c){
        value.add(index, c);
    }

    public void add(char c){
        value.add(c);
    }

    public void add(int index, char[] chars){
        value.add(index, chars);
    }

    public void add(int index, String str){
        value.add(index, str);
    }

    public void add(String str){
        value.add(str);
    }


    /* 删 */
    public void remove(int index){
        value.remove(index);
    }

    public void remove(int start, int end){
        value.remove(start, end);
    }

    public void pop(){
        value.pop();
    }

    /* 改 */
    public void set(int index, char c){
        value.set(index, c);
    }

    public void set(int index, char[] chars){
        value.set(index, chars);
    }

    public void set(int index, String str){
        value.set(index, str);
    }

    /* 查 */
    public char get(int index){
        return value.get(index);
    }

    /* 查 */
    public String get(int start, int end){
        return String.valueOf(value.get(start, end));
    }

    /* 查 */
    public String get(){
        return String.valueOf(value.get());
    }

    @Override
    public String toString(){
        return value.toString();
    }

    public int size() {
        return value.getSize();
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setValue(String value) {
        this.value = new CharBox(value);
    }

    public int read(){
        if(current > size()){
            return -1;
        }
        return value.get(current ++);
    }

    public String readTo(char c){
        CharBox charBox = new CharBox();
        while(true){
            int r = read();
            if(r == -1){
                throw new CannotGetException("没有发现目标字符 " + c);
            }else if(r == c){
                return charBox.toString();
            }else{
                charBox.add(c);
            }
        }
    }

    public char seekFor(char... chars){
        while(true){
            int r = read();
            if(r == -1){
                throw new CannotGetException("没有发现目标字符 " + r);
            }else{
                for(char c : chars){
                    if(r == c){
                        return c;
                    }
                }
            }
        }
    }

    public String read(int num){
        if(num <= 0){
            throw new IllegalArgumentException("读取的数量必须为正数");
        }
        current += num;
        return String.valueOf(value.get(), current-num, current);
    }
}
