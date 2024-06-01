package de.luludodo.enddisable.listeners;

import de.luludodo.enddisable.EndDisable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerPortalEventListener implements Listener {
    private final Map<UUID, Long> lastMessage = new HashMap<>();

    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        if (EndDisable.getInstance().getConfig().getBoolean("enabled")) return;

        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            event.setCancelled(true);
            event.getPlayer().sendTitle("§cThe End is disabled!", null, 10, 70, 20);
            if ((System.currentTimeMillis() - lastMessage.getOrDefault(event.getPlayer().getUniqueId(), 0L)) > 60000) {
                lastMessage.put(event.getPlayer().getUniqueId(), System.currentTimeMillis());
                EndDisable.getInstance().getLogger().info(event.getPlayer().getDisplayName() + " tried entering the end!");
            }
        }
    }
}
