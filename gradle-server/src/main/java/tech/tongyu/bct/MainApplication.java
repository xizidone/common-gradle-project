package tech.tongyu.bct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import tech.tongyu.bct.config.TestApplicationContextInitializer;
import tech.tongyu.bct.sdk.UserTest;

import javax.annotation.Resource;

@SpringBootApplication
@EnableFeignClients({"tech.tongyu.bct"})
public class MainApplication {

    @Resource
    private UserTest userTest;

    public static void main(String[] args) {


        SpringApplication springApplication = new SpringApplication(MainApplication.class);
        springApplication.run(args);

    }
}
