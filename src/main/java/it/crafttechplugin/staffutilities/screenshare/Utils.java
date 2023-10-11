package it.crafttechplugin.staffutilities.screenshare;

import it.crafttechplugin.staffutilities.Main;
import it.crafttechplugin.staffutilities.Utils.Message;
import it.crafttechplugin.staffutilities.Utils.TextComponents;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<Player, Player> hackcontrol = new HashMap<>();

    public static Map<Player, String> player_currentserver = new HashMap<>();

    public static Map<Player, Integer> hackcontrol_time = new HashMap<>();

    public static void newHackcontrol(Player staff, Player player) {
        hackcontrol.put(staff, player);
        Location screenshare = new Location((World) Main.screenshareconfig.get("ScreenShareLobby.World"), Main.screenshareconfig.getDouble("ScreenShareLobby.X"), Main.screenshareconfig.getDouble("ScreenShareLobby.Y"), Main.screenshareconfig.getDouble("ScreenShareLobby.Z"));
        staff.teleport(screenshare);
        player.teleport(screenshare);
        player_currentserver.put(player, player.getName());
        player_currentserver.put(staff, staff.getName());
        staff.sendMessage(Message.STARTSCREENSHARE.toString());
        staff.sendMessage(TextComponents.cheating(player) + " " + TextComponents.Admit(player) + " " + TextComponents.Refuse(player) + " " + TextComponents.Quit(player) + " " + TextComponents.Clean(player));
    }

    public static void terminateHackControl(Player staff) {
        Player player = getHackcontrol().get(staff);
        hackcontrol.remove(staff);
        Location hub = new Location((World) Main.screenshareconfig.get("HubWorld.World"), Main.screenshareconfig.getDouble("HubWorld.X"), Main.screenshareconfig.getDouble("HubWorld.Y"), Main.screenshareconfig.getDouble("HubWorld.Z"));
        player_currentserver.remove(staff);
        player_currentserver.remove(player);
        staff.teleport(hub);
        player.teleport(hub);
        staff.sendMessage(Message.ENDSCREENSHARE.toString());
    }

    public static Map<Player, Player> getHackcontrol() {
        return hackcontrol;
    }

    public static Map<Player, String> getReturnServer() {
        return player_currentserver;
    }

    public static void setHackcontrolTime(Player player, int time) {
        hackcontrol_time.put(player, Integer.valueOf(time));
    }

    public static void cleanHackcontrolTime(Player player) {
        hackcontrol_time.remove(player);
    }

    public static Map<Player, Integer> getHackcontrolTime() {
        return hackcontrol_time;
    }

    public static void quitOnControl(Player player, Player staff) {
        staff.sendMessage(Message.SCREENSHAREQUIT.toString());
        terminateHackControl(staff);
    }
}
