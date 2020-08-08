package com.zjh.processor.poet;

import java.lang.Exception;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.System;

public class HelloAddStatement {
  public static int resultValue;

  public static void main(String[] main) {
    long now = System.currentTimeMillis();
    if ( System.currentTimeMillis() < now ) {
      System.out.println("Time travelling, woo hoo!");
    } else if (System.currentTimeMillis() == now) {
      System.out.println("Time stood still!");
    } else {
      System.out.println("Ok, time still moving forward");
    }
    resultValue = 0;
    resultValue = result();
    System.out.println("resultValue");
    System.out.println(resultValue);
    try {
      throw new Exception("fail");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static int result() {
    int result = 0;
    for (int i= 1 ;i<10;i++) {
      result = result + i;
    }
    return result;
  }
}
