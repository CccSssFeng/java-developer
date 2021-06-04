package com.data.tructure.array.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * @author cuishifeng <cuishifeng0207@163.com>
 * Created on 2020-05-24
 */
public class GRPCServer {

    private static final int port = 9999;

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.
                forPort(port)
                .addService(new RPCDateServiceImpl())
                .build().start();
        System.out.println("grpc服务端启动成功, 端口=" + port);
        server.awaitTermination();
    }

}
