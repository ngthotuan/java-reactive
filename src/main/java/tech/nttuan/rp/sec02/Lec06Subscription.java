package tech.nttuan.rp.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import tech.nttuan.rp.util.Util;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class Lec06Subscription {

    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("onSubscribe :" + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete!");
                    }
                });

        Util.sleepSeconds(2);
        atomicReference.get().request(3);
        Util.sleepSeconds(3);
        atomicReference.get().request(2);
        Util.sleepSeconds(3);
        System.out.println("doCancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(2);
        System.out.println("request 3 again to see!!!");
        atomicReference.get().request(3);
        Util.sleepSeconds(2);
    }
}
