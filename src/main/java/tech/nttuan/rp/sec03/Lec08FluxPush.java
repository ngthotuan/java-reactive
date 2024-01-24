package tech.nttuan.rp.sec03;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.sec03.helper.NameProducer;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/01/2024
 */

public class Lec08FluxPush {
    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();
        Flux.push(nameProducer)// not thread safe -> use create thread safe
                .subscribe(Util.subscriber(Lec02FluxCreateRefactoring.class.getSimpleName()));

        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
