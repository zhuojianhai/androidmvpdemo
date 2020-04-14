package com.zjh.javademo.reflect;

import java.util.HashMap;
import java.util.Map;

public class ReflectClassDemo {

    public ReflectClassDemo(){
        super();
    }
    private String name;

    private byte bvalee;
    private short value;
    private int age;
    private long lValue;

    private float aFloat;
    private double dValue;

    private char aChar;

    private boolean flag;

    private Map<String,String> map = new HashMap<String,String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getBvalee() {
        return bvalee;
    }

    public void setBvalee(byte bvalee) {
        this.bvalee = bvalee;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getlValue() {
        return lValue;
    }

    public void setlValue(long lValue) {
        this.lValue = lValue;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }

    public double getdValue() {
        return dValue;
    }

    public void setdValue(double dValue) {
        this.dValue = dValue;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
