package com.github.makubas.better_ladders;

import com.github.makubas.better_ladders.block.IronLadderBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class BetterLadders implements ModInitializer {

	private static final IronLadderBlock IRON_LADDER = new IronLadderBlock();

	@Override
	public void onInitialize() {
		System.out.println("Better Ladders initialised!");

		Registry.register(Registry.BLOCK, new Identifier("betlad", "iron_ladder"), IRON_LADDER);
		Registry.register(Registry.ITEM, new Identifier("betlad", "iron_ladder"), new BlockItem(IRON_LADDER, new FabricItemSettings().group(ItemGroup.TRANSPORTATION)));

	}
}
