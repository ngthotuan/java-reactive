package tech.nttuan.rp.sec08;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec02Concat {
    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.error(new RuntimeException("oops"));
        Flux<String> flux3 = Flux.just("c", "d", "e");

//        Flux<String> flux = flux1.concatWith(flux2);
//        Flux<String> flux = Flux.concat(flux1, flux2, flux3);
        Flux<String> flux = Flux.concatDelayError(flux1, flux2, flux3);
        flux.subscribe(Util.subscriber());
    }
}
