package com.x.programming.grpc.service;

import com.x.programming.grpc.YoloGreeterGrpc;
import com.x.programming.grpc.YoloReply;
import com.x.programming.grpc.YoloRequest;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class YoloServiceImpl extends YoloGreeterGrpc.YoloGreeterImplBase {

    @Override
    public void sayYolo(YoloRequest request, StreamObserver<YoloReply> responseObserver) {
        String msg = "Yolo, " + request.getName();
        YoloReply reply = YoloReply.newBuilder().setMessage(msg).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
