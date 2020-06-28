package com.example.myapplication.dagger2.di;

import com.example.myapplication.dagger2.bean.Menu;
import com.example.myapplication.dagger2.impl.Chef;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CookModules {

    @Provides
    @Singleton
   static  public Map<String,Boolean> provideMap(){
        Map<String,Boolean> menus = new LinkedHashMap<>();
        menus.put("酸菜鱼", true);
        menus.put("土豆丝", true);
        menus.put("铁板牛肉", true);
        return menus;
    }

    @Provides
    @Singleton
  static  public Menu provideMenus(){
        Map<String,Boolean> menus = new LinkedHashMap<>();
        menus.put("酸菜鱼", true);
        menus.put("土豆丝", true);
        menus.put("铁板牛肉", true);
        return new Menu(menus);
    }
    @Provides
    @Singleton
   static  public Chef provideChef(){
       return  new Chef();
    }

}
