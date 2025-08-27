package gg.nextforge.invfx.testing;

import gg.nextforge.invfx.api.item.ItemDescriptor;
import gg.nextforge.invfx.spi.ItemFactory;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.TestOnly;

@TestOnly
@ApiStatus.Internal
public class FakeItemFactory implements ItemFactory {
    @Override
    public Object toPlatformItem(ItemDescriptor descriptor) {
        return descriptor == null ? null : descriptor.getItemStack();
    }
}
