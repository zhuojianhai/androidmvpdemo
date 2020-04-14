package com.zjh.javademo.proxys;

import java.math.BigDecimal;

public class MoneyServiceImpA implements MoneyService {
    @Override
    public BigDecimal makeMoney() {
        return new BigDecimal("888.88");
    }

    @Override
    public void offerMoney() {
        System.out.println("上交你的money to  your wife");
    }
}
