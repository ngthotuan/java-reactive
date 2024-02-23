package tech.nttuan.rp.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import tech.nttuan.rp.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by tuannt7 on 22/02/2024
 */

public class Lec03SinkThreadSafety {
    public static void main(String[] args) {
        // handle through which we should push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        List<Object> list = new ArrayList<>();

        flux.subscribe(list::add);
//        for (int i = 0; i < 1000; i++) {
//            final int j = i;
//            CompletableFuture.runAsync(() -> {
//                sink.tryEmitNext(j);
//            });
//        }
        for (int i = 0; i < 1000; i++) {
            final int j = i;
            CompletableFuture.runAsync(() -> {
                sink.emitNext(j, (signalType, emitResult) -> true);
            });
        }

        Util.sleepSeconds(3);
        System.out.println(list.size());
    }
}
