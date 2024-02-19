package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumberCaches()
                .switchIfEmpty(getOrderNumbersDb())
                .subscribe(Util.subscriber());
    }

    // redis
    private static Flux<Integer> getOrderNumberCaches() {
        if (Math.random() > 0.5) {
            System.out.println("From cache");
            return Flux.range(1, 10);
        } else {
            System.out.println("From cache is empty");
            return Flux.empty();
        }
    }

    private static Flux<Integer> getOrderNumbersDb() {
        return Flux.range(20, 10);
    }
}
