package tech.nttuan.rp.sec10;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec02Retry {

    public static void main(String[] args) {
        getIntegers()
                .retry(2)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .map(i -> i / (Util.faker().random().nextInt(1, 5) > 3 ? 0 : 1))
                .doOnSubscribe(s -> System.out.println("-- Subscribed"))
                .doOnComplete(() -> System.out.println("-- Completed"))
                .doOnError(err -> System.out.println("-- Error: " + err))
                ;
    }
}
