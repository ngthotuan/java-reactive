package tech.nttuan.rp.sec05;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;
import java.util.stream.Stream;

/**
 * Created by tuannt7 on 14/02/2024
 */
public class Lec01ColdPublisher {
    public static void main(String[] args) {
        Flux<String> moviesStream = Flux.fromStream(Lec01ColdPublisher::getMovies)
                .delayElements(Duration.ofSeconds(1));

        // First subscriber
        moviesStream.subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(2);

        // Second subscriber
        moviesStream.subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(30);
    }

    private static Stream<String> getMovies() {
        System.out.println("Retrieving movies");
        return Stream.of("F1", "F2", "F3", "F4", "F5");
    }
}
