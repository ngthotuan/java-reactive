package tech.nttuan.rp.sec08;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec04Zip {
    public static void main(String[] args) {
        Flux.zip(getBody(), getEngine(), getTires())
                .subscribe(Util.subscriber());
    }

    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(i -> "body_" + i);
    }

    private static Flux<String> getEngine() {
        return Flux.range(1, 2)
                .map(i -> "engine_" + i);
    }

    private static Flux<String> getTires() {
        return Flux.range(1, 6)
                .map(i -> "tires_" + i);
    }
}
