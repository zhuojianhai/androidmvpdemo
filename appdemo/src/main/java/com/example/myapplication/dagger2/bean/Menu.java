package com.example.myapplication.dagger2.bean;

import java.util.Map;

import javax.inject.Inject;

public class Menu {

    Map<String,Boolean> menus;

    public Menu(){

    }

    @Inject
    public Menu(Map<String,Boolean> menus){
        this.menus = menus;
    }

    public Map<String,Boolean> getMenus(){
        return  menus;
    }

    
}
