package tech.nttuan.rp.sec09;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec01Buffer {
    public static void main(String[] args) {
        eventStream()
//                .buffer(5)
//                .buffer(Duration.ofSeconds(2))
                .bufferTimeout(5, Duration.ofSeconds(2))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
//        return Flux.interval(Duration.ofMillis(300))
        return Flux.interval(Duration.ofMillis(800))
//        return Flux.interval(Duration.ofMillis(10))
                .map(i -> "event" + i);
    }
}
