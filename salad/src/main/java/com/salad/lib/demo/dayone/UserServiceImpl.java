package com.salad.lib.demo.dayone;

/**
 * @author cuishifeng
 * @date 2019-05-13
 */
public class UserServiceImpl implements UserService {



    @Override
    public String getName(String name) {
        return "hello: " + name;
    }



}
