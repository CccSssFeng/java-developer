package com.data.tructure.array.design.装饰者模式;

/**
 * @author cuishifeng
 * @date 2019-04-05
 */
public class DiaoPiClothes extends Clothes {

    public DiaoPiClothes(Person person) {
        super(person);
    }

    @Override
    public void buyClothes() {
        super.buyClothes();
        System.out.println("买了件貂皮大衣");
    }
}
