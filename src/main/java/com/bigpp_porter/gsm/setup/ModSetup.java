package com.bigpp_porter.gsm.setup;

import com.bigpp_porter.gsm.blocks.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("GlowstoneMod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.GLOWSTONE_SLAB);
        }
    };

    public void init() {

    }
}
