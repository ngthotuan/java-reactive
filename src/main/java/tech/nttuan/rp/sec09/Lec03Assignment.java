package tech.nttuan.rp.sec09;

import reactor.core.publisher.Flux;
import tech.nttuan.rp.sec09.heper.BookOrder;
import tech.nttuan.rp.sec09.heper.RevenueReport;
import tech.nttuan.rp.util.Util;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by tuannt7 on 18/02/2024
 */
public class Lec03Assignment {
    public static void main(String[] args) {
        Set<String> allowCategories = new HashSet(){{
            add("Science fiction");
            add("Fantasy");
            add("Suspense/Thriller");
        }};

        bookStream()
                .filter(book -> allowCategories.contains(book.getCategory()))
                .buffer(Duration.ofSeconds(2))
                .map(Lec03Assignment::revenueReportCalculator)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static RevenueReport revenueReportCalculator(List<BookOrder> books) {
        Map<String, Double> map = books.stream()
                .collect(Collectors.groupingBy(BookOrder::getCategory, Collectors.summingDouble(BookOrder::getPrice)));
        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }
}
