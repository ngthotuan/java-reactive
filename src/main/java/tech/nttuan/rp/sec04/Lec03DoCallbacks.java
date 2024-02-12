package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec03DoCallbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    System.out.println("inside create");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    if (!fluxSink.isCancelled()) {
                        if (Math.random() < 0.5) {
                            System.out.println("generated error!");
                            fluxSink.error(new RuntimeException("oops an error!"));
                        } else {
                            System.out.println("notify complete!");
                            fluxSink.complete();
                        }
                    }
                })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext " + o))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe " + subscription))
                .doOnRequest(l -> System.out.println("doOnRequest " + l))
                .doOnError(err -> System.out.println("doOnError " + err.getMessage()))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard " + o))
                .doFinally(signalType -> System.out.println("doFinally => signalType: " + signalType))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doFirst(() -> System.out.println("doFirst 2"))
                .take(2) // take only 2 elements to see doOnCancel, doOnDiscard
                .doFinally(signalType -> System.out.println("doFinally 2 => signalType: " + signalType))
                .subscribe(Util.subscriber());
    }
}
