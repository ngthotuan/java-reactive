package tech.nttuan.rp.sec03;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/01/2024
 */

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("Emitting: " + country);
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
                    //  !fluxSink.isCancelled() fix issue take 3 but still emit
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
