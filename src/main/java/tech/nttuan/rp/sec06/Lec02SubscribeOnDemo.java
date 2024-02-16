package tech.nttuan.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec02SubscribeOnDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            Util.printThreadInfo("create");
            fluxSink.next(1);
        })
//                .subscribeOn(Schedulers.newParallel("tuannt7")) // multiple using it, subscribeOn to UpStream
                .doOnNext(value -> Util.printThreadInfo("next " + value));

//        flux
//                .doFirst(() -> Util.printThreadInfo("first2"))
//                .subscribeOn(Schedulers.boundedElastic())
//                .doFirst(() -> Util.printThreadInfo("first1"))
//                .subscribe(v -> Util.printThreadInfo("sub " + v));

        Runnable runnable = () -> flux
                .doFirst(() -> Util.printThreadInfo("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> Util.printThreadInfo("first1"))
                .subscribe(v -> Util.printThreadInfo("sub " + v));
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }
}
