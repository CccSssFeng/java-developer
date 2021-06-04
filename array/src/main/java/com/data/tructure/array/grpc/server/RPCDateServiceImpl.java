package com.data.tructure.array.grpc.server;

import com.data.tructure.array.grpc.RPCDateRequest;
import com.data.tructure.array.grpc.RPCDateResponse;
import com.data.tructure.array.grpc.RPCDateServiceGrpc;

import io.grpc.stub.StreamObserver;

/**
 * @author cuishifeng <cuishifeng0207@163.com>
 * Created on 2020-05-24
 */
public class RPCDateServiceImpl extends RPCDateServiceGrpc.RPCDateServiceImplBase {


    @Override
    public void getDate(RPCDateRequest request, StreamObserver<RPCDateResponse> responseObserver) {

        RPCDateResponse rpcDateResponse = RPCDateResponse.newBuilder()
                //  " 今天是 " + DateFormatUtils.format(new Date(), "yyyy-MM-dd")
                .setServerDate("欢迎 " + request.getUserName())
                //                .setSort(RandomUtils.nextInt(0, 10))
                .build();
        System.out.println(rpcDateResponse.getServerDate());
        responseObserver.onNext(rpcDateResponse);
        responseObserver.onCompleted();
    }
}
