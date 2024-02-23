package tech.nttuan.rp.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 22/02/2024
 */

public class Lec05SinkMultiDirectAll {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");

        // handle through which we should push items
//        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("sam"));
        flux.delayElements(Duration.ofMillis(200))
                .subscribe(Util.subscriber("mike"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Util.sleepSeconds(30);
    }
}
