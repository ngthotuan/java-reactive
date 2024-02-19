package tech.nttuan.rp.sec04.helper;

import lombok.Data;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 12/02/2024
 */
@Data
public class Order {
    private int userId;
    private String item;
    private String price;

    public Order(int userId) {
        this.userId = userId;
        this.item = Util.faker().commerce().productName();
        this.price = Util.faker().commerce().price();
    }
}
