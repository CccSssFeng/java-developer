package com.data.tructure.array.快捷键;


import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IDEA快捷键 {


    public static void main(String[] args) {


        // control + o 重写方法
        // control + I 实现方法

        // 新建文件 Command + N

        // Command + Space 智能补全代码
        // option + Command + v 补全返回值
        // Command + Shift + Enter 自动结束代码
        // fn + F7 + option 查看类被引用的地方

        // Command + option + L 格式化代码
        // control + option + o 优化import

    }

    @Test
    public void test() throws Exception {

        A a = new A();
        List list = new ArrayList();

        LinkedList<Object> objects = new LinkedList<>();


    }


    class A implements Car {

        @Override
        public void buyCar() {

        }
    }

    interface Car {

        void buyCar();
    }
}
