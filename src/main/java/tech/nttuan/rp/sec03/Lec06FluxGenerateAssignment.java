package tech.nttuan.rp.sec03;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/01/2024
 */

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {

        // canada
        // max = 10
        // subscriber cancels -> exit
        // Lec07
        Flux.generate(synchronousSink -> {;
                    System.out.println("Emitting...");
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
