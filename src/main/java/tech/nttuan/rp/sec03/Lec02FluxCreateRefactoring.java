package tech.nttuan.rp.sec03;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.sec03.helper.NameProducer;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 02/01/2024
 */

public class Lec02FluxCreateRefactoring {
    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(Util.subscriber(Lec02FluxCreateRefactoring.class.getSimpleName()));

        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
