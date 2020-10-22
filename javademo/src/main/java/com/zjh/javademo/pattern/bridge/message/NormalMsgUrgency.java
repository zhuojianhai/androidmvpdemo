package com.zjh.javademo.pattern.bridge.message;

public class NormalMsgUrgency extends MsgUrgency {
    public NormalMsgUrgency(){

    }
    public NormalMsgUrgency(SendTyep sendTyep){
        super(sendTyep);
    }
    @Override
    public String sendType() {
        String sendTypes = super.sendType();
        return "普通消息---发送方式为："+sendTypes;
    }
}
