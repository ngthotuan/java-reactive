package tech.nttuan.rp.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by tuannt7 on 02/01/2024
 */

public class DefaultSubscriber implements Subscriber<Object> {
    private String name;

    public DefaultSubscriber() {
        this.name = "";
    }

    public DefaultSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + " - onNext: " + o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + " - onError: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " - onCompleted!");
    }
}
