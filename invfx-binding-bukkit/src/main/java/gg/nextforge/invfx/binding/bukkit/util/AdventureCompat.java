package gg.nextforge.invfx.binding.bukkit.util;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class AdventureCompat implements AutoCloseable {
    private final Audience audiences;
    public AdventureCompat(Plugin plugin) { this.audiences = Audience.audience(plugin.getServer()); }
    public void sendActionBar(Player p, Component c) { audiences.filterAudience(a -> a instanceof Player player && player.getUniqueId().equals(p.getUniqueId())).sendActionBar(c); }
    public void sendMessage(Player p, Component c) { audiences.filterAudience(a -> a instanceof Player player && player.getUniqueId().equals(p.getUniqueId())).sendMessage(c); }
    @Override public void close() { /* no-op */ }
}
