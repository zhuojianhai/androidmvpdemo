package com.zjh.javademo.pattern.strategy;

import java.math.BigDecimal;

public class TestCalculator {
    public static void main(String[] args) {

        StrategyContext<BussinessBean> context = new StrategyContext<>();

        Calculate<BussinessBean> calculate = null;

        BussinessBean bussinessBean = new BussinessBean();
        bussinessBean.setName("狗蛋");
        bussinessBean.setPrice(new BigDecimal("150.88"));


        if(bussinessBean.getPrice().intValue()>100){
            calculate = new CalculateImpl1();
            context.setCalculate(calculate);
            context.calculateMethod(bussinessBean);



            bussinessBean.setName("毛蛋");
            bussinessBean.setPrice(new BigDecimal("250"));

        }



        if(bussinessBean.getPrice().intValue()>200){
            calculate = new CalculateImp2();
            context.setCalculate(calculate);
//             bussinessBean.setName("毛蛋");
//            bussinessBean.setPrice(new BigDecimal("777"));
            context.calculateMethod(bussinessBean);

            bussinessBean.setName("单蛋");
            bussinessBean.setPrice(new BigDecimal("350"));


        }


        if(bussinessBean.getPrice().intValue()>300){
            calculate = new CalculateImp3();
//            bussinessBean.setName("单蛋");
//            bussinessBean.setPrice(new BigDecimal("666"));
            context.setCalculate(calculate);
            context.calculateMethod(bussinessBean);
        }




    }
}
