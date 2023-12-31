package tech.nttuan.rp.sec02;

import tech.nttuan.rp.sec02.helper.NameGenerator;
import tech.nttuan.rp.util.Util;

import java.util.List;

/**
 * Created by tuannt7 on 31/12/2023
 */
public class Lec07FluxVsList {
    public static void main(String[] args) {
        int c = 3;

        List<String> list = NameGenerator.generateNamesList(c);
        System.out.println(list); // blocking and wait c seconds

        NameGenerator.generateNamesFlux(c)
                .subscribe(Util.onNext()); // emit every seconds
    }
}
