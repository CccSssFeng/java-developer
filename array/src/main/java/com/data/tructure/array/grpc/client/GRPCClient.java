package com.data.tructure.array.grpc.client;

import com.data.tructure.array.grpc.RPCDateRequest;
import com.data.tructure.array.grpc.RPCDateResponse;
import com.data.tructure.array.grpc.RPCDateServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author cuishifeng <cuishifeng0207@163.com>
 * Created on 2020-05-24
 */
public class GRPCClient {


    private static final String host = "127.0.0.1";
    private static final int serverPort = 9999;

    public static void main(String[] args) {

        ManagedChannel managedChannel = ManagedChannelBuilder
                .forAddress(host, serverPort)
                .usePlaintext()
                .build();

        RPCDateServiceGrpc.RPCDateServiceBlockingStub rpcDateService
                = RPCDateServiceGrpc.newBlockingStub(managedChannel);
        for (int i = 0; i < 5; i++) {
            RPCDateRequest rpcDateRequest = RPCDateRequest.newBuilder()
                    .setUserName(i + "号队员")
                    .build();

            RPCDateResponse response = rpcDateService.getDate(rpcDateRequest);
            System.out.println(response.getServerDate() + " - " + response.getSort());
        }


    }
}
