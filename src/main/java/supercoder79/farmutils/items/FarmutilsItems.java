package supercoder79.farmutils.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FarmutilsItems {
    public static Item FERTILIZER_TIER1;

    public static void init() {
        FERTILIZER_TIER1 = Registry.register(Registry.ITEM, new Identifier("farmutils", "fertilizer"), new FertilizerItem(new Item.Settings().group(ItemGroup.MISC)));
    }
}
