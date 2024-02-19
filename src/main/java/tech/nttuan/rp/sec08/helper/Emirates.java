package tech.nttuan.rp.sec08.helper;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Emirates {
    public static Flux<String> getFlights() {
        return Flux.range(1, Util.faker().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(i -> "Emirates " + Util.faker().random().nextInt(100, 999))
                .filter(s -> Util.faker().random().nextBoolean())
                ;
    }
}
