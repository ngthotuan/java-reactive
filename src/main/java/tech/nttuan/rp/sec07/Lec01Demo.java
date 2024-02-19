package tech.nttuan.rp.sec07;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec01Demo {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    for (int i = 1; i < 501; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed: " + i);
                    }
                    fluxSink.complete();
                })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> Util.sleepMilis(10))
                .subscribe(Util.subscriber())
        ;

        Util.sleepSeconds(10);
    }
}
