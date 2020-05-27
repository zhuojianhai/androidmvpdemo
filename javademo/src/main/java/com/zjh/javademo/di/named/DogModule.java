package com.zjh.javademo.di.named;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/***
 * 接下来是Module，意思用@Named标识2种不同的初始化路径。
 * 假如这个时候不使用@Named的话，你运行的会报错，报错。
 * Dagger2不知道，到底使用哪个
 */
@Module
public class DogModule {
    @Named("tag_1")
    @Provides
    Dog provoidJinmao(){
        return  new Dog("金毛");
    }

    @Named("tag_2")
    @Provides
    Dog provoidEhoDog  (){
        return  new Dog("二哈");
    }
}
