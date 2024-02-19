package tech.nttuan.rp.sec06;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import tech.nttuan.rp.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec06Parallel {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // not thread safe
        Flux.range(1, 10000)
//                .parallel(2)
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(value -> Util.printThreadInfo("next " + value))
                .subscribe(list::add)
//                .subscribe(v -> Util.printThreadInfo("sub " + v))
        ;
        Util.sleepSeconds(5);
        System.out.println(list.size());
    }
}
