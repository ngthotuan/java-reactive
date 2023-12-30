package tech.nttuan.rp.sec01;

import reactor.core.publisher.Mono;
import tech.nttuan.rp.util.Util;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Created by tuannt7 on 21/09/2023
 */
public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        // use just only when you have data already
//        Mono<String> mono = Mono.just(getName());


        // from supplier
        Supplier<String> supplier = () -> getName();
        Mono<String> monoSupplier = Mono.fromSupplier(supplier);
        monoSupplier.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        // from callable
        Callable<String> callable = () -> getName();
        Mono<String> monoCallable = Mono.fromCallable(callable);
        monoCallable.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    private static String getName() {
        System.out.println("generating name...");
        return Util.faker().name().fullName();
    }
}
