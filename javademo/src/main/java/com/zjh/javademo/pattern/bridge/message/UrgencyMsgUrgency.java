package com.zjh.javademo.pattern.bridge.message;

public class UrgencyMsgUrgency extends MsgUrgency {
    public UrgencyMsgUrgency(){

    }

    public UrgencyMsgUrgency(SendTyep sendTyep){
        super(sendTyep);
    }

    @Override
    public String sendType() {
        String sendType = super.sendType();
        return "紧急消息--发送类型为："+sendType;
    }
}
