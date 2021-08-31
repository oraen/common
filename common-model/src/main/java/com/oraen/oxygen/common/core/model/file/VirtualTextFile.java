package com.oraen.oxygen.common.core.model.file;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class VirtualTextFile extends VirtualFile{

    private Charset charset  = StandardCharsets.UTF_8;


    public VirtualTextFile() {
    }

    public VirtualTextFile(String name) {
        super(name);
    }

    public VirtualTextFile(byte[] content) {
        super(content);
    }

    public VirtualTextFile(String name, byte[] content) {
        super(name, content);
    }

    public VirtualTextFile(String path, String name, byte[] content) {
        super(path, name, content);
    }

    public String getText() {
        return new String(getContent(), charset);
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setContent(String text) {
        super.setContent(text.getBytes(charset));
    }

    public void append(String text) {
        super.append(text.getBytes(charset));
    }

    public void preAppend(String text) {
        super.preAppend(text.getBytes(charset));
    }
}
