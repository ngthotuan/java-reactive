package tech.nttuan.rp.sec03;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/01/2024
 */

public class Lec03FluxTake {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3) // cancel subscription after 3 elements -> flux not emit any more
                .log()
                .subscribe(Util.subscriber());
    }
}
