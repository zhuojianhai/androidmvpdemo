package com.zjh.plugin;

import com.android.build.gradle.AppExtension;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class JiaguPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        //创建一个patch{}配置
        //就和引入了 apply plugin: 'com.android.application' 一样，可以配置android{}
        project.getExtensions().create("patch",PatchExtention.class);


        //gradle执行会解析build.gradle文件，afterEvaluate表示在解析完成之后再执行我们的代码

        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                //获得用户配置的参数
                PatchExtention patchExtention =
                        project.getExtensions().findByType(PatchExtention.class);
                System.out.println("自定义插件>>>>>>"+patchExtention.toString());

                //得到android的配置
                AppExtension appExtension = project.getExtensions().findByType(AppExtension.class);




            }
        });


    }
}
