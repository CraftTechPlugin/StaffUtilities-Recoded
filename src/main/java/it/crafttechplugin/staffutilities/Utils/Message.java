package it.crafttechplugin.staffutilities.Utils;

import it.crafttechplugin.staffutilities.Main;
import org.bukkit.ChatColor;

public enum Message {

    PREFIX(Main.msg.getString("Messages.Prefix")),
    NO_PERMS(Main.msg.getString("Messages.noPerms")),
    JOIN_MESSAGE(Main.msg.getString("Messages.JoinMessage")),
    PL_HIDER(Main.msg.getString("Messages.PLHider")),
    PL_HIDER_OFF(Main.msg.getString("Messages.PLHiderOff")),
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
    ITEM_FIXED(Main.msg.getString("Messages.ItemFixed")),
    INVENTORY_FIXED(Main.msg.getString("Messages.InventoryFixed")),
    STAFF_VANISH_ON(Main.msg.getString("Messages.StaffVanishon")),
    STAFF_VANISH_OFF(Main.msg.getString("Messages.StaffVanishoff")),
    SPY_LOGS_ON(Main.msg.getString("Messages.SpyLogson")),
    SPY_LOGS_OFF(Main.msg.getString("Messages.SpyLogsoff")),
    SPY_PREFIX(Main.msg.getString("Messages.SpyPrefix")),
    STAFF_MODE_ON(Main.msg.getString("Messages.StaffModeon")),
    STAFF_MODE_OFF(Main.msg.getString("Messages.StaffModeoff"));






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

    public String toConsoleString() {
        return toString();
    }

}
