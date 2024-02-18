package tech.nttuan.rp.sec08;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.sec08.helper.AmericanAirlines;
import tech.nttuan.rp.sec08.helper.Emirates;
import tech.nttuan.rp.sec08.helper.Qatar;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec03Merge {
    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                AmericanAirlines.getFlights(),
                Emirates.getFlights()
        );
        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
