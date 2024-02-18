package tech.nttuan.rp.sec09.heper;

import com.github.javafaker.Book;
import lombok.Data;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 18/02/2024
 */
@Data
public class BookOrder {
    private String title;
    private String author;
    private String category;
    private double price;

    public BookOrder() {
        Book book = Util.faker().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
        this.price = Double.parseDouble(Util.faker().commerce().price());
    }
}
