package tech.nttuan.rp.sec08;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec05Group {
    public static void main(String[] args) {
        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2 == 0 ? "even" : "odd") // key: even, odd
                .subscribe(groupFlex -> process(groupFlex, groupFlex.key()));

        Util.sleepSeconds(30);
    }

    private static void process(Flux<Integer> flux, String key) {
        System.out.println("Called with key: " + key);
        flux.subscribe(i -> System.out.println("Key: " + key + ", Item: " + i));
    }
}
