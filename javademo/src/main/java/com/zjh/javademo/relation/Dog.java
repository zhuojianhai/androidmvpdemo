package com.zjh.javademo.relation;

public class Dog {
    public String name;
    public String address;

    public Persons owner;


    public String showOwnerInfo(){
        System.out.println("my owner is "+owner.getpName());
        return owner.getpName();
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", owner=" + owner +
                '}';
    }
}
