package com.zjh.javademo.thread.wn;

public class FruitJuice {
    private String fruitName;
    private int fruitWeight;

    public FruitJuice(){

    }

    public FruitJuice(String fruitName,int fruitWeight){
        this.fruitName = fruitName;
        this.fruitWeight = fruitWeight;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getFruitWeight() {
        return fruitWeight;
    }

    public void setFruitWeight(int fruitWeight) {
        this.fruitWeight = fruitWeight;
    }

    @Override
    public String toString() {
        return "FruitJuice{" +
                "fruitName='" + fruitName + '\'' +
                ", fruitWeight=" + fruitWeight +
                '}';
    }
}
