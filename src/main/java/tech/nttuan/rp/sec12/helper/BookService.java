package tech.nttuan.rp.sec12.helper;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import tech.nttuan.rp.util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by tuannt7 on 23/02/2024
 */

public class BookService {
    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("std", 2);
        map.put("prime", 3);
    }

    public static Mono<String> getBook() {
        return Mono.deferContextual(ctx -> {
                    if (ctx.get("allowed")) {
                        return Mono.just(Util.faker().book().title());
                    }
                    return Mono.error(new RuntimeException("Not-allowed to access the book. Please try again later."));
                })
                .contextWrite(rateLimiterContext());
    }

    private static Function<Context, Context> rateLimiterContext() {
        return context -> {
            if (context.hasKey("category")) {
                String category = context.get("category");
                Integer attempts = map.get(category);
                if (attempts > 0) {
                    map.put(category, attempts - 1);
                    return context.put("allowed", true);
                }
            }
            return context.put("allowed", false);
        };
    }
}
