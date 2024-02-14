package tech.nttuan.rp.sec05;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;
import java.util.stream.Stream;

/**
 * Created by tuannt7 on 14/02/2024
 */
public class Lec04HotAutoConnect {
    private static Stream<String> getMovies() {
        System.out.println("Retrieving movies");
        return Stream.of("F1", "F2", "F3", "F4", "F5");
    }

    public static void main(String[] args) {
        Flux<String> moviesStream = Flux.fromStream(Lec04HotAutoConnect::getMovies)
                .delayElements(Duration.ofSeconds(1))
                .publish()
//                .autoConnect(2); // wait for 2 subscribers
//                .autoConnect(); // wait for 1 subscriber
                .autoConnect(0);

        Util.sleepSeconds(2);

        // First subscriber
        moviesStream.subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(7);

        // Second subscriber
        System.out.println("Mike is about to join");
        moviesStream.subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(30);
    }
}
