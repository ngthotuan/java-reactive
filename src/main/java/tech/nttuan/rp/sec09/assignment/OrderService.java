package tech.nttuan.rp.sec09.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class OrderService {

    public static Flux<PurchaseOrder> orderStream() {
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> new PurchaseOrder());
    }
}
