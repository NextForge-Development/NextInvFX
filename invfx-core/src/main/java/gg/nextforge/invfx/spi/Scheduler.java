package gg.nextforge.invfx.spi;

/** Tick-based scheduling abstraction (1 tick ~= 50ms on Bukkit). */
public interface Scheduler {
    Runnable runLater(Runnable task, long delayTicks);
    Runnable runRepeating(Runnable task, long initialDelayTicks, long periodTicks);
}
