package tech.nttuan.rp.sec01.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by tuannt7 on 30/12/2023
 */
public class FileService {
    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private static String readFile(String fileName) {
        try {
            Path path = PATH.resolve(fileName);
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String fileName, String content) {
        try {
            Path path = PATH.resolve(fileName);
            Files.write(path, content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String fileName) {
        try {
            Path path = PATH.resolve(fileName);
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
