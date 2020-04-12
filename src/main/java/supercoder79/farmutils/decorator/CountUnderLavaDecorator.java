package supercoder79.farmutils.decorator;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Finds positions under lava. This is most useful in the nether.
 *
 * @author SuperCoder79
 */
public class CountUnderLavaDecorator extends Decorator<CountDecoratorConfig> {
    public CountUnderLavaDecorator(Function<Dynamic<?>, ? extends CountDecoratorConfig> function) {
        super(function);
    }

    public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, Random random, CountDecoratorConfig countDecoratorConfig, BlockPos blockPos) {
        return IntStream.range(0, countDecoratorConfig.count).mapToObj((i) -> {
            int x = random.nextInt(16) + blockPos.getX();
            int z = random.nextInt(16) + blockPos.getZ();

            // iterate through the column
            // we start at 40 because we want to add ores to the main lava ocean in the nether
            for (int y = 40; y > 0; y--) {
                if (world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.LAVA) {
                    if (world.getBlockState(new BlockPos(x, y, z)).isOpaque()) {
                        return new BlockPos(x, y, z);
                    }
                }
            }

            //didn't find lava - this is basically a null return
            return new BlockPos(x, 0, z);
        });
    }
}
