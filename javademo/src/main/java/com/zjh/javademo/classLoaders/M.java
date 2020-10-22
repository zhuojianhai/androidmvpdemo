package com.zjh.javademo.classLoaders;

public class M extends ClassLoader {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "this is initial string value";
            }
        };

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set("thread1");
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set("thread2");
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                tl.set("thread3");
            }
        });
        thread.start();
        thread2.start();
        thread3.start();

    }
}
