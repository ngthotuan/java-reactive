package tech.nttuan.rp.sec03;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/01/2024
 */

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter, synchronousSink) -> {
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if (counter >= 10 || country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                    return counter + 1;
                }
        ).subscribe(Util.subscriber());
    }
}
