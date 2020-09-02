package com.example.myapplication.hotfix;

import android.content.Context;

import java.io.File;
import java.lang.reflect.Array;

import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;

public class HotfixHelper {

    /**
     *
     * @param hostElements    宿主中的dexElements
     * @param patchElements   补丁包中的dexElements
     * @return Object         合并成的dexElements
     */
    private static Object combineArray(Object hostElements, Object patchElements) {
        Class<?> componentType = hostElements.getClass().getComponentType();
        int i = Array.getLength(hostElements);
        int j = Array.getLength(patchElements);
        int k = i + j;
        Object result = Array.newInstance(componentType, k);
        // 将补丁包的dexElements合并到头部
        System.arraycopy(patchElements, 0, result, 0, j);
        System.arraycopy(hostElements, 0, result, j, i);
        return result;
    }

    public static void  applyPatch(Context context) {


            try {
                // 获取宿主的ClassLoader
                ClassLoader classLoader = context.getClassLoader();
                Class loaderClass = BaseDexClassLoader.class;
                // 获取宿主ClassLoader的pathList对象
                Object hostPathList = ReflectUtils.getField(loaderClass, classLoader, "pathList");
                // 获取宿主pathList对象中的dexElements数组对象
                Object hostDexElement = ReflectUtils.getField(hostPathList.getClass(), hostPathList, "dexElements");

                File optimizeDir = new File(context.getCacheDir() + "/optimize");
                if (!optimizeDir.exists()) {
                    optimizeDir.mkdir();
                }
                // 创建补丁包的类加载器
                DexClassLoader patchClassLoader = new DexClassLoader(context.getCacheDir() + "/patch.dex", optimizeDir.getPath(), null, classLoader);
                // 获取补丁ClassLoader中的pathList对象
                Object patchPathList = ReflectUtils.getField(loaderClass, patchClassLoader, "pathList");
                // 获取补丁pathList对象中的dexElements数组对象
                Object patchDexElement = ReflectUtils.getField(patchPathList.getClass(), patchPathList, "dexElements");

                // 合并宿主中的dexElements和补丁中的dexElements，并把补丁的dexElements放在数组的头部
                Object newDexElements = combineArray(hostDexElement, patchDexElement);
                // 将合并完成的dexElements设置到宿主ClassLoader中去
                ReflectUtils.setField(hostPathList.getClass(), hostPathList, "dexElements", newDexElements);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }

    }

}
