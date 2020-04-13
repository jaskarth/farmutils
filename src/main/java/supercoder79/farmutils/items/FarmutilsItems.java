package supercoder79.farmutils.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import supercoder79.farmutils.blocks.FarmutilsBlocks;

public class FarmutilsItems {
    public static Item FERTILIZER_TIER1;
    public static Item APATITE_ORE;
    public static Item MAGNESITE_ORE;

    public static void init() {
        FERTILIZER_TIER1 = Registry.register(Registry.ITEM, new Identifier("farmutils", "fertilizer"), new FertilizerItem(new Item.Settings().group(ItemGroup.MISC)));
        APATITE_ORE = Registry.register(Registry.ITEM, new Identifier("farmutils", "apatite_ore"), new BlockItem(FarmutilsBlocks.APATITE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        MAGNESITE_ORE = Registry.register(Registry.ITEM, new Identifier("farmutils", "magnesite_ore"), new BlockItem(FarmutilsBlocks.MAGNESITE_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
