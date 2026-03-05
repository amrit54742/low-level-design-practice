package lld.ratelimiter;

import lld.ratelimiter.service.RateLimiterService;
import lld.ratelimiter.strategy.FixedWindowStrategy;
import lld.ratelimiter.strategy.RateLimiterStrategy;
import lld.ratelimiter.strategy.TokenBucketStrategy;

public class RateLimiterMain {

    public static void main(String[] args) throws InterruptedException {

        //todo: remember to comment one strategy before running the application, otherwise, you would get wrong output.

//        RateLimiterStrategy strategy =
//                new FixedWindowStrategy(3, 5000); // 3 requests per 5 sec
//
//        RateLimiterService rateLimiter =
//                RateLimiterService.getInstance(strategy);
//
//        for (int i = 0; i < 5; i++) {
//            boolean allowed = rateLimiter.allowRequest("user1");
//            System.out.println("Request " + (i + 1) + ": " + allowed);
//        }


        RateLimiterStrategy strategy1 =
                new TokenBucketStrategy(
                        5,     // capacity
                        1.0,   // refill 1 token per second
                        60000  // TTL 60 sec
                );

        RateLimiterService limiter =
                RateLimiterService.getInstance(strategy1);

        for (int i = 0; i < 10; i++) {
            System.out.println(limiter.allowRequest("user1"));
            Thread.sleep(500);
//            Thread.sleep(2500);
        }

    }

}
