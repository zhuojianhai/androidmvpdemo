package com.zjh.javademo.di.provides;

import dagger.Component;

@Component(modules = CstudyModule.class)
public interface CstudyComponent {
    void inject(Test test);
}
