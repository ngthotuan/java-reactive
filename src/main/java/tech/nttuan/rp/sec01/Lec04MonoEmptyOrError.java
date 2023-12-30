package tech.nttuan.rp.sec01;

import reactor.core.publisher.Mono;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 21/09/2023
 */
public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println("userId = " + i);
            userRepository(i)
                    .subscribe(
                            Util.onNext(),
                            Util.onError(),
                            Util.onComplete()
                    );
        }
    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().username());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Not in allow range!"));
        }
    }
}
