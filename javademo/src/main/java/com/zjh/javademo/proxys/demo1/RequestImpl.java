package com.zjh.javademo.proxys.demo1;

public class RequestImpl implements IRequest {
    @Override
    public String request(String req) {
        System.out.println("real worker is working...");
        return "request is start ..."+req;
    }
}
