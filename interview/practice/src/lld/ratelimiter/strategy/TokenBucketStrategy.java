package lld.ratelimiter.strategy;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketStrategy implements RateLimiterStrategy{

    private final int capacity;
    private final double rateOfFillingTheBucket;
    private final long ttlInMillis;

    public TokenBucketStrategy(int capacity, double rateOfFillingTheBucket, long ttlInMillis) {
        this.capacity = capacity;
        this.rateOfFillingTheBucket = rateOfFillingTheBucket;
        this.ttlInMillis = ttlInMillis;
    }

    private final ConcurrentHashMap<String, Bucket> bucketConcurrentHashMap= new ConcurrentHashMap<>();

    private static class Bucket {
        double tokens;
        long lastRefillTime;
        long lastAccessTime;

        Bucket(double tokens, long currentTime) {
            this.tokens = tokens;
            this.lastRefillTime = currentTime;
            this.lastAccessTime = currentTime;
        }
    }


    @Override
    public boolean allowRequest(String userId) {
        long currentTimeMillis= System.currentTimeMillis();
        bucketConcurrentHashMap.putIfAbsent(userId, new Bucket(capacity, currentTimeMillis ));
        Bucket bucket= bucketConcurrentHashMap.get(userId);

        synchronized (bucket){
            if (currentTimeMillis - bucket.lastAccessTime > ttlInMillis){
                bucketConcurrentHashMap.remove(userId);
                bucketConcurrentHashMap.put(userId, new Bucket(capacity, currentTimeMillis));     //todo(doubt): check if the capacity should be capacity -1 or simply capacity ?--(solved)- Answer: this value will be taken care in the next statement/logic.
//                return true;
            }

            double tokensToAdd = ((currentTimeMillis- bucket.lastRefillTime)/1000.0) * rateOfFillingTheBucket;
            bucket.tokens= Math.min(bucket.tokens + tokensToAdd, capacity);
            bucket.lastRefillTime= currentTimeMillis;
            bucket.lastAccessTime= currentTimeMillis;
            if (bucket.tokens > 1){
                bucket.tokens = bucket.tokens -1;
                return true;
            } else {
                return false;
            }
        }

    }
}
