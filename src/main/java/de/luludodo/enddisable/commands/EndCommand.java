package de.luludodo.enddisable.commands;

import de.luludodo.enddisable.EndDisable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;

public class EndCommand implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (args.length) {
            case 1 -> {
                if (args[0].equalsIgnoreCase("disable")) {
                    EndDisable.getInstance().getConfig().set("enabled", false);
                    sender.sendMessage("§2The End has been §3disabled§2!");
                } else if (args[0].equalsIgnoreCase("enable")) {
                    EndDisable.getInstance().getConfig().set("enabled", true);
                    sender.sendMessage("§2The End has been §3enabled§2!");
                } else {
                    sender.sendMessage("§4The argument \"" + args[0] + "\" is invalid must be \"enable\" or \"disable\"!");
                    break;
                }
                EndDisable.getInstance().saveConfig();
            }
            case 0 -> sender.sendMessage("§2The End is §3" + (EndDisable.getInstance().getConfig().getBoolean("enabled")? "enabled" : "disabled") + "§2!");
            default -> sender.sendMessage("§4You supplied too many arguments");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> tabComplete = new ArrayList<>();
        if (args.length == 1) {
            tabComplete.add("enable");
            tabComplete.add("disable");
        }
        return tabComplete;
    }
}
