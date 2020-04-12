package supercoder79.farmutils;

import net.fabricmc.api.ModInitializer;
import supercoder79.farmutils.items.FarmutilsItems;

public class Farmutils implements ModInitializer {
	@Override
	public void onInitialize() {
		FarmutilsItems.init();
	}
}
