package com.data.tructure.array.design.装饰者模式;

import org.junit.Test;

/**
 * @author cuishifeng
 * @date 2019-04-05
 */
public class Client {

    @Test
    public void test() throws Exception {

        Person person = new XiaoHong();
        Clothes clothes = new DiaoPiClothes(person);
        clothes.buyClothes();
    }
}
