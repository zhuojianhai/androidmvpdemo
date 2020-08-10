package com.zjh.javademo.pattern.bridge.message;

public class Client {
    public static void main(String[] args) {
        MsgUrgency msgUrgency = new NormalMsgUrgency();
        SendTyep sendTyep = new SendTypeEmail();
        msgUrgency.setSendTyep(sendTyep);

        String result = msgUrgency.sendType();
        System.out.println(result);
    }
}
