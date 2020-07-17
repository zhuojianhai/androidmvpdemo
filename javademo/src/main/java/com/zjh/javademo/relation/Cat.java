package com.zjh.javademo.relation;


import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal {
    private Cat cat;

    private List<WeakReference<Cat>> list = new ArrayList<>();


    public void aqurie(Cat cat){
        this.cat = cat;
        list.add(new WeakReference<>(cat));
        System.out.println(this.cat.toString());
    }

    public void release(){
        for (int i=0;i<list.size();i++){
            Reference<Cat> reference = list.get(i);
            if(reference.get() == this){
                System.out.println(reference.get().toString());
                list.remove(i);
                return;
            }
        }

    }

    public Cat(){

    }



    public Cat(String name, String address){
        super(name,address);
    }
    @Override
    public String showInfo(Animal animal) {
        return animal.toString();
    }

    @Override
    public String showAnimalInfo() {
        String rs = super.showAnimalInfo();
        System.out.println(rs);
        return rs;
    }


    public static void main(String[] args) {
        Cat cat = new Cat("cat","addrss");
        cat.showAnimalInfo();

//        List<WeakReference<String>> arrays = new ArrayList<>();
//        for (int i=0;i<10;i++){
//            arrays.add(new WeakReference<>("ssss"+i));
//        }
//
//        WeakReference<String> data = arrays.get(0);
//        System.out.println("data.get "+data.get());


        cat.aqurie(new Cat("cat1","address2"));
        cat.aqurie(cat);
        cat.release();




    }
}
