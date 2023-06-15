package de.neuefische.cachingscheduling;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnyService {

    private static final String HELLO_CACHE_KEY = "hello";

    @Cacheable(HELLO_CACHE_KEY)
    public String getHello(String name) throws InterruptedException {
        System.out.println("In the Beginning");
        Thread.sleep(4000);
        System.out.println("After 4 seconds");
        return "Hello World!" + " " + name + " "+ LocalDateTime.now();
    }

    @CacheEvict(value = {HELLO_CACHE_KEY},allEntries=true)
    public String clearCache() {
        return "Cache-Cleared";
    }

    @Scheduled(initialDelay = 3000, fixedDelay = 2000)
    public void scheduling(){
        System.out.println("Scheduling");
    }

}
