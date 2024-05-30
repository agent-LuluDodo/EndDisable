package de.luludodo.enddisable.listeners;

import de.luludodo.enddisable.EndDisable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerPortalEventListener implements Listener {
    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {
        if (EndDisable.config().getBoolean("enabled")) return;

        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            event.setCancelled(true);
        }
    }
}
