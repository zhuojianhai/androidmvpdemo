package com.zjh.javademo.pattern.chain;

import java.util.ArrayList;
import java.util.List;

public class TestChain {
   static List<AbstractHandler> handlers = new ArrayList<>();
    static{
        handlers.add(new Leader());
        handlers.add(new Manager());
        handlers.add(new Boss());
    }
    public static void main(String[] args) {
        int  applicationMoney = 1000;

        AbstractHandler handler1 = new   Leader();

        AbstractHandler handler2 = new Manager();

        AbstractHandler handler3 = new Boss();

        handler1.setHandler(handler2);

        handler2.setHandler(handler3);

        handler1.proceed(applicationMoney);
    }
}
