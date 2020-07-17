package com.zjh.javademo.relation;

public class Persons {
    private Dog dog;

    private String pName;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String  showDogInf(){

        return this.dog.name +" "+this.dog.address +" "+this.dog.owner.getpName();
    }

    public static void main(String[] args) {
        Persons p = new Persons();
        p.setpName("jack");

        Dog dog = new Dog();
        dog.address = "overseas";
        dog.name ="wangcai";
        dog.owner = p;

        p.setDog(dog);

        System.out.println(dog.showOwnerInfo());

        System.out.println(p.showDogInf());
    }
}
