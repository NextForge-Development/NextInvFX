package gg.nextforge.invfx.binding.bukkit;

import gg.nextforge.invfx.api.item.ItemProvider;
import gg.nextforge.invfx.api.view.View;
import gg.nextforge.invfx.binding.bukkit.adapter.BukkitInventoryAdapter;
import gg.nextforge.invfx.binding.bukkit.item.BukkitItemFactory;
import gg.nextforge.invfx.binding.bukkit.events.BukkitEventBridge;
import gg.nextforge.invfx.binding.bukkit.item.BukkitItemProvider;
import gg.nextforge.invfx.binding.bukkit.scheduler.BukkitSchedulerBridge;
import gg.nextforge.invfx.spi.InventoryAdapter;
import gg.nextforge.invfx.spi.ItemFactory;
import gg.nextforge.invfx.spi.Scheduler;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public final class InvFxBukkit implements AutoCloseable {

    @Getter private final Plugin plugin;
    @Getter private final InventoryAdapter inventoryAdapter;
    @Getter private final ItemFactory itemFactory;
    @Getter private final Scheduler scheduler;
    @Getter private final ItemProvider itemProvider;
    @Getter private final BukkitEventBridge bridge;

    private InvFxBukkit(Plugin plugin,
                        InventoryAdapter inv,
                        ItemFactory factory,
                        Scheduler scheduler,
                        ItemProvider provider) {
        this.plugin = plugin;
        this.inventoryAdapter = inv;
        this.itemFactory = factory;
        this.scheduler = scheduler;
        this.itemProvider = provider;
        this.bridge = new BukkitEventBridge(plugin, inv, factory);
        this.bridge.register();
    }

    public static Builder builder(Plugin plugin) { return new Builder(plugin); }

    public void open(Player player, View view) { bridge.open(player, view); }
    public void close(Player player) { bridge.close(player); }

    @Override public void close() { bridge.dispose(); }

    // --------- Builder
    public static final class Builder {
        private final Plugin plugin;
        private InventoryAdapter inv;
        private ItemFactory factory;
        private Scheduler scheduler;
        private ItemProvider provider;

        private Builder(Plugin plugin) { this.plugin = plugin; }

        public Builder inventoryAdapter(InventoryAdapter a){ this.inv = a; return this; }
        public Builder itemFactory(ItemFactory f)         { this.factory = f; return this; }
        public Builder scheduler(Scheduler s)             { this.scheduler = s; return this; }
        public Builder itemProvider(ItemProvider p)       { this.provider = p; return this; }

        public InvFxBukkit build() {
            if (inv == null) inv = new BukkitInventoryAdapter();
            if (factory == null) factory = new BukkitItemFactory();
            if (scheduler == null) scheduler = new BukkitSchedulerBridge(plugin);
            if (provider == null) provider = new BukkitItemProvider();
            return new InvFxBukkit(plugin, inv, factory, scheduler, provider);
        }
    }
}
