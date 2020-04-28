package com.zjh.javademo.pattern.chain;

public abstract class AbstractHandler {
    protected AbstractHandler handler;

    public AbstractHandler(){

    }

    public AbstractHandler(AbstractHandler handler){
        this.handler = handler;
    }

    public AbstractHandler getHandler() {
        return handler;
    }

    public void setHandler(AbstractHandler handler) {
        this.handler = handler;
    }

    public abstract  boolean proceed(int value);
}
