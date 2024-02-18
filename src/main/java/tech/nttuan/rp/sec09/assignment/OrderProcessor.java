package tech.nttuan.rp.sec09.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class OrderProcessor {
    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> automotiveProcessing() {
        return orderFlux -> orderFlux
                .doOnNext(p -> p.setPrice(p.getPrice() * 1.1))
                .doOnNext(p -> p.setItem("{{ " + p.getItem() + " }}"))
                ;
    }
    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> kidsProcessing() {
        return orderFlux -> orderFlux
                .doOnNext(p -> p.setPrice(p.getPrice() * 0.5))
//                .flatMap(p -> Flux.just(p, getFreeKidsOrder()))
                .flatMap(p -> Flux.concat(Mono.just(p), getFreeKidsOrder()))
                ;
    }

//    private static PurchaseOrder getFreeKidsOrder(){
//        PurchaseOrder purchaseOrder = new PurchaseOrder();
//        purchaseOrder.setCategory("Kids");
//        purchaseOrder.setPrice(0);
//        purchaseOrder.setItem("FREE-" + purchaseOrder.getItem());
//        return purchaseOrder;
//    }

    // sample api call
    private static Mono<PurchaseOrder> getFreeKidsOrder(){
        return Mono.fromSupplier(() -> {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setCategory("Kids");
            purchaseOrder.setPrice(0);
            purchaseOrder.setItem("FREE-" + purchaseOrder.getItem());
            return purchaseOrder;
        });
    }
}
