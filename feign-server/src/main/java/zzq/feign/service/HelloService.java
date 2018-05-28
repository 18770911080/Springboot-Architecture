package zzq.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="ribbon",fallback = HelloServiceHystrix.class)
public interface HelloService {

    @RequestMapping("hello")
    String hello();

}
