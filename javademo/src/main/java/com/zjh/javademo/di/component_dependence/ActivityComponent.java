package com.zjh.javademo.di.component_dependence;

import dagger.Component;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(TestParent tp);
//    我们要把依赖注入的类返回出去,定义方法provideHuman，因为是Component依赖Component。
        Human provideHuman();
}
