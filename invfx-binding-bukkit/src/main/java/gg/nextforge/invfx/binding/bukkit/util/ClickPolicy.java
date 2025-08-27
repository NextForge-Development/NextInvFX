package gg.nextforge.invfx.binding.bukkit.util;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;

public final class ClickPolicy {
    private ClickPolicy() {}

    public static boolean shouldCancel(ClickType type, InventoryAction action) {
        if (type == ClickType.DOUBLE_CLICK) return true;
        if (type == ClickType.SHIFT_LEFT || type == ClickType.SHIFT_RIGHT) return true;
        return switch (action) {
            case MOVE_TO_OTHER_INVENTORY,
                 HOTBAR_SWAP,
                 COLLECT_TO_CURSOR,
                 UNKNOWN -> true;
            default -> false;
        };
    }
}
