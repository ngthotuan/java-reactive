package tech.nttuan.rp.sec12;

import reactor.util.context.Context;
import tech.nttuan.rp.sec12.helper.BookService;
import tech.nttuan.rp.sec12.helper.UserService;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/02/2024
 */

public class Lec02CtxRateLimiterDemo {
    public static void main(String[] args) {
        BookService.getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
//                .contextWrite(Context.of("user", "sam")) // 2 attempts (std)
                .contextWrite(Context.of("user", "mike")) // 3 attempts (prime)
                .subscribe(Util.subscriber());
    }
}
