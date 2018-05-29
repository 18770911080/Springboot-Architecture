package zzq.feign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService{

    @Override
    public String hello() {
        return "hello,error";
    }
}
