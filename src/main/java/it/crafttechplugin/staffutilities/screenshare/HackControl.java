package it.crafttechplugin.staffutilities.screenshare;

import it.crafttechplugin.staffutilities.Main;
import org.bukkit.entity.Player;

public class HackControl extends Thread {
    int time = 0;

    Player player;

    short type;

    public HackControl(Player player, short type) {
        this.player = player;
        this.type = type;
    }

    public void run() {
        boolean exists = true;
        while (exists) {
            if (this.type == 0) {
                if (!Utils.getHackcontrol().containsKey(this.player))
                    exists = false;
            } else if (!Utils.getHackcontrol().containsValue(this.player)) {
                exists = false;
            }
            Utils.setHackcontrolTime(this.player, this.time);
            this.time++;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                Main.getInstance().getLogger().info("Error while in thread of " + this.player.getName());
            }
        }
    }
}
