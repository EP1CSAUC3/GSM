package com.bigpp_porter.gsm.blocks;

import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class Emerald_Slab extends SlabBlock{
    public Emerald_Slab() {
        super(SlabBlock.Properties.create(Material.IRON, MaterialColor.EMERALD)
                .hardnessAndResistance(5.0F, 6.0F)
                .sound(SoundType.METAL)
        );
        setRegistryName("emerald_slab");
    }
}
