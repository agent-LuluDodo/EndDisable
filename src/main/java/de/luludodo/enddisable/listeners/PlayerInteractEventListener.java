package de.luludodo.enddisable.listeners;

import de.luludodo.enddisable.EndDisable;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractEventListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (EndDisable.config().getBoolean("enabled")) return;

        if (event.getClickedBlock() == null || event.getItem() == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK &&
                event.getClickedBlock().getType() == Material.END_PORTAL_FRAME &&
                event.getClickedBlock().getBlockData().getAsString().contains("eye=false") &&
                event.getItem().getType() == Material.ENDER_EYE
        ) {
            event.setCancelled(true);
            event.getPlayer().sendTitle("§cThe End is disabled!", null, 10, 70, 20);
            EndDisable.logger().info(event.getPlayer().getDisplayName() + " tried entering the end!");
        }
    }
}
