package tech.nttuan.rp.sec06;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            Util.printThreadInfo("create");
            fluxSink.next(1);
        }).doOnNext(value -> Util.printThreadInfo("next " + value));

//        flux.subscribe(v -> Util.printThreadInfo("sub " + v));

        Runnable runnable = () -> flux.subscribe(v -> Util.printThreadInfo("sub " + v));
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.printThreadInfo();
        Util.sleepSeconds(5);
    }
}
