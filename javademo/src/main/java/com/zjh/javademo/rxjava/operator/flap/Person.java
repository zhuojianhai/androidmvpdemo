package com.zjh.javademo.rxjava.operator.flap;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Plan> planList = new ArrayList<>();

    public Person(){

    }

    public Person(String name, List<Plan> planList) {
        this.name = name;
        this.planList = planList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

//    作者：玉刚说
//    链接：https://juejin.im/post/5b17560e6fb9a01e2862246f
//    来源：掘金
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
