package com.zjh.javademo.relation;

public abstract  class Animal {
    private String name;
    private String address;

    public Animal(){
        super();
    }
    public Animal(String name,String address){
        this.name = name;
        this.address = address;
    }

    public abstract String showInfo(Animal animal);
    public String showAnimalInfo(){
       return showInfo(this);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
