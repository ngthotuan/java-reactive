package tech.nttuan.rp.sec11;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 22/02/2024
 */

public class Lec01SinkOne {
    public static void main(String[] args) {

        // mono 1 value/empty/error
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("sam"));
        mono.subscribe(Util.subscriber("mike"));
        sink.tryEmitValue("hi");
//        sink.tryEmitError(new RuntimeException("Oops!!!"));
//        sink.emitValue("hi", (signalType, emitResult) -> {
//            System.out.println(signalType);
//            System.out.println(emitResult.name());
//            return false;
//        });
//
//        sink.emitValue("hello", (signalType, emitResult) -> {
//            System.out.println(signalType);
//            System.out.println(emitResult.name());
////            return false;
//            return true; // retry ? -> loop
//        });
    }
}
