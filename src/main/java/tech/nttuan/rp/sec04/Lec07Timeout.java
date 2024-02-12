package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec07Timeout {
    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2))
//                .timeout(Duration.ofSeconds(2), fallback())
                .subscribe(Util.subscriber());
        Util.sleepSeconds(30);
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10)
//                .delayElements(Duration.ofSeconds(5))
                .delayElements(Duration.ofSeconds(1))
                ;
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(300));
    }

}
