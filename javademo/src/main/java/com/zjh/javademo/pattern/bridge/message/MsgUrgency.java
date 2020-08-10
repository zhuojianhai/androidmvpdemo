package com.zjh.javademo.pattern.bridge.message;

/**
 * 消息重要程度
 */
public abstract class MsgUrgency {
   protected SendTyep  sendTyep;

   public  MsgUrgency(){

   }
   public MsgUrgency(SendTyep sendTyep){
       this.sendTyep = sendTyep;
   }

   public String sendType(){
       return  this.sendTyep.sendType();
   }

    public SendTyep getSendTyep() {
        return sendTyep;
    }

    public void setSendTyep(SendTyep sendTyep) {
        this.sendTyep = sendTyep;
    }
}
