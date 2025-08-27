package gg.nextforge.invfx.extras.views;

import gg.nextforge.invfx.api.item.ItemProvider;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.View;
import gg.nextforge.invfx.api.view.ctx.ViewContext;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public final class ConfirmView implements View {
    private final Component title;
    private final ItemProvider items;
    private final Consumer<Boolean> onResult; // true=OK, false=Cancel

    private final MiniMessage mm = MiniMessage.miniMessage();

    public ConfirmView(Component title, ItemProvider items, Consumer<Boolean> onResult) {
        this.title = Objects.requireNonNull(title, "title");
        this.items = Objects.requireNonNull(items, "items");
        this.onResult = Objects.requireNonNull(onResult, "onResult");
    }

    @Override public int rows() { return 3; }
    @Override public int cols() { return 9; }

    @Override
    public void render(ViewContext ctx) {
        // Headline (center row 0)
        var head = items.simple("PAPER", title, List.of(), false);
        ctx.set(new SlotRef(0, 4), head, null);

        // OK / Cancel
        var ok = items.simple("LIME_WOOL", mm.deserialize("<green><bold>Ok"), List.of(), false);
        var no = items.simple("RED_WOOL",  mm.deserialize("<red><bold>Cancel"), List.of(), false);

        ctx.set(new SlotRef(1, 3), ok,  click -> onResult.accept(true));
        ctx.set(new SlotRef(1, 5), no,  click -> onResult.accept(false));
    }
}
