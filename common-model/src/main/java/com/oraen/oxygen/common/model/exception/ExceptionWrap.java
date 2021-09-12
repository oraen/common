package com.oraen.oxygen.common.model.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExceptionWrap extends RuntimeException {
    private Exception content;

    public ExceptionWrap(Exception e){
        this.content = e;
    }

    public Exception getContent() {
        return content;
    }

    @Override
    public String getMessage() {
        return content.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return content.getLocalizedMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return content.getCause();
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return content.initCause(cause);
    }

    @Override
    public String toString() {
        return content.toString();
    }

    @Override
    public void printStackTrace() {
        content.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        content.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        content.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return content.fillInStackTrace();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return content.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        content.setStackTrace(stackTrace);
    }
}
