package com.zjh.javademo.rxjava.rxsubscribeon;

public class Printers {
    Printers sources;
    String name;

    public Printers(){
        super();
    }

    public Printers(Printers printers,String name){
        this.sources = printers;
        this.name = name;
    }
    public void print(){
        if(sources == null){
            System.out.println(name+"--"+Thread.currentThread().getName()+" empty");
            return;
        }


        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println(name+"--"+Thread.currentThread().getName());
                if(sources!=null){
                    sources.print();
                }
            }
        }).start();

    }


    public static void main(String[] args) {
        Printers printers1 = new Printers(null,"printer1");
        Printers printers2 = new Printers(printers1,"printer2");
        Printers printers3 = new Printers(printers2,"printer3");
        Printers printers4 = new Printers(printers3,"printer4");
        printers4.print();


        String s = "Sbc123dd4567dd89wwee0";
      String rs =   s.replace("1","").replace("3","").replace("5","")
                .replace("7","")
                .replace("9","").toUpperCase();
        System.out.println(rs);
    }
}
