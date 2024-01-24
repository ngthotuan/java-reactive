package tech.nttuan.rp.sec03;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/01/2024
 */

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("Emitting...");
                    synchronousSink.next(Util.faker().country().name()); // 1
//                    synchronousSink.next(Util.faker().country().name()); // error!!! -> emit 1
                    synchronousSink.complete(); // emit complete
//                    synchronousSink.error(new RuntimeException("oops")); // emit error
                })
                .take(5)
                .subscribe(Util.subscriber())
        ;
    }
}
