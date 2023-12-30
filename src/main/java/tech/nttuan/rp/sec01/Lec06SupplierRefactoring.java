package tech.nttuan.rp.sec01;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/09/2023
 */
public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        Util.printThreadInfo();
        getName();
        getName()
                .subscribeOn(Schedulers.parallel()) // async, comment this to see affect
                .subscribe(Util.onNext()) // async comment this line bellow to test block(sync)
//                .block() // block (sync) behavior instead using subscribeOn, comment this line bellow to test
        ;
        getName();
        Util.printThreadInfo();
        Util.sleepSeconds(5);
    }

    private static Mono<String> getName() {
        Util.printThreadInfo();
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            Util.printThreadInfo();
            System.out.println("generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }

}
