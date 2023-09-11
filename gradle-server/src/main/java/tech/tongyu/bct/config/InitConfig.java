package tech.tongyu.bct.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.tongyu.bct.auth.feign.AuthExternalClient;

import javax.annotation.Resource;

import static org.redisson.api.LocalCachedMapOptions.EvictionPolicy.LFU;

@Slf4j
@Component
public class InitConfig implements CommandLineRunner {

    @Autowired(required = false)
    private AuthExternalClient authExternalClient;


    @Resource
    private RedissonClient redissonClient;

    @Override
    public void run(String... args) throws Exception {

        log.info("--执行一些启动的配置项--");
        RLocalCachedMap<Object, Object> test = redissonClient.getLocalCachedMap("test", LocalCachedMapOptions.defaults());

        Object o = test.get("01");
        System.out.println(o);

        test.put("01","001");


        System.out.println(test.get("01"));
    }
}
