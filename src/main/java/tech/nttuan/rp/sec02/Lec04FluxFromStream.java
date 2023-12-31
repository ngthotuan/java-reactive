package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by tuannt7 on 30/12/2023
 */
public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();

//        stream.forEach(System.out::println); // closed
//        stream.forEach(System.out::println);

//        Flux<Integer> integerFlux = Flux.fromStream(stream); // closed
//        Flux<Integer> integerFlux = Flux.fromStream(() -> stream); // closed
        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream()); // okie

        integerFlux.subscribe(Util.onNext());
        integerFlux.subscribe(Util.onNext());
    }
}
