package tech.nttuan.rp.sec02.helper;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class NameGenerator {

    public static List<String> generateNamesList(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> generateNamesFlux(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }

    private static String getName() {
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
