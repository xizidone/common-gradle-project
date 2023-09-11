package tech.tongyu.bct.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import tech.tongyu.bct.pojo.HedgeInfoVO;

public class GuavaCacheExample {
    public static void main(String[] args) {
        // 创建一个简单的Guava Cache实例
        Cache<String, HedgeInfoVO> cache = CacheBuilder.newBuilder()
                .maximumSize(100) // 最大缓存项数量
                .build();
    }
}
