package tech.nttuan.rp.sec03.helper;

import reactor.core.publisher.FluxSink;
import tech.nttuan.rp.util.Util;

import java.util.function.Consumer;

/**
 * Created by tuannt7 on 02/01/2024
 */

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.fluxSink = fluxSink;
    }

    public void produce() {
        String name = Util.faker().name().fullName();
        String thread = Thread.currentThread().getName();
        this.fluxSink.next(thread + " => " + name);
    }
}
