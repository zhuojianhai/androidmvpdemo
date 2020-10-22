package com.zjh.javademo.pattern.bridge;

public class Client {
    public static void main(String[] args) {
        Computer computer = new DeskTopComputer(new DellBrand());
        computer.sale();
    }
}
