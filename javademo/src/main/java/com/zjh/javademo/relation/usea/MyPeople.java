package com.zjh.javademo.relation.usea;

/**
 * MyPeople 和 MyBody 等是组合的关系
 */
public class MyPeople {
    private   MyBody myBody;
    private   MyHeader myHeader;
    private   MyBrain myBrain;

    public MyPeople(){

    }

    public MyPeople(Builder builder){
        myBody = builder.myBody;
        myBrain = builder.myBrain;
        myHeader = builder.myHeader;

    }

    static class Builder{
        MyBody myBody;
        MyHeader myHeader;
        MyBrain myBrain;
        public Builder(){

        }

        public Builder body(MyBody body){
            myBody = body;
            return  this;
        }
        public Builder header(MyHeader header){
            myHeader = header;
            return  this;
        }

        public Builder brain(MyBrain brain ){
            myBrain = brain;
            return  this;
        }

        public MyPeople build(){
            return  new MyPeople(this);
        }

    }
}
