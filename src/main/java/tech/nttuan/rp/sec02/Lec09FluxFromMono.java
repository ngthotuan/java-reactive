package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class Lec09FluxFromMono {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());
        doSomething(flux);
    }

    private static void doSomething(Flux<String> flux) {

    }
}
