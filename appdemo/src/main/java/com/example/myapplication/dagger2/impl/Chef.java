package com.example.myapplication.dagger2.impl;

import com.example.myapplication.dagger2.bean.Menu;
import com.example.myapplication.dagger2.interfaces.Cooking;

import java.util.Map;

import javax.inject.Inject;

public class Chef implements Cooking {


    Menu menu;
    public Chef(){

    }
    @Inject
    public Chef(Menu menu){
        this.menu = menu;
    }
    @Override
    public String cook() {
        //key菜名， value是否烹饪
        Map<String,Boolean> menuList = menu.getMenus();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Boolean> entry : menuList.entrySet()){
            if (entry.getValue()){
                sb.append(entry.getKey()).append(",");
            }
        }

        return sb.toString();
    }
}
