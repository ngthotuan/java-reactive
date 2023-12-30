package tech.nttuan.rp.sec01;

import reactor.core.publisher.Mono;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 21/09/2023
 */
public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 1)
                ;

        // 1
        mono.subscribe();

        // 2
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}

