package tech.nttuan.rp.sec01;

import tech.nttuan.rp.sec01.assignment.FileService;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 30/12/2023
 */
public class Lec09AssignmentDemo {
    public static void main(String[] args) {

        FileService.read("file03.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.write("file03.txt", "This is the content!\nHello")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        FileService.delete("file03.txt")
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }
}
