package tech.nttuan.rp.sec10;

import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import tech.nttuan.rp.util.Util;

import java.time.Duration;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec04RetryWhenAdvanced {
    public static void main(String[] args) {
        orderService(Util.faker().business().creditCardNumber())
//                .retry(5)
                .retryWhen(Retry.from(
                        flux -> flux
                                .doOnNext(rs -> {
                                    System.out.println("rs.totalRetries() = " + rs.totalRetries());
                                    System.out.println("rs.failure() = " + rs.failure());
                                })
                                .handle((rs, sink) -> {
                                    if (rs.failure().getMessage().equals("500")) {
                                        sink.next(1);
                                    } else {
                                        sink.error(rs.failure());
                                    }
                                })
                                .delayElements(Duration.ofSeconds(1))
                ))
                .doOnError(err -> System.err.println(err.getMessage()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    // order service
    private static Mono<String> orderService(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return Util.faker().idNumber().valid();
        });
    }

    // payment service
    private static void processPayment(String ccNumber) {
        int random = Util.faker().random().nextInt(1, 10);
        if (random < 8) {
            throw new RuntimeException("500");
        } else if (random < 10) {
            throw new RuntimeException("404");
        }
    }
}
