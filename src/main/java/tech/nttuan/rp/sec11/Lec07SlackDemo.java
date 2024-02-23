package tech.nttuan.rp.sec11;

import tech.nttuan.rp.sec11.assignment.SlackMember;
import tech.nttuan.rp.sec11.assignment.SlackRoom;
import tech.nttuan.rp.util.Util;

/**
 * Created by tuannt7 on 23/02/2024
 */

public class Lec07SlackDemo {
    public static void main(String[] args) {
        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi everyone");
        Util.sleepSeconds(2);
        jake.says("Hello sam");
        sam.says("What's up?");
        Util.sleepSeconds(2);
        slackRoom.joinRoom(mike);
        mike.says("Hey guys... I'm new here");
    }
}
