package com.zjh.javademo.pattern.builder;


/**
 * 指挥者，这里去指定流程，返回产品
 */
public class HouseDirector {
    HouseBuilder houseBuilder;
    public HouseDirector(){

    }

    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    public HouseBuilder getHouseBuilder() {
        return houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }
    /**
     * 如何处理建造房子的流程，交给指挥者
     * @return
     */
    public House buildHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return  houseBuilder.buidHouse();
    }
}
