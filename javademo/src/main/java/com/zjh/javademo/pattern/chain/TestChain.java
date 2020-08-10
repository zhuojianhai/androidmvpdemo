package com.zjh.javademo.pattern.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式，和递归类似
 */
public class TestChain {
   static List<AbstractHandler> handlers = new ArrayList<>();
    static{
        handlers.add(new Leader());
        handlers.add(new Manager());
        handlers.add(new Boss());
    }
    public static void main(String[] args) {
        int  applicationMoney = 15000;

        AbstractHandler handler1 = new   Leader();

        AbstractHandler handler2 = new Manager();

        AbstractHandler handler3 = new Boss();

        AbstractHandler handler4 = new BossWife();

        handler1.setHandler(handler2);

        handler2.setHandler(handler3);

        handler3.setHandler(handler4);

        handler1.proceed(applicationMoney);
    }
}
