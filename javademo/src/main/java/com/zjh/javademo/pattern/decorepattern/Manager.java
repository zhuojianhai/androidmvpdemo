package com.zjh.javademo.pattern.decorepattern;

public abstract  class Manager implements Person {
    protected Person person;

    @Override
    public void doSomething() {
        person.doSomething();
    }
}
