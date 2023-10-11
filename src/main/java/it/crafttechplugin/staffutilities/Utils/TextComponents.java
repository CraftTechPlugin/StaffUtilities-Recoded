package it.crafttechplugin.staffutilities.Utils;

import it.crafttechplugin.staffutilities.Main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class TextComponents {

    public static String cheating(Player player){
        TextComponent cheating = new TextComponent(Color.getColor(Main.screenshareconfig.getString("Buttons.Cheating.Message")));
        cheating.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Main.screenshareconfig.getString("Buttons.Cheating.Command").replaceAll("%player%", player.getName())));
        return null;
    }

    public static String Admit(Player player){
        TextComponent admit = new TextComponent(Color.getColor(Main.screenshareconfig.getString("Buttons.Admit.Message")));
        admit.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Main.screenshareconfig.getString("Buttons.Admit.Command").replaceAll("%player%", player.getName())));
        return null;
    }

    public static String Refuse(Player player){
        TextComponent refuse = new TextComponent(Color.getColor(Main.screenshareconfig.getString("Buttons.Refuse.Message")));
        refuse.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Main.screenshareconfig.getString("Buttons.Refuse.Command").replaceAll("%player%", player.getName())));
        return null;
    }
    public static String Quit(Player player){
        TextComponent quit = new TextComponent(Color.getColor(Main.screenshareconfig.getString("Buttons.Quit.Message")));
        quit.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Main.screenshareconfig.getString("Buttons.Quit.Command").replaceAll("%player%", player.getName())));
        return null;
    }

    public static String Clean(Player player){
        TextComponent clean = new TextComponent(Color.getColor(Main.screenshareconfig.getString("Buttons.Clean.Message")));
        clean.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Main.screenshareconfig.getString("Buttons.Clean.Command").replaceAll("%player%", player.getName())));
        return null;
    }
}
