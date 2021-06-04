package com.data.tructure.array.并发.类加载机制;

/**
 * @author cuishifeng
 * @date 2019-05-29
 */
public class Sinlgleton {

    private static int x = 0;
    private static int y;

    private static Sinlgleton sinlgleton = new Sinlgleton();

    private Sinlgleton() {
        x++;
        y++;
    }

    static {
        System.out.println("初始化");
    }

    public static Sinlgleton getSinlgleton() {
        return sinlgleton;
    }

    public static void main(String[] args) {
        System.out.println(Sinlgleton.x);
        Sinlgleton sinlgleton = getSinlgleton();
        System.out.println(sinlgleton.x);
        System.out.println(sinlgleton.y);
    }
}
