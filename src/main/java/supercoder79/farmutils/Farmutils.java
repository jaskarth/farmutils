package supercoder79.farmutils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import supercoder79.farmutils.blocks.FarmutilsBlocks;
import supercoder79.farmutils.decorator.CountDistributedPointDecorator;
import supercoder79.farmutils.decorator.CountUnderLavaDecorator;
import supercoder79.farmutils.items.FarmutilsItems;

public class Farmutils implements ModInitializer {
    public static Decorator<CountDecoratorConfig> COUNT_UNDER_LAVA;
    public static Decorator<CountDecoratorConfig> COUNT_DISTRIBUTED_POINT;

	@Override
	public void onInitialize() {
	    COUNT_UNDER_LAVA = Registry.register(Registry.DECORATOR, new Identifier("farmutils", "count_under_lava"), new CountUnderLavaDecorator(CountDecoratorConfig::deserialize));
		COUNT_DISTRIBUTED_POINT = Registry.register(Registry.DECORATOR, new Identifier("farmutils", "count_distributed_point"), new CountDistributedPointDecorator(CountDecoratorConfig::deserialize));

		FarmutilsBlocks.init();
		FarmutilsItems.init();

		//TODO: add normal veins to basalt delta when updating to 1.16
		Biomes.NETHER.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
				Feature.ORE.configure(
						new OreFeatureConfig(
								OreFeatureConfig.Target.NETHERRACK,
								FarmutilsBlocks.APATITE_ORE.getDefaultState(),
								10))
		.createDecoratedFeature(COUNT_UNDER_LAVA.configure(new CountDecoratorConfig(12))));

		for (Biome biome : Registry.BIOME) {
			biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									FarmutilsBlocks.MAGNESITE_ORE.getDefaultState(),
									7))
			.createDecoratedFeature(COUNT_DISTRIBUTED_POINT.configure(new CountDecoratorConfig(8))));
		}

		RegistryEntryAddedCallback.event(Registry.BIOME).register((index, id, biome) ->
				biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES,
						Feature.ORE.configure(
								new OreFeatureConfig(
										OreFeatureConfig.Target.NATURAL_STONE,
										FarmutilsBlocks.MAGNESITE_ORE.getDefaultState(),
										7))
								.createDecoratedFeature(COUNT_DISTRIBUTED_POINT.configure(new CountDecoratorConfig(8)))));
	}
}
