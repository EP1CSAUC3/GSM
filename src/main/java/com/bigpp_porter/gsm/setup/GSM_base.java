package com.bigpp_porter.gsm.setup;

import com.bigpp_porter.gsm.blocks.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GSM_base extends ItemGroup {
    public GSM_base() {
        super("Glow Stone Mod");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Item.BLOCK_TO_ITEM.get(ModBlocks.GLOWSTONE_SLAB));
    }

}
