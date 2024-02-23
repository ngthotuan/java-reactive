package tech.nttuan.rp.sec11.assignment;

import lombok.Data;

/**
 * Created by tuannt7 on 22/02/2024
 */

@Data
public class SlackMessage {
    private static final String FORMAT = "[%s -> %s]: %s";

    private String sender;
    private String receiver;
    private String message;

    @Override
    public String toString() {
        return String.format(FORMAT, sender, receiver, message);
    }
}
