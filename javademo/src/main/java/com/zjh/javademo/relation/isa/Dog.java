package com.zjh.javademo.relation.isa;

public class Dog extends Animal {
    private String name;
    public Dog(){
        super();
    }

    public Dog(String name){
        this.name = name;
    }

    @Override
    protected void eat() {
        super.eat();
        System.out.println(name+" is eat food");
    }
}
