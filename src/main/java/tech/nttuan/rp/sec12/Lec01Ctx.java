package tech.nttuan.rp.sec12;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/02/2024
 */

public class Lec01Ctx {
    public static void main(String[] args) {
        getWelcomeMessage()
                .contextWrite(ctx -> ctx.put("user", ctx.get("user").toString().toUpperCase()))
                .contextWrite(ctx -> ctx.put("user", "sam"))
                .contextWrite(Context.of("user", "jake"))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(ctx -> {
            if (ctx.hasKey("user")) {
                return Mono.just("Welcome " + ctx.get("user"));
            } else {
                return Mono.error(new RuntimeException("unauthenticated!"));
            }
        });
    }
}
