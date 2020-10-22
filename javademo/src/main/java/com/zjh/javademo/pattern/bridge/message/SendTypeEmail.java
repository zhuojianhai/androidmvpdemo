package com.zjh.javademo.pattern.bridge.message;

public class SendTypeEmail implements SendTyep {
    @Override
    public String sendType() {
        return "Email";
    }
}
