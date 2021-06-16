package com.oraen.oxygen.common.exception;

public class OutOfTaskException extends RuntimeException{

    public OutOfTaskException(String message){
        super(message);
    }

    public OutOfTaskException(){
        super();
    }
}
