package com.oraen.oxygen.common.model.pojo.file;

import com.oraen.oxygen.common.data.collection.box.ByteBox;
import com.oraen.oxygen.common.model.exception.ExceptionWrap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class VirtualFile {

    private static final String DEFAULT_ROOT = "/";

    private static final String DEFAULT_FILE_NAME = "new file";

    private String path;

    private String name;

    private ByteBox content;

    public static VirtualFile fromDev(File file){
        try{
            if(file.isFile()){
                return new VirtualFile(file.getParentFile().getCanonicalPath(), file.getName(), new ByteBox(new FileInputStream(file)));
            }else{
                return new VirtualFile(file.getParentFile().getCanonicalPath(), file.getName(), new byte[0]);            }
        }catch (Exception e){
            throw new ExceptionWrap(e);
        }

    }

    public VirtualFile(){
        this(DEFAULT_FILE_NAME);

    }

    public VirtualFile(String name){
        this(DEFAULT_FILE_NAME, new byte[0]);
    }

    public VirtualFile(byte[] content){
        this(DEFAULT_FILE_NAME, content);
    }

    public VirtualFile(String name, byte[] content){
        this(DEFAULT_ROOT, name, content);
    }

    public VirtualFile(String path, String name, byte[] content){
        this.setPath(path);
        this.setName(name);
        this.setContent(content);
    }

    public VirtualFile(String path, String name, ByteBox content){
        this.setPath(path);
        this.setName(name);
        this.setContent(content);
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        String fmt = path.replaceAll("\\\\", "/");
        fmt = fmt.replaceAll("/{2,}", "/");
        if(fmt.charAt(fmt.length() - 1) != '/'){
            fmt += "/";
        }
        this.path = fmt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.indexOf('/') != -1){
            throw new IllegalArgumentException("文件名格式错误 " + name + " 不可包含/");
        }
        this.name = name;
    }

    public byte[] getContent() {
        return content.get();
    }

    public void setContent(byte[] bytes) {
        setContent(new ByteBox(bytes));
    }

    public void setContent(ByteBox byteBox) {
        this.content = byteBox;
    }

    public void append(byte[] bytes) {
        this.content.add(bytes);
    }

    public void preAppend(byte[] bytes) {
        this.content.insert(0, bytes);
    }

    public File getFile(){
        return new File(path + name);
    }

    public void writeToFile(){
        File file = getFile();
        try{
            if(file.isFile()){
                content.writeTo(new FileOutputStream(file));
            }
        }catch (Exception e){
            throw new ExceptionWrap(e);
        }
    }
}
