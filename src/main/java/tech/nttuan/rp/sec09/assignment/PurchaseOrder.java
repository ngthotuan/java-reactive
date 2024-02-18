package tech.nttuan.rp.sec09.assignment;

import lombok.Data;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 18/02/2024
 */

@Data
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;

    public PurchaseOrder() {
        this.item = Util.faker().commerce().productName();
        this.price = Double.parseDouble(Util.faker().commerce().price());
        this.category = Util.faker().commerce().department();
    }
}
