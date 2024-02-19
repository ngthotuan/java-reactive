package tech.nttuan.rp.sec09;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.sec09.assignment.OrderProcessor;
import tech.nttuan.rp.sec09.assignment.OrderService;
import tech.nttuan.rp.sec09.assignment.PurchaseOrder;
import tech.nttuan.rp.util.Util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec06Assignment {
    public static void main(String[] args) {
        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = new HashMap() {
            {
                put("Kids", OrderProcessor.kidsProcessing());
                put("Automotive", OrderProcessor.automotiveProcessing());
            }
        };
        Set<String> set = map.keySet();

        OrderService.orderStream()
                .filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory) // key: Kids, Automotive
                .flatMap(groupFlex -> map.get(groupFlex.key()).apply(groupFlex)) // flux
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
