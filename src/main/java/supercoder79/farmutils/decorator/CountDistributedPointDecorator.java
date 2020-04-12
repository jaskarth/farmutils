package supercoder79.farmutils.decorator;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
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
 * Randomly distributes points in a 16x16x16 cube.
 *
 * @author SuperCoder79
 */
public class CountDistributedPointDecorator extends Decorator<CountDecoratorConfig> {
    public CountDistributedPointDecorator(Function<Dynamic<?>, ? extends CountDecoratorConfig> function) {
        super(function);
    }

    public Stream<BlockPos> getPositions(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, Random random, CountDecoratorConfig countDecoratorConfig, BlockPos blockPos) {
        // All positions will be clustered around this point
        int baseValue = random.nextInt(64) + 12;

        return IntStream.range(0, countDecoratorConfig.count).mapToObj((i) -> {
            int x = random.nextInt(16) + blockPos.getX();
            int z = random.nextInt(16) + blockPos.getZ();
            //the y position can be 16 blocks away from the point, max
            int y = baseValue + (random.nextInt(16) - 8);

            return new BlockPos(x, y, z);
        });
    }
}
