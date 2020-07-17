package com.zjh.javademo.io;

public interface IOInterface {

    void getName();
    String showInfo();

    IOInterface NONE = new IOInterface() {
        @Override
        public void getName() {

            System.out.println("this is getName");
        }

        @Override
        public String showInfo() {
            System.out.println("this is inner implements");
            return "this is inner implements ";
        }
    };

}
