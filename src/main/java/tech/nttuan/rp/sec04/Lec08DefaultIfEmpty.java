package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec08DefaultIfEmpty {
    public static void main(String[] args) {
        Flux
                .range(1, 10)
//                .range(1, 15)
                .filter(i -> i > 10)
                .defaultIfEmpty(-1) // value
                .subscribe(Util.subscriber());
    }
}
