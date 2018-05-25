package zzq.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zzq.ribbon.service.HelloService;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonApplication {

	@Autowired
	private HelloService hs;

	@Value("${server.port}")
	private int port;

	@RequestMapping("hello")
	public String hello(){
		return hs.hello()+"/nWeb:"+port;
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

}
