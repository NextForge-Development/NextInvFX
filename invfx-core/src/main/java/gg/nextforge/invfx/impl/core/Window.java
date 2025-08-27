package gg.nextforge.invfx.impl.core;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.View;
import gg.nextforge.invfx.api.view.action.ClickAction;
import gg.nextforge.invfx.api.view.ctx.ViewContext;
import gg.nextforge.invfx.spi.InventoryAdapter;
import gg.nextforge.invfx.spi.ItemFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor @Getter
public class Window implements ViewContext {

    private final Object actor;                 // platform player handle
    private final View view;
    private final InventoryAdapter inventoryAdapter;
    private final ItemFactory itemFactory;

    private final Map<Integer, ItemDescriptor> lastFrame = new HashMap<>();
    private final Map<Integer, ClickAction> actions = new HashMap<>();

    private Object inventory;

    public void open() {
        int size = view.rows() * view.cols();
        if (size <= 0 || (size % 9) != 0) {
            throw new IllegalArgumentException("Invalid inventory size: " + size);
        }
        inventory = inventoryAdapter.createInventory(size, "InvFX");
        render();
        inventoryAdapter.open(actor, inventory);
    }

    public void render() {
        actions.clear();
        // Delegate to view; view will call set(...)
        view.render(this);
    }

    /** Called by platform bridge (Bukkit listener) */
    public void handleClick(int rawSlot, gg.nextforge.invfx.api.view.action.ClickContext ctx) {
        ClickAction act = actions.get(rawSlot);
        if (act != null) act.onClick(ctx);
    }

    // ViewContext implementation
    @Override
    public void set(SlotRef slot, @NotNull ItemDescriptor item, ClickAction onClick) {
        int idx = slot.index(view.cols());
        ItemDescriptor prev = lastFrame.get(idx);

        // diffing: compare platform items by equals(), fallback by reference
        Object newPlat = item.getItemStack();
        Object oldPlat = prev == null ? null : prev.getItemStack();
        if (!Objects.equals(newPlat, oldPlat)) {
            inventoryAdapter.setItem(inventory, idx, newPlat);
            lastFrame.put(idx, item);
        }

        if (onClick != null) actions.put(idx, onClick); else actions.remove(idx);
    }

    @Override
    public ItemDescriptor get(SlotRef slot) {
        return lastFrame.get(slot.index(view.cols()));
    }
}
