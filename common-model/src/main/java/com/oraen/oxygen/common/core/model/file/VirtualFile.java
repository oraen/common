package com.oraen.oxygen.common.core.model.file;

import java.util.Arrays;

public class VirtualFile {

    private static final String DEFAULT_ROOT = "/";

    private static final String DEFAULT_FILE_NAME = "new file";

    private String path;

    private String name;

    private byte[] content;

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
        return content;
    }

    public void setContent(byte[] content) {
        if(content == null){
            content = new byte[0];
        }
        this.content = content;
    }

    public void append(byte[] content) {
        byte[] n = new byte[this.content.length + content.length];
        System.arraycopy(this.content, 0, n, 0, this.content.length);
        System.arraycopy(content, 0, n, this.content.length, content.length);
        this.content = n;
    }

    public void preAppend(byte[] content) {
        byte[] n = new byte[this.content.length + content.length];
        System.arraycopy(content, 0, n, 0, content.length);
        System.arraycopy(this.content, 0, n, content.length, this.content.length);
        this.content = n;
    }
}
