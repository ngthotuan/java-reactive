package tech.nttuan.rp.sec04;

import tech.nttuan.rp.sec04.helper.OrderService;
import tech.nttuan.rp.sec04.helper.UserService;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getId()))
//                .concatMap(user -> OrderService.getOrders(user.getId())) // publisher1 done -> publisher2,...
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
