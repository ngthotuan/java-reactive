package tech.nttuan.rp.sec01;

import tech.nttuan.rp.util.Util;

import java.util.stream.Stream;

/**
 * Created by tuannt7 on 21/09/2023
 */
public class Lec01Stream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 3, 4)
                .map(i -> {
                    Util.sleepSeconds(1);
                    return i * 2;
                });

        System.out.println(stream);
        stream.forEach(System.out::println);
    }
}
