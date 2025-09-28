package com.x.programming.grpc.service;


import com.x.programming.grpc.YoloReply;
import com.x.programming.grpc.YoloRequest;

public interface YoloService {

    YoloReply sayYolo(YoloRequest request);
}
