package com.zjh.javademo.pattern.strategy;

import java.math.BigDecimal;

public class CalculateImp3 implements Calculate<BussinessBean> {
    @Override
    public void calculateValue(BussinessBean bussinessBean) {
        System.out.println(bussinessBean.getName()+"----"+bussinessBean.getPrice().multiply(new BigDecimal("3")).toString());
    }
}
