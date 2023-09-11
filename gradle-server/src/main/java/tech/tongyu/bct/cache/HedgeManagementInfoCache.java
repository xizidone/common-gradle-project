package tech.tongyu.bct.cache;

import tech.tongyu.bct.pojo.HedgeInfoVO;
import tech.tongyu.bct.pojo.TradeCategoryHedgeInfoVO;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对冲管理信息缓存
 */
public class HedgeManagementInfoCache {

    private final static ConcurrentHashMap<String, SoftReference<List<HedgeInfoVO>>> CACHE = new ConcurrentHashMap<>();


    public static List<HedgeInfoVO> getCache(String username) {
        SoftReference<List<HedgeInfoVO>> softReference = CACHE.get(username);

        List<HedgeInfoVO> hedgeInfoVOS = Optional.ofNullable(CACHE.get(username))
                .map(SoftReference::get)
                .orElse(null);


        return hedgeInfoVOS;
    }

    public static void setCache(String username, List<HedgeInfoVO> list) {
        CACHE.put(username, new SoftReference<>(list));
    }

}
