package gg.nextforge.invfx.binding.bukkit.events;

import gg.nextforge.invfx.api.types.ClickTypeEx;
import gg.nextforge.invfx.api.view.action.ClickContext;
import gg.nextforge.invfx.impl.core.Window;
import gg.nextforge.invfx.spi.InventoryAdapter;
import gg.nextforge.invfx.spi.ItemFactory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.plugin.Plugin;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class BukkitEventBridge implements Listener {

    private final Plugin plugin;
    private final InventoryAdapter adapter;
    private final ItemFactory itemFactory;

    private final Map<UUID, Window> windows = new ConcurrentHashMap<>();

    public BukkitEventBridge(Plugin plugin, InventoryAdapter adapter, ItemFactory itemFactory) {
        this.plugin = plugin;
        this.adapter = adapter;
        this.itemFactory = itemFactory;
    }

    public void register() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public Window open(Player player, gg.nextforge.invfx.api.view.View view) {
        Window w = new Window(player, view, adapter, itemFactory);
        windows.put(player.getUniqueId(), w);
        w.open();
        return w;
    }

    public void close(Player player) {
        windows.remove(player.getUniqueId());
        player.closeInventory();
    }

    private ClickTypeEx mapClick(InventoryClickEvent e) {
        return switch (e.getClick()) {
            case LEFT -> ClickTypeEx.LEFT;
            case RIGHT -> ClickTypeEx.RIGHT;
            case SHIFT_LEFT -> ClickTypeEx.SHIFT_LEFT;
            case SHIFT_RIGHT -> ClickTypeEx.SHIFT_RIGHT;
            case MIDDLE -> ClickTypeEx.MIDDLE;
            case DOUBLE_CLICK -> ClickTypeEx.DOUBLE;
            case DROP -> ClickTypeEx.DROP;
            case CONTROL_DROP -> ClickTypeEx.CONTROL_DROP;
            case NUMBER_KEY -> ClickTypeEx.NUMBER_KEY;
            default -> ClickTypeEx.UNKNOWN;
        };
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player p)) return;
        Window w = windows.get(p.getUniqueId());
        if (w == null) return;

        // Cancel interactions inside our GUI size range
        int size = w.getView().rows() * w.getView().cols();
        if (e.getRawSlot() < size && e.getView().getTopInventory().equals(e.getClickedInventory())) {
            e.setCancelled(true);
            var ctx = ClickContext.builder()
                    .actor(p)
                    .slot(new gg.nextforge.invfx.api.types.SlotRef(e.getRawSlot() / w.getView().cols(),
                            e.getRawSlot() % w.getView().cols()))
                    .type(mapClick(e))
                    .hotbarButton(e.getHotbarButton())
                    .build();
            w.handleClick(e.getRawSlot(), ctx);
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        if (!(e.getWhoClicked() instanceof Player p)) return;
        if (!windows.containsKey(p.getUniqueId())) return;
        // Block drags into our GUI
        int topSize = e.getView().getTopInventory().getSize();
        boolean affectsTop = e.getRawSlots().stream().anyMatch(s -> s < topSize);
        if (affectsTop) e.setCancelled(true);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (!(e.getPlayer() instanceof Player p)) return;
        // Only remove if it was our window (best effort)
        Window w = windows.get(p.getUniqueId());
        if (w == null) return;
        int size = w.getView().rows() * w.getView().cols();
        if (e.getView().getTopInventory().getSize() == size) {
            windows.remove(p.getUniqueId());
        }
    }
}
