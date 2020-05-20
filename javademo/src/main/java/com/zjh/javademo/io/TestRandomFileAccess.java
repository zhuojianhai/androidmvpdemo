package com.zjh.javademo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomFileAccess {
    public static void main(String[] args) {
        File file = new File("log.txt");

        if(file.exists()){
            RandomAccessFile randomAccessFile = null;
            try {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 100; i++) {
                    sb.append("log data is 留个记录时代感 会计师两个" +i);
                    sb.append("\n");
                }
                randomAccessFile = new RandomAccessFile(file,"rw");
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.writeUTF(sb.toString());

                System.out.println(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
