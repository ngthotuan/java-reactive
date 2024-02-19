package tech.nttuan.rp.sec09.heper;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by tuannt7 on 18/02/2024
 */
@Data
public class RevenueReport {
    private LocalDateTime time = LocalDateTime.now();
    private Map<String, Double> revenue;

    public RevenueReport(Map<String, Double> revenue) {
        this.revenue = revenue;
    }
}
