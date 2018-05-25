package zzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("eureka-server")
public interface HelloService {

    @RequestMapping("hello")
    String hello();

}
