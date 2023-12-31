package tech.nttuan.rp.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import tech.nttuan.rp.sec02.assignment.StockPricePublisher;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class Lec10StockPriceAssignment {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StockPricePublisher.getPrices()
                .subscribeWith(new Subscriber<Integer>() {
                    private Subscription subscription;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(Long.MAX_VALUE);
                        this.subscription = subscription;
                    }

                    @Override
                    public void onNext(Integer price) {
                        System.out.printf("%s - Stock Price: %3d$\n", LocalDateTime.now(), price);
                        if (price > 110 || price < 90) {
                            System.out.println("price > 110 || price < 90 => doCancel");
                            subscription.cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Error: " + throwable.getMessage());
                        latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("completed!");
                        latch.countDown();
                    }
                });

        latch.await();
    }
}
