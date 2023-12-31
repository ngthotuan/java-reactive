package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 30/12/2023
 */
public class Lec01FluxInto {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
