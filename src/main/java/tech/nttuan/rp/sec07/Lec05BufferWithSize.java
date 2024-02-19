package tech.nttuan.rp.sec07;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec05BufferWithSize {
    public static void main(String[] args) {
//        Queues.SMALL_BUFFER_SIZE = 16;
        System.setProperty("reactor.bufferSize.small", "16");
        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                        Util.sleepMilis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureBuffer(50, o -> System.out.println("Dropped: " + o))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Util.sleepMilis(10))
                .subscribe(Util.subscriber())
        ;

        Util.sleepSeconds(10);
    }
}
