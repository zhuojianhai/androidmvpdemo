package com.zjh.javademo.pattern.bridge.message;

/**
 * 消息发送方式
 * 邮件、手机 。。。
 */
public interface SendTyep {
    String sendType();
}
