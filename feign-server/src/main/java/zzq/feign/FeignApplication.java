package zzq.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zzq.feign.service.HelloService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class FeignApplication {

	@Autowired
	private HelloService hs;

	@Value("${server.port}")
	private int port;

	@RequestMapping("hello")
	public String hello(){
		return hs.hello()+"/nWeb:"+port;
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
}
