package com.purduerugby.jwlehman93.purduerugbyapp_android.providers;

import com.purduerugby.jwlehman93.purduerugbyapp_android.model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jwlehman on 4/2/16.
 */
public abstract class RosterProvider {

    private static List<Player> players = new ArrayList<Player>() {{

        add(new Player("Phil", "Spagnolo", "Prop", "Senior", "Chicago, IL"));
        add(new Player("Tyler", "Schmidtt", "Hooker", "Sophomore", "Chester, NJ"));
        add(new Player("Austin", "Bravard", "Prop", "Sophomore", "New Palestine, IN"));
        add(new Player("Joe", "Kruml", "Lock", "Senior", "Avon, IN"));
        add(new Player("Cody", "Foss", "Flanker", "Sophomore", "Chicago, IL"));
    }};

    public static List<Player> getPlayers() {
        return players;
    }
}