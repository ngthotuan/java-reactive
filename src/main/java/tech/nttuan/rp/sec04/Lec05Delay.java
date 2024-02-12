package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec05Delay {
    public static void main(String[] args) {
//        Queues
        System.setProperty("reactor.bufferSize.x", "10"); // default 32
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.onNext());
        Util.sleepSeconds(120);
    }
}
