package com.example.jokerkafka.controller;

import sun.misc.Launcher;

import java.net.URL;

/**
 * JVM demo
 */
public class JVMController {

    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoaderLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoaderLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
        
        //通过系统类加载器获取上层 ：扩展类加载器
        ClassLoader extensionClassLoader = systemClassLoaderLoader.getParent();
        System.out.println(extensionClassLoader); //sun.misc.Launcher$ExtClassLoader@816f27d

        //通过引导类加载器获取上层 : 引导类加载器
        ClassLoader bootstarapClassLoader = extensionClassLoader.getParent();
        System.out.println(bootstarapClassLoader);//null

        //对于用户自定义的类
        ClassLoader classLoader = JVMController.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2 与系统类加载器一样


        //String类使用引导类加载器加载 --》 java 的核心类库都是使用引导类加载器加载的
        ClassLoader loader = String.class.getClassLoader();
        System.out.println(loader);//null

        //获取BootstrapClassLoader能够加载api的路径
        System.out.println("==================引导类加载器========================");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL u:urLs) {
            System.out.println(u.toExternalForm());
        }

        //获取Extension ClassLoader扩展类加载器加载的路径
        System.out.println("==================扩展类加载器========================");
        String property = System.getProperty("java.ext.dirs");
        for (String path: property.split(";")) {
            System.out.println(path);
        }


        try {
            //1.引导类加载器
            ClassLoader classLoding = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoding);//null
            //2.系统类加载器
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

            //3.系统类加载器
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
            //4.扩展类加载器
            ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(parent);//sun.misc.Launcher$ExtClassLoader@816f27d
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
