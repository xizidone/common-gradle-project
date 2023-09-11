package tech.tongyu.bct.controller;

import cn.hutool.core.util.ObjectUtil;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.tongyu.bct.auth.feign.AuthExternalClient;
import tech.tongyu.bct.sdk.UserTest;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/redission")
public class RedissonController {

    @Resource
    private UserTest userTest;

    @Value("${tongyu.sn.ci:8}")
    private Integer confirmIncomeRate;

    @Resource
    private AuthExternalClient authExternalClient;

    @Resource
    private RedissonClient redissonClient;



    @GetMapping("/get")
    public Object user01() {

        System.out.println(confirmIncomeRate);
        return confirmIncomeRate;
    }


}
