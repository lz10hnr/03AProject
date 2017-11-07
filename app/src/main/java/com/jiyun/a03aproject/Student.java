package com.jiyun.a03aproject;

/**
 * Created by xingge on 2017/10/19.
 */

public class Student {

    private int age;

    /**
     * 单例模式
     * 第一步 构造函数私有化
     * 第二步 提供一个公共的、静态的、返回值类型是当前类的的对象的方法
     * 第三步 单例方式的两种实现：懒汉式、饿汉试
      */

    private Student(){}
    //饿汉式
    private static Student student = new Student();
    //懒汉式
    private static Student student2 = null;


    public static Student getInstance(){
        if(student2 == null) {
            synchronized (Student.class) {
                if (student2 == null)
                    student2 = new Student();
            }
        }
        return student2;
    }

    public void setAge(int age){
        this.age = age;
    }
}
