package tech.nttuan.rp.sec03.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Created by tuannt7 on 23/01/2024
 */

public class FileReaderService {
    private static final Path PATH = Paths.get("src/main/resources/assignment/sec03");

    private static Callable<BufferedReader> openReader(Path filePath) {
        return () -> Files.newBufferedReader(filePath);
    }
    private static BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read = (br, sink) -> {
        try {
            String line = br.readLine();
            if(line != null) {
                sink.next(line);
            } else {
                sink.complete();
            }
        } catch (IOException e) {
            sink.error(e);
        }
        return br;
    };
    private static Consumer<BufferedReader> closeReader = br -> {
        try {
            System.out.println("Closing reader...");
            br.close();
        } catch (IOException e) {
            System.err.println("Error closing reader... " + e.getMessage());
        }
    };
    public static Flux<String> read(String filename) {
        Path filePath = PATH.resolve(filename);
        return Flux.generate(openReader(filePath), read, closeReader);
    }
}
