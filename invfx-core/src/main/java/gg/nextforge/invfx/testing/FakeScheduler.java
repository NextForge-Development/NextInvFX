package gg.nextforge.invfx.testing;

import gg.nextforge.invfx.spi.Scheduler;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.TestOnly;

@TestOnly
@ApiStatus.Internal
public class FakeScheduler implements Scheduler {
    @Override
    public Runnable runLater(Runnable task, long delayTicks) {
        task.run(); // immediate for tests
        return () -> {};
    }
    @Override
    public Runnable runRepeating(Runnable task, long initialDelayTicks, long periodTicks) {
        // not repeating in tests
        task.run();
        return () -> {};
    }
}
