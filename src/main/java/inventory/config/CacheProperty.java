package inventory.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.config.CacheManagementConfigUtils;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "cache")
public class CacheProperty {

    private final static String cacheName= "testCache";
    private int ttlSecond;
    private int maxCache;
    private String cachePolicy;

    public int getTtlSecond() {
        return ttlSecond;
    }

    public void setTtlSecond(int ttlSecond) {
        this.ttlSecond = ttlSecond;
    }

    public int getMaxCache() {
        return maxCache;
    }

    public void setMaxCache(int maxCache) {
        this.maxCache = maxCache;
    }

    public String getCachePolicy() {
        return cachePolicy;
    }

    public void setCachePolicy(String cachePolicy) {
        this.cachePolicy = cachePolicy;
    }

    public CacheConfiguration cacheConfiguration(){
        return  new CacheConfiguration().eternal(false)
                .timeToIdleSeconds(ttlSecond)
                .maxEntriesLocalHeap(maxCache)
                .memoryStoreEvictionPolicy(cachePolicy)
                .name(cacheName);
    }

}
