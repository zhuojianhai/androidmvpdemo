package com.zjh.javademo.di.BindsInstance;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = CstudyModule.class)
public interface CstudyComponent {
    void inject(Test test);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder initMoney(int momey);
        CstudyComponent build();
    }
}
