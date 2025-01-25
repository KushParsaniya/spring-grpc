package dev.kush.grpcclient.config;

import dev.kush.grpcclient.hello.HelloServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class StubConfig {

    @Bean
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub(GrpcChannelFactory channelFactory) {
        // for this add this properties
        // properties: spring.grpc.client.channels.service1.address=localhost:9090
        return HelloServiceGrpc.newBlockingStub(channelFactory.createChannel("service1"));
    }

    // or without properties
//    @Bean
//    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub(GrpcChannelFactory channelFactory) {
//        return HelloServiceGrpc.newBlockingStub(channelFactory.createChannel("localhost:9090"));
//    }

}
