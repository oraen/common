package com.oraen.oxygen.common.util.plus;

import com.oraen.oxygen.common.exception.UnavailableDesireException;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderPlus extends StringReader {

    public StringReaderPlus(String str){
        super(str);
    }

    public String readFor(char c) throws IOException, UnavailableDesireException {
        StringBuilder sb = new StringBuilder();
        while(true){
            int read = read();
            if(read == -1){
                break;
            }

            if(read != c){
                sb.append((char) read);
            }else{
                return sb.toString();
            }
        }

        throw new UnavailableDesireException("无法读取到目标字符" + c);

    }
}
