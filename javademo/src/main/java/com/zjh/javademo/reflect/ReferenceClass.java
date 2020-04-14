package com.zjh.javademo.reflect;

import java.util.Map;

public class ReferenceClass {
    private String name;
    private String address;
    private Map<String,String> hashMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public String toString() {
        return "ReferenceClass{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", hashMap=" + hashMap +
                '}';
    }
}
