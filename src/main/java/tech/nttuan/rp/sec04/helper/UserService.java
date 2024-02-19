package tech.nttuan.rp.sec04.helper;

import reactor.core.publisher.Flux;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class UserService {
    public static Flux<User> getUsers() {
        return Flux.range(1, 5)
                .map(User::new);
    }
}
