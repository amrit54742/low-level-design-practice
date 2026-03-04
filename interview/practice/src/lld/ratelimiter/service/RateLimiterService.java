package lld.ratelimiter.service;

import lld.ratelimiter.strategy.RateLimiterStrategy;

public class RateLimiterService {

    private RateLimiterStrategy rateLimiterStrategy;
    private static RateLimiterService instance;

    public RateLimiterService(RateLimiterStrategy rateLimiterStrategy) {
        this.rateLimiterStrategy = rateLimiterStrategy;
    }

    public static RateLimiterService getInstance(RateLimiterStrategy strategy) {
        if (instance == null) {
            instance = new RateLimiterService(strategy);
        }
        return instance;
    }

    public boolean allowRequest(String userId) {
        return rateLimiterStrategy.allowRequest(userId);
    }




}
