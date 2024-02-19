package tech.nttuan.rp.sec04.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import tech.nttuan.rp.util.Util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class OrderService {
    private static final Map<Integer, List<Order>> userOrders = new HashMap<>();

    static {
        for (int i = 1; i <= 5; i++) {
            List<Order> orders = new ArrayList<>();
            int numOfOrders = Util.faker().random().nextInt(1, 3);
            for (int j = 1; j <= numOfOrders; j++) {
                orders.add(new Order(i));
            }
            userOrders.put(i, orders);
        }
    }

    public static Flux<Order> getOrders(int userId) {
        return Flux.create((FluxSink<Order> fluxSink) -> {
                    List<Order> orders = userOrders.get(userId);
                    if (orders == null) {
                        fluxSink.error(new RuntimeException("No order found for user: " + userId));
                        return;
                    }
                    System.out.println("emitting orders for user: " + userId + " thread: " + Thread.currentThread().getName());
                    orders.forEach(fluxSink::next);
                    fluxSink.complete();
                })
                .delayElements(Duration.ofSeconds(1))
                ;
    }

}
