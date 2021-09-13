package com.oraen.oxygen.common.device.file;

import com.oraen.oxygen.common.data.stream.SteamUtil;
import com.oraen.oxygen.common.model.GlobalConfig;
import com.oraen.oxygen.common.model.exception.ErrorOPException;
import com.oraen.oxygen.common.model.exception.ExceptionWrap;
import com.oraen.oxygen.common.model.pojo.file.VirtualFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileRWUtil {

    public static byte[] getByte(File file){
        try {
            if(file.isFile()){
                return SteamUtil.getBytes(new FileInputStream(file));
            }

            throw new ErrorOPException("不能读取目录的内容");
        } catch (FileNotFoundException e) {
            throw new ExceptionWrap(e);
        }
    }

    public static byte[] getByte(String fullName){
        return getByte(new File(fullName));
    }

    public static String getText(File file){
        return new String(getByte(file), GlobalConfig.DEFAULT_CHARSET);
    }

    public static String getText(String fullName){
        return getText(new File(fullName));
    }

    public static void write(File file, byte[] content){
        VirtualFile.fromDev(file)
                .setContent(content)
                .writeToFile();
    }

    public static void write(String fullName, byte[] content){
        write(new File(fullName), content);
    }

    public static void write(File file, String content){
        write(file, content.getBytes(GlobalConfig.DEFAULT_CHARSET));
    }

    public static void write(String fullName, String content){
        write(fullName, content.getBytes(GlobalConfig.DEFAULT_CHARSET));
    }

    public static void append(File file, byte[] content){
        VirtualFile.fromDev(file)
                .append(content)
                .writeToFile();
    }

    public static void append(String fullName, byte[] content){
        append(new File(fullName), content);
    }

    public static void append(File file, String content){
        append(file, content.getBytes(GlobalConfig.DEFAULT_CHARSET));
    }

    public static void append(String fullName, String content){
        append(fullName, content.getBytes(GlobalConfig.DEFAULT_CHARSET));
    }

    public static void preAppend(File file, byte[] content){
        VirtualFile.fromDev(file)
                .preAppend(content)
                .writeToFile();
    }

    public static void preAppend(String fullName, byte[] content){
        write(new File(fullName), content);
    }

    public static void preAppend(File file, String content){
        write(file, content.getBytes(GlobalConfig.DEFAULT_CHARSET));
    }

    public static void preAppend(String fullName, String content){
        write(fullName, content.getBytes(GlobalConfig.DEFAULT_CHARSET));
    }

    public static void clear(File file){
        VirtualFile.fromDev(file)
                .clear()
                .writeToFile();
    }

    public static void clear(String fullName){
        clear(new File(fullName));
    }




}
