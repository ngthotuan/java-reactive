package tech.nttuan.rp.sec04.helper;

import lombok.Data;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */

@Data
public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = Util.faker().name().fullName();
        this.age = Util.faker().random().nextInt(1, 30);
    }
}
