package tech.nttuan.rp.sec08;

import tech.nttuan.rp.sec08.helper.NameGenerator;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 16/02/2024
 */
public class Lec01StartWith {
    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));
        nameGenerator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("jen"));

        nameGenerator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("mike"));

        nameGenerator.generateNames()
                .filter(s -> s.startsWith("A"))
                .take(1)
                .subscribe(Util.subscriber("jake"));
    }
}
