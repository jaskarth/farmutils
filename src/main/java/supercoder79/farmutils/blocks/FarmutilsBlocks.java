package supercoder79.farmutils.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.OreBlock;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FarmutilsBlocks {
    public static Block APATITE_ORE;
    public static Block MAGNESITE_ORE;

    public static void init() {
        //TODO: custom ore block
        APATITE_ORE = Registry.register(Registry.BLOCK, new Identifier("farmutils", "apatite_ore"), new OreBlock(Block.Settings.of(Material.STONE, MaterialColor.NETHER).strength(3.0F, 3.0F)));
        MAGNESITE_ORE = Registry.register(Registry.BLOCK, new Identifier("farmutils", "magnesite_ore"), new OreBlock(Block.Settings.of(Material.STONE, MaterialColor.STONE).strength(3.0F, 3.0F)));
    }
}