package com.salad.lib.socket;


import lombok.Getter;
import lombok.Setter;

import java.net.Socket;

/**
 * @author cuishifeng
 * @date 2019-05-18
 */
@Setter
@Getter
public class AbstractSocketHelper {

    private String ip;
    private int port;


    public AbstractSocketHelper(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Socket send(Object object, String methodName, Socket socket) throws Exception {
        throw new RuntimeException("send message please find it implements");
    }

    public Object receive(Socket socket) throws Exception {
        throw new RuntimeException("receive message please find it implements");
    }

    public void accept(Object service) throws Exception, Throwable {
        throw new RuntimeException("accept message please find it implements");
    }

}
