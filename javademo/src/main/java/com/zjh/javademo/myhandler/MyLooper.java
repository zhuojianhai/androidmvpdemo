package com.zjh.javademo.myhandler;

public class MyLooper {
    static final ThreadLocal<MyLooper> sThreadLocal = new ThreadLocal<MyLooper>();
    final MyMessageQueue mQueue;
    final Thread mThread;
    private MyLooper(boolean quitAllowed) {
        mQueue = new MyMessageQueue(quitAllowed);
        mThread = Thread.currentThread();
    }
    public static void prepare() {
        prepare(true);
    }

    private static void prepare(boolean quitAllowed) {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new MyLooper(quitAllowed));
    }
}
