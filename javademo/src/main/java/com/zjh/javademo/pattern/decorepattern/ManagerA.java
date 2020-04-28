package com.zjh.javademo.pattern.decorepattern;

public class ManagerA extends Manager {
    public ManagerA(){

    }
    public ManagerA(Person person){
       this.person = person;
    }

    @Override
    public void doSomething() {
        doSomethingBefore();
        super.doSomething();
    }

    private void doSomethingBefore() {
        System.out.println("do something before ");
    }
}
