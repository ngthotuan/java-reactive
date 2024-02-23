package tech.nttuan.rp.sec12.helper;

import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by tuannt7 on 23/02/2024
 */

public class UserService {
    private static final Map<String, String> MAP = new HashMap(){
        {
            put("sam", "std");
            put("mike", "prime");
        }
    };

    public static Function<Context, Context> userCategoryContext() {
        return ctx -> {
            String user = ctx.get("user");
            String category = MAP.getOrDefault(user, "std");
            return ctx.put("category", category);
        };
    }
}
