package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class Lec08FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSeconds(5);
    }
}
