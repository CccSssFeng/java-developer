package com.data.tructure.array.design.装饰者模式;

/**
 * @author cuishifeng
 * @date 2019-04-05
 */
public abstract class Clothes {

    private Person person;

    public Clothes(Person person) {
        this.person = person;
    }

    public void buyClothes() {
        person.clothes();
    }
}
