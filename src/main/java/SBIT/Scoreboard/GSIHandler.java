package SBIT.Scoreboard;

import SBIT.Utilities;
import me.modmuss50.jgsi.api.GameStateIntegration;
import me.modmuss50.jgsi.api.RoundTracker;
import java.io.IOException;

public class GSIHandler {
    public static GameStateIntegration integration;
    public static RoundTracker tracker;

    static {
        try {
            integration = GameStateIntegration.create().start();
            tracker = RoundTracker.create(integration);
        } catch (IOException e) {
            Utilities.showErrorBox(e.getMessage());
        }
    }
}
