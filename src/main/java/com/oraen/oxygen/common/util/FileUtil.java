package com.oraen.oxygen.common.util;

import com.oraen.oxygen.common.enumeration.FileType;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtil {

    public static FileType getType(String name){
        String suffix = getSuffix(name);
        if("jpg".equalsIgnoreCase(suffix) || "png".equalsIgnoreCase(suffix) || "gif".equalsIgnoreCase(suffix) || "jpeg".equalsIgnoreCase(suffix)){
            return FileType.IMAGE;
        }else if("mp4".equalsIgnoreCase(suffix) || "avi".equalsIgnoreCase(suffix) || "mpeg".equalsIgnoreCase(suffix) || "asf".equalsIgnoreCase(suffix) || "rm".equalsIgnoreCase(suffix) || "navi".equalsIgnoreCase(suffix) || "wmv".equalsIgnoreCase(suffix)){
            return FileType.VIDEO;
        }else if("txt".equalsIgnoreCase(suffix)){
            return FileType.TEXT;
        }else if("exe".equalsIgnoreCase(suffix)){
            return FileType.EXECUTE;
        }else if("zip".equalsIgnoreCase(suffix) || "rar".equalsIgnoreCase(suffix) || "tar".equalsIgnoreCase(suffix)){
            return FileType.COMPRESS;
        }else if("mp3".equalsIgnoreCase(suffix)){
            return FileType.VOICE;
        }else{
            return FileType.OTHER;
        }
    }

    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static boolean setText(String path, String text) {
        return setText(new File(path), text);
    }

    public static boolean setText(File file, String text) {
        try{
            FileWriter fw =new FileWriter(file);
            fw.write(text);
            fw.flush();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addText(File file, String text) {
        try{
            FileWriter fw =new FileWriter(file, true);
            fw.write(text);
            fw.flush();

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean addText(String path, String text) {
        return addText(new File(path), text);
    }

    public static FileInputStream read(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public static InputStream read(String path) throws FileNotFoundException {
        return read(new File(path));

    }

    public static String getText(File file) throws IOException {

        StringBuilder sb = new StringBuilder();
        try (InputStream in = read(file)) {
            return SteamUtil.get(in);
        }
    }

    public static String getText(String path) throws IOException {
        return getText(new File(path));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getText("C:\\Users\\Corki\\Desktop\\corki\\test\\asd.txt"));
    }


}
