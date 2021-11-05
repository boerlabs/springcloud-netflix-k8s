package xyz.boer.consume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author boer
 */
@EnableEurekaClient
@SpringBootApplication
public class ConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }

}

@Configuration
class RestConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ClientHttpRequestFactory httpRequestFactory() {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setReadTimeout(1000 * 6);
        simpleClientHttpRequestFactory.setConnectTimeout(1000 * 10);
        return simpleClientHttpRequestFactory;
    }
}

@RestController
@RibbonClient(name = "springcloud-zuul")
class TheController {
    private static Logger log = LoggerFactory.getLogger(TheController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据应用名获取注册中心实例信息
     *
     * @param applicationName
     * @return
     */
    @RequestMapping("/ins/{applicationName}")
    public List<ServiceInstance> getServiceInstanceByAppName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/hello/{msg}")
    public String helloController(@PathVariable String msg) {
        log.info("Remote process act: " + msg);
        return this.restTemplate.getForObject("http://springcloud-zuul/springboot-produce?msg=" + msg, String.class);
    }

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }
}