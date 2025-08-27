package gg.nextforge.invfx.testing;

import gg.nextforge.invfx.spi.InventoryAdapter;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.TestOnly;

@TestOnly
@ApiStatus.Internal
public class FakeInventoryAdapter implements InventoryAdapter {
    @Override
    public Object createInventory(int size, String title) {
        return new Object[size]; // simple slots array
    }
    @Override
    public void setItem(Object inventory, int rawSlot, Object platformItem) {
        ((Object[]) inventory)[rawSlot] = platformItem;
    }
    @Override
    public void open(Object playerHandle, Object inventory) {
        // no-op for tests
    }
}
