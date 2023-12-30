package tech.nttuan.rp.sec01;

import reactor.core.publisher.Mono;
import tech.nttuan.rp.util.Util;

import java.util.concurrent.CompletableFuture;

/**
 * Created by tuannt7 on 24/09/2023
 */
public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName())
                .subscribe(Util.onNext());
        Util.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
