package tech.nttuan.rp.sec02.assignment;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class StockPricePublisher {

    public static Flux<Integer> getPrices() {
        AtomicInteger currentPrice = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> currentPrice.getAndAccumulate(Util.faker().random().nextInt(-5, 5), Integer::sum));
    }

}
