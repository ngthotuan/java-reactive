package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 50) // default 75% of the requested rate
                .subscribe(Util.onNext());
    }
}
