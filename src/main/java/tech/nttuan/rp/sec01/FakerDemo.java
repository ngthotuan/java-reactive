package tech.nttuan.rp.sec01;

import com.github.javafaker.Faker;

/**
 * Created by tuannt7 on 21/09/2023
 */
public class FakerDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Faker.instance().animal().name());
        }
    }
}
