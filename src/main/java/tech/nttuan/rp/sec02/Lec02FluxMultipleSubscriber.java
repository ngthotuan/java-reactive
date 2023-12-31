package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;

/**
 * Created by tuannt7 on 30/12/2023
 */
public class Lec02FluxMultipleSubscriber {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        Flux<Integer> evenFlux = flux.filter(i -> i % 2 == 0);

        flux
                .subscribe((i) -> System.out.println("sub1: " + i));
        evenFlux
                .subscribe((i) -> System.out.println("sub2: " + i));
    }
}
