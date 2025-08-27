package gg.nextforge.invfx.extras.views;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.api.types.SlotRef;
import gg.nextforge.invfx.api.view.View;
import gg.nextforge.invfx.api.view.action.ClickContext;
import gg.nextforge.invfx.api.view.ctx.ViewContext;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PagedView implements View {
    private final List<ItemDescriptor> data;
    private int page = 0;

    @Override public int rows() { return 6; }
    @Override public int cols() { return 9; }

    @Override
    public void render(ViewContext ctx) {
        int start = page * 45; // 5 rows * 9 cols content
        for (int i = 0; i < 45 && start + i < data.size(); i++) {
            int r = i / 9;
            int c = i % 9;
            ItemDescriptor item = data.get(start + i);
            ctx.set(new SlotRef(r, c), item, this::onItemClick);
        }
        // nav bar
        ctx.set(new SlotRef(5, 3), label("Prev"), click -> { if (page > 0) page--; });
        ctx.set(new SlotRef(5, 5), label("Next"), click -> { if ((page + 1) * 45 < data.size()) page++; });
    }

    private void onItemClick(ClickContext ctx) {
        // no-op for prototype (extend as needed)
    }

    private ItemDescriptor label(String text) {
        // Minimal descriptor that just wraps a String as "platform item" for tests
        return () -> text;
    }
}
