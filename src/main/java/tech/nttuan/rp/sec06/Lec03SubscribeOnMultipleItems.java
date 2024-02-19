package tech.nttuan.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec03SubscribeOnMultipleItems {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.create((FluxSink<Integer> fluxSink) -> {
                    Util.printThreadInfo("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
                })
                .doOnNext(value -> Util.printThreadInfo("next " + value));

        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> Util.printThreadInfo("sub " + v));

        flux
                .subscribeOn(Schedulers.parallel())
                .subscribe(v -> Util.printThreadInfo("sub " + v));

        Util.sleepSeconds(5);
    }
}
