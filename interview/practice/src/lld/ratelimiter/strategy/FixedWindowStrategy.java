package lld.ratelimiter.strategy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowStrategy implements RateLimiterStrategy{

    private final ConcurrentHashMap<String, WindowInfo> fixedWindowHashmap= new ConcurrentHashMap<>();
    private final int capacity;
    private final long windowSizeInMillis;
    private static class WindowInfo{
        long windowStartTime;
        AtomicInteger windowRequestCount;

        WindowInfo(long windowStartTime){
            this.windowStartTime=windowStartTime;
            this.windowRequestCount= new AtomicInteger(0);
        }

    }

    public FixedWindowStrategy(int capacity, long windowSizeInMillis) {
        this.capacity = capacity;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    @Override
    public boolean allowRequest(String userId) {

        long currentTime= System.currentTimeMillis();
        fixedWindowHashmap.putIfAbsent(userId, new WindowInfo(currentTime));
        WindowInfo requestInfo = fixedWindowHashmap.get(userId);

        synchronized (requestInfo){
            if (currentTime- fixedWindowHashmap.get(userId).windowStartTime > windowSizeInMillis){
                requestInfo.windowStartTime= currentTime;
                requestInfo.windowRequestCount.set(0); //todo(doubt)- check the value of the request count value -- solved(answer: it will be taken care in the next if statement)
            }

            if (requestInfo.windowRequestCount.get() < capacity){
                requestInfo.windowRequestCount.incrementAndGet();
                return true;

            } else {
                return false;
            }
        }

    }
}
