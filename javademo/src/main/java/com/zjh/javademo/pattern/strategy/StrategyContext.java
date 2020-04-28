package com.zjh.javademo.pattern.strategy;

public class StrategyContext<T> {
    private Calculate<T> calculate;
    public StrategyContext(){
        super();
    }

    public StrategyContext(Calculate<T> calculate){
        this.calculate = calculate;
    }

    public void calculateMethod(T t){
        calculate.calculateValue(t);

    }

    public Calculate<T> getCalculate() {
        return calculate;
    }

    public void setCalculate(Calculate<T> calculate) {
        this.calculate = calculate;
    }
}
