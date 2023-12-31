package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class Lec05_1FluxLog {
    public static void main(String[] args) {
        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
//                .log()
                .subscribe(Util.onNext());
    }
}
