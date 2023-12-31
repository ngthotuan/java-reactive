package tech.nttuan.rp.sec02;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tuannt7 on 30/12/2023
 */
public class Lec03FluxFromListOrArr {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "apple", "hello");
        Flux.fromIterable(list)
                .subscribe(Util.onNext());

        Integer[] arr = {1, 2, 3, 4};
        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}
