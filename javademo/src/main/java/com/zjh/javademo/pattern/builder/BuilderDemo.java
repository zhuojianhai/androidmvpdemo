package com.zjh.javademo.pattern.builder;

public class BuilderDemo {
    private String name;
    private int age;
    private String  address;

    @Override
    public String toString() {
        return "BuilderDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public BuilderDemo(Builder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.age = builder.age;
    }


    static class Builder{
        private String name;
        private int age;
        private String  address;

        public Builder(){
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age =age;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }

        public BuilderDemo build(){
            return  new BuilderDemo(this);
        }
    }


    public int age(){
        return  age;
    }
    public String getAddress(){
        return this.address;
    }
    public String getName(){
        return  this.name;
    }


    public static void main(String[] args) {
        BuilderDemo builderDemo = new BuilderDemo.Builder().name("zhuojianhai")
                .address("jiangsu-huji")
                .age(30)
                .build();

        System.out.println(builderDemo.toString());

    }
}
