package it.crafttechplugin.staffutilities.Utils;

import it.crafttechplugin.staffutilities.Main;
import org.bukkit.ChatColor;

public enum Message {

    PREFIX(Main.msg.getString("Messages.Prefix")),
    NO_PERMS(Main.msg.getString("Messages.noPerms")),
    JOIN_MESSAGE(Main.msg.getString("Messages.JoinMessage")),
    PL_HIDER(Main.msg.getString("Messages.PLHider")),
    FLY_OFF(Main.msg.getString("Messages.FlyOff")),
    FLY_ON(Main.msg.getString("Messages.FlyOn")),
    GMC_OFF(Main.msg.getString("Messages.GmcOff")),
    GMC_ON(Main.msg.getString("Messages.GmcOn")),
    VANISH_OFF(Main.msg.getString("Messages.VanishOff")),
    VANISH_ON(Main.msg.getString("Messages.VanishOn")),
    TP(Main.msg.getString("Messages.Tp")),
    TP_HERE(Main.msg.getString("Messages.TpHere")),
    TP_ALL(Main.msg.getString("Messages.TpAll")),
    NO_ARGS(Main.msg.getString("Messages.NoArgs")),
    RELOAD(Main.msg.getString("Messages.Reload")),
    OFFLINE_PLAYER(Main.msg.getString("Messages.OfflinePlayer")),
    RECEIVED_MSG(Main.msg.getString("Messages.received-msg")),
    SENTED_MSG(Main.msg.getString("Messages.sended-msg")),
    FREEZE_ON(Main.msg.getString("Messages.FreezeOn")),
    FREEZE_OFF(Main.msg.getString("Messages.FreezeOff")),
    REPORT_SUCCESS(Main.msg.getString("Messages.ReportSuccess")),
    REPORT_RECEIVED(Main.msg.getString("Messages.ReportReceived")),
    SCREENSHARE_BYPASS(Main.msg.getString("Messages.ScreenshareBypass")),
    STARTSCREENSHARE(Main.msg.getString("Messages.ScreenshareStart")),
    ENDSCREENSHARE(Main.msg.getString("Messages.ScreenshareEnd")),
    SCREENSHAREQUIT(Main.msg.getString("Messages.ScreenshareQuit")),
    NOTINSCREENSHARE(Main.msg.getString("Messages.NotInScreenshare")),
    EAT(Main.msg.getString("Messages.Eat")),
    HEAL(Main.msg.getString("Messages.Heal"));






    String msg;
    Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        if (this == PREFIX) {
            return ChatColor.translateAlternateColorCodes('&', PREFIX.msg);
        }
        return ChatColor.translateAlternateColorCodes('&', PREFIX.msg + msg);
    }

}
