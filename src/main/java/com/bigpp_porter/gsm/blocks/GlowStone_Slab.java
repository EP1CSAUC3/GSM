package com.bigpp_porter.gsm.blocks;

import net.minecraft.block.SlabBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class GlowStone_Slab extends SlabBlock {

    public GlowStone_Slab() {
        super(SlabBlock.Properties.create(Material.GLASS, MaterialColor.SAND)
                .hardnessAndResistance(0.3F)
                .sound(SoundType.GLASS)
                .lightValue(15)


        );
        setRegistryName("glowstone_slab");
    }
}
