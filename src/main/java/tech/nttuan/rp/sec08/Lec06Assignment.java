package tech.nttuan.rp.sec08;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec06Assignment {

    private static final int carPrice = 10000;

    public static void main(String[] args) {
        Flux.combineLatest(monthStream(), demandStream(), (month, demand) -> {
                    return (carPrice - (month * 100)) * demand;
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Long> monthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream() {
        return Flux.interval(Duration.ofSeconds(3))
                .map(i -> Util.faker().random().nextInt(8, 12) / 10d)
                .startWith(1d);
    }
}
