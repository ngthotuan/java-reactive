package tech.nttuan.rp.sec01;

import reactor.core.publisher.Mono;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 30/12/2023
 */
public class Lec08MonoFromRunable {
    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> System.out.println("Operation completed! Sending email...")
                );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            System.out.println("Start job scan pending trans!");
            Util.sleepSeconds(5);
            System.out.println("Done job scan pending trans!");
        };
    }
}
