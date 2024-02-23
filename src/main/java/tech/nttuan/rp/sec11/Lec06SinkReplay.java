package tech.nttuan.rp.sec11;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 22/02/2024
 */

public class Lec06SinkReplay {
    public static void main(String[] args) {
        // handle through which we should push items
        Sinks.Many<Object> sink = Sinks.many().replay().all();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();


        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");
        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("?");
        flux.subscribe(Util.subscriber("jake"));
        sink.tryEmitNext("new message");
    }
}
