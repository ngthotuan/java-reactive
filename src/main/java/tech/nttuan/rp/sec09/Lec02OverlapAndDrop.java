package tech.nttuan.rp.sec09;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec02OverlapAndDrop {
    public static void main(String[] args) {
        eventStream()
                .buffer(3, 2)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event" + i);
    }
}
