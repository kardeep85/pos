package inventory.config;

import net.sf.ehcache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableCaching
public class EnableCacheConfig {
    @Bean
    public CacheProperty cacheProperty(){
        return new CacheProperty();
    }

    @Bean(name ="test")
    public EhCacheManagerFactoryBean cacheManager()
    {
        return new EhCacheManagerFactoryBean();
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        Cache testCache = new Cache(cacheProperty().cacheConfiguration());
        cacheManager().getObject().addCache(testCache);
        return new EhCacheCacheManager(cacheManager().getObject());
    }

}
