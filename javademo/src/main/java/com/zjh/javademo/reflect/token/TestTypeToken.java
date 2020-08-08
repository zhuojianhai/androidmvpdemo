package com.zjh.javademo.reflect.token;

import java.lang.reflect.Type;
import java.util.List;

public class TestTypeToken {
    public static void main(String[] args) {
        MyTypeToken<List<String>> myTypeToken = new MyTypeToken<List<String>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };

        System.out.println(myTypeToken.getType());
    }
}
