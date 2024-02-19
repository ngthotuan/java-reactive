package tech.nttuan.rp.sec04;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.sec04.helper.Person;
import tech.nttuan.rp.util.Util;

import java.util.function.Function;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec10Transform {
    public static void main(String[] args) {
        getPersons()
                .transform(applyFilter())
                .subscribe(Util.subscriber());
    }

    private static Flux<Person> getPersons() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    private static Function<Flux<Person>, Flux<Person>> applyFilter() {
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing: " + p))
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                ;
    }
}
