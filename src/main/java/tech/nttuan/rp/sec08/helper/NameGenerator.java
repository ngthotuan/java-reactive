package tech.nttuan.rp.sec08.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;
import tech.nttuan.rp.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class NameGenerator {
    private List<String> cache = new ArrayList<>();

    public Flux<String> generateNames() {
        return Flux.generate((SynchronousSink<String> sink) -> {
                    System.out.println("Generating name");
                    Util.sleepSeconds(1);
                    String name = Util.faker().name().fullName();
                    cache.add(name);
                    sink.next(name);
                })
//                .cast(String.class) //or (SynchronousSink<String> sink)
                .startWith(cache);
    }
}
