package com.zjh.javademo.okio;



import org.omg.CORBA.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public class TestOKIo {
    public static void main(String[] args) {
        wirteFiles("okio.txt");
        readFiles("okio.txt");
    }

    private static void wirteFiles(String fileName){
        boolean isCreate = false;


        Sink sink = null;
        BufferedSink bufferedSink = null;
        String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        File file = new File(filePath,fileName);

        try {

            if (!file.exists()) {
                isCreate = file.createNewFile();
            } else {
                isCreate = true;
            }

            if(isCreate){
                sink = Okio.sink(file);
                bufferedSink = Okio.buffer(sink);

                String str = "this is write content ";
                for(int i=0;i<10;i++){
                    bufferedSink.writeString(str+i+"\n",Charset.forName("UTF-8"));
                }

                bufferedSink.writeInt(97);

                bufferedSink.flush();
            }



        }catch (Exception e){
            e.printStackTrace();

        }finally {

            if (bufferedSink!=null){
                try {
                    bufferedSink.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    private static void readFiles(String fileName){
        Source  source = null;
        BufferedSource bufferedSource = null;

        String filePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        File file = new File(filePath,fileName);

        try {
            source = Okio.source(file);
            bufferedSource = Okio.buffer(source);

            String readStr = bufferedSource.readString(Charset.forName("UTF-8"));

            System.out.println(readStr);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufferedSource!=null){
                try {
                    bufferedSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
