package com.zjh.javademo.pattern.bridge.message;

public class SendTypePhoone implements SendTyep {
    @Override
    public String sendType() {
        return "Phone";
    }
}
