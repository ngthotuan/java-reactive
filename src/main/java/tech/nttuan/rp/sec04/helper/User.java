package tech.nttuan.rp.sec04.helper;

import lombok.Data;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
@Data
public class User {
    private int id;
    private String name;

    public User(int id) {
        this.id = id;
        this.name = Util.faker().name().fullName();
    }
}
