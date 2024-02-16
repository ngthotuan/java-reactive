package tech.nttuan.rp.util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

/**
 * Created by tuannt7 on 21/09/2023
 */
public class Util {
    private static final Faker FAKER = Faker.instance();
    public static Consumer<Object> onNext() {
        return o -> System.out.println("received: " + o);
    }
    public static Consumer<Throwable> onError() {
        return e -> System.out.println("error: " + e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("completed!");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepSeconds(int seconds) {
        try {
//            System.out.printf("sleep %s seconds\n", seconds);
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printThreadInfo() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getId() + "-" + currentThread.getName());
    }

    public static void printThreadInfo(Object value) {
        Thread currentThread = Thread.currentThread();
        System.out.println(value + "\t -> " + currentThread.getId() + "-" + currentThread.getName());
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }

}
