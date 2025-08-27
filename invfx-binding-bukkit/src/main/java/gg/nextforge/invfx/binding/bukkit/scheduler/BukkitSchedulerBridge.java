package gg.nextforge.invfx.binding.bukkit.scheduler;

import gg.nextforge.invfx.spi.Scheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public final class BukkitSchedulerBridge implements Scheduler {
    private final Plugin plugin;

    public BukkitSchedulerBridge(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public Runnable runLater(Runnable task, long delayTicks) {
        var handle = Bukkit.getScheduler().runTaskLater(plugin, task, delayTicks);
        return handle::cancel;
    }

    @Override
    public Runnable runRepeating(Runnable task, long initialDelayTicks, long periodTicks) {
        var handle = Bukkit.getScheduler().runTaskTimer(plugin, task, initialDelayTicks, periodTicks);
        return handle::cancel;
    }
}
