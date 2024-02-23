package tech.nttuan.rp.sec11.assignment;

import lombok.Data;

import java.util.function.Consumer;

/**
 * Created by tuannt7 on 22/02/2024
 */

@Data
public class SlackMember {
    private String name;
    private Consumer<String> messageConsumer;

    public SlackMember(String name) {
        this.name = name;
    }

    public void receives(String message) {
        System.out.println(message);
    }

    public void says(String message) {
        messageConsumer.accept(message);
    }

    void setMessageConsumer(Consumer<String> messageConsumer) {
        this.messageConsumer = messageConsumer;
    }
}
