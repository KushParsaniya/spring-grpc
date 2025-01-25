package dev.kush.grpcclient.controller;

import dev.kush.grpcclient.hello.HelloRequest;
import dev.kush.grpcclient.hello.HelloServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public HelloController(HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub) {
        this.helloServiceBlockingStub = helloServiceBlockingStub;
    }

    @GetMapping("/hello")
    public String hello(@RequestBody String name) {
        try {
            return helloServiceBlockingStub.greeting(HelloRequest.newBuilder()
                    .setName(name)
                    .build()).getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry, something went wrong!";
        }
    }
}
