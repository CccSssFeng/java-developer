package com.salad.lib.socket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author cuishifeng
 * @date 2019-05-20
 */
@Getter
@Setter
@AllArgsConstructor
public class SocketAcceptResult {

    private Object result;
    private String methodName;

}
