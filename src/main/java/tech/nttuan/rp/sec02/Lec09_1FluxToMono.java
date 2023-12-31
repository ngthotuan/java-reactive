package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class Lec09_1FluxToMono {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next() // 1 -> Mono
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
