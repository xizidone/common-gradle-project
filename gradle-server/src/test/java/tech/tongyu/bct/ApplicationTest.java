package tech.tongyu.bct;

import cn.hutool.core.codec.Base64;
import com.xizi.common.utils.LambdaUtils;
import org.junit.jupiter.api.Test;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import tech.tongyu.bct.config.DsBaseInfoProperties;

import tech.tongyu.bct.dto.TradeTemplateContentDTO;
import tech.tongyu.bct.pojo.Sender;

import javax.annotation.Resource;

import static org.redisson.api.LocalCachedMapOptions.EvictionPolicy.LFU;


@SpringBootTest(properties = "spring.flyway.enabled=false")
public class ApplicationTest {

    @Resource
    private DsBaseInfoProperties dsBaseInfoProperties;

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void test01() {
        System.out.println(Base64.decodeStr("9JQOuz5fKDc1maiFBKlh1A=="));
        System.out.println(Base64.decodeStr("9JQOuz5fKDdOkErgrxNVGg=="));

    }

    @Test
    public void test02() {

        RLocalCachedMap<String, Object> map = redissonClient.getLocalCachedMap("admin_127.0.0.1", LocalCachedMapOptions.<String, Object>defaults().cacheSize(1000).evictionPolicy(LFU));
        System.out.println(map);

    }

    @Test
    public void test03(){
        TradeTemplateContentDTO tradeTemplateContentDTO = new TradeTemplateContentDTO();


    }


}
