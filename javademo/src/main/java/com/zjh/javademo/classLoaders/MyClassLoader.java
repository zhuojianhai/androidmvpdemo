package com.zjh.javademo.classLoaders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR = Paths.get("D:",  "classloader1");

    private final Path classDir;

    public MyClassLoader()
    {
        super();
        this.classDir = DEFAULT_CLASS_DIR;

    }
    public MyClassLoader(String classDir)
    {
        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassLoader(String classDir,ClassLoader parent)
    {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    private byte[] readClassBytes(String name)
            throws ClassNotFoundException
    {
        String classPath = name.replace(".", "/");
        Path classFullPath =  classDir.resolve(Paths.get(classPath+".class"));
        if(!classFullPath.toFile().exists())
        {
            throw new ClassNotFoundException("The Class "+name+" not  found");
        }
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        }
        catch(IOException e)
        {
            throw new ClassNotFoundException("Load the class "+  name +"  occur error.",e);
        }
    }

    @Override
    /*
     * (non-Javadoc)
     * @see java.lang.ClassLoader#findClass(java.lang.String)
     * 必须要重写这个类
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        byte[] classBytes = this.readClassBytes(name);
        if(null == classBytes || classBytes.length == 0)
        {
            throw new ClassNotFoundException("can not load the class ");
        }
        return this.defineClass(name, classBytes, 0,classBytes.length);
    }

    @Override
    public String toString()
    {
        return "My ClassLoader";
    }
    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass  =null;
        try {
            aClass =  classLoader.loadClass("com.zjh.javademo.classLoaders.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(aClass.getClassLoader());
        try {
            Object student = aClass.newInstance();

            //定义的属性
            Field[] fields = aClass.getDeclaredFields();
            for (Field f:fields){
                f.setAccessible(true);
                if("name".equals(f.getName())){
                    f.set(student,"zhuojianhai");
                }
                if("age".equals(f.getName())){
                    f.set(student,20);
                }
                if("address".equals(f.getName())){
                    f.set(student,f.getType().newInstance());
                }
                f.setAccessible(false);
            }

            System.out.println(student);
            Method showInfo = aClass.getMethod("showInfo");
            showInfo.invoke(student);

        } catch (InstantiationException e) {

            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

