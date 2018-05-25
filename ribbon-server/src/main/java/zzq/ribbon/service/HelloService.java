package zzq.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello() {
        return restTemplate.getForObject("http://eureka-server/hello", String.class);
    }

    public String helloError(){
        return "hello,error!";
    }
}
