package tech.nttuan.rp.sec10;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec01Repeat {

    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {
        getIntegers()
//                .repeat(2)
                .repeat(() -> atomicInteger.get() < 14)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .map(i -> atomicInteger.getAndIncrement())
                .doOnSubscribe(s -> System.out.println("-- Subscribed"))
                .doOnComplete(() -> System.out.println("-- Completed"))
                ;
    }
}
