package tech.nttuan.rp.sec03;

import tech.nttuan.rp.sec03.helper.FileReaderService;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 24/01/2024
 */
public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        String fileName = "file01.txt";
        FileReaderService.read(fileName)
//                .map(l -> {
//                    Integer r = Util.faker().random().nextInt(1, 10);
//                    if (r > 8) {
//                        System.out.println("r = " + r + " => throw exception");
//                        throw new RuntimeException("test exception!");
//                    }
//                    return l;
//                })
//                .take(5)
                .subscribe(Util.subscriber())
        ;
    }
}
