package com.salad.lib.demo.dayone;

import com.salad.framework.server.ProviderService;

/**
 * @author cuishifeng
 * @date 2019-05-13
 */
public class BootstrapDemo {

    public static void main(String[] args) throws Throwable {

        UserService userService = new UserServiceImpl();
        ProviderService.provider(userService, 5566);
    }
}
