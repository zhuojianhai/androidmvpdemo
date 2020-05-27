package com.zjh.javademo.di.dependency;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Dagger 2 的@Component注解可以设置dependencies属性，
 * 来依赖其它的 Component，这样我们可以定义一套公共的 Component + Module，
 * 让需要的 Component 来依赖公共的 Component，这样问题就解决了。
 *
 */
@Singleton
@Component(modules = CommonModule.class)
public interface CommonComponent {

    Book provideBook();
}
