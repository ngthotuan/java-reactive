package tech.nttuan.rp.sec09;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.nttuan.rp.util.Util;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec04Window {
    private static AtomicInteger count = new AtomicInteger(1);
    public static void main(String[] args) {

        eventStream()
//                .window(5)
                .window(Duration.ofSeconds(2))
                .flatMap(Lec04Window::saveEvents)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event" + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux) {
        return flux
                .doOnNext(e -> System.out.println("Saving " + e))
                .doOnComplete(() -> {
                    System.out.println("saved");
                    System.out.println("===========");
                })
                .then(Mono.just(count.getAndIncrement()));
    }
}
