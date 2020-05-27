package com.zjh.javademo.di.component_dependence;

import dagger.Component;

@Component(dependencies = ActivityComponent.class)
public interface FragmentComponent {
    void inject(TestChild testChild);
}
