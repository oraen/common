package com.oraen.oxygen.common.core.enumeration.File;

public enum FileSuffix {
    JAVA("java", FileType.TEXT)
    ;

    private final String value;
    private final FileType type;

    FileSuffix(String value, FileType type){
        this.value = value;
        this.type = type;
    }


    FileType type(){
        return type;
    }

    String value(){
        return value;
    }

}
