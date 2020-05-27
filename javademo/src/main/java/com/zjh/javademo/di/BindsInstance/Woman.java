package com.zjh.javademo.di.BindsInstance;

public class Woman {
    private Soul soul;

    public Woman(){

    }
    public Woman(Soul soul){
        this.soul = soul;
    }
    public Soul getSoul() {
        return soul;
    }

    public void setSoul(Soul soul) {
        this.soul = soul;
    }

    public void show(){
        System.out.println("soul money "+soul.getMomey());
    }
}
