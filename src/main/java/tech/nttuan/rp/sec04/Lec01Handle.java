package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec01Handle {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .handle((i, syncSink) -> {
                    if (i % 2 == 0) {
                        syncSink.next(i); // filter
                    } else {
                        syncSink.next(i + "a"); // map
                    }
                })
                .subscribe(Util.onNext());
    }
}
