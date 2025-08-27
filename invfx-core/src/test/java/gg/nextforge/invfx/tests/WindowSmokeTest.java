package gg.nextforge.invfx.tests;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.impl.core.Window;
import gg.nextforge.invfx.testing.FakeInventoryAdapter;
import gg.nextforge.invfx.testing.FakeItemFactory;
import gg.nextforge.invfx.extras.views.PagedView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WindowSmokeTest {

    @Test
    void openAndRender() {
        List<ItemDescriptor> items = List.of(
                () -> "DIAMOND",
                () -> "EMERALD",
                () -> "GOLD"
        );

        var view = new PagedView(items);
        var adapter = new FakeInventoryAdapter();
        var factory = new FakeItemFactory();
        var window = new Window(new Object(), view, adapter, factory);

        // should not throw
        window.open();
        window.render();

        assertNotNull(window.getActor());
        assertEquals(6, view.rows());
        assertEquals(9, view.cols());
    }
}
