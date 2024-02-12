package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec02GenerateAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((s, syncSink) -> {
                    syncSink.next(s);
                    if (s.equalsIgnoreCase("canada")) {
                        syncSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
