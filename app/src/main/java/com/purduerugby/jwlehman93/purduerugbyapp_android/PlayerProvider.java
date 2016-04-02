package com.purduerugby.jwlehman93.purduerugbyapp_android;

import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwlehman on 4/2/16.
 */
public abstract class PlayerProvider {

    private static List<Player> players = new ArrayList<Player>() {{

        add(new Player("Phil", "Spagnolo", 1, 4, "Chicago, IL"));
        add(new Player("Tyler", "Schmidtt", 2, 2, "Chester, NJ"));
        add(new Player("Austin", "Bravard", 3, 2, "New Palestine, IN"));
        add(new Player("Joe", "Kruml", 4, 4, "Avon, IN"));
        add(new Player("Cody", "Foss", 6, 2, "Chicago, IL"));
        add(new Player("Cody", "Foss", 6, 2, "Chicago, IL"));
        add(new Player("Cody", "Foss", 6, 2, "Chicago, IL"));
    }};

    public static List<Player> getPlayers() {
        return players;
    }
}