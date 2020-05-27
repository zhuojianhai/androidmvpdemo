package com.zjh.javademo.di.provides;

import dagger.Component;

/**
 * 自己定义个接口类Builder,并用@Component.Builder标注里面有2个方法：
 *
 * 方法一：是返回值Builder的方法，这里如果传module就会以我们传的为主，否则他会帮我们生成一个money为0的module。当然你也随意传数据类型，只不过无效。可以试试，
 * 方法二：是返回值为当前Component的方法，方法名其实都可以自定义，当最好以规范为主，用习惯了就明白了
 *
 * 作者：岩浆李的游鱼leo2
 * 链接：https://juejin.im/post/5d6f3e47f265da03aa258c72
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 */
@Component(modules = CstudyModule.class)
public interface CstudyComponentA {
    void inject(Test test);

    @Component.Builder
    interface Builder{
        Builder cstudyModule(CstudyModule cstudyModule);
        CstudyComponentA build();
    }
}
