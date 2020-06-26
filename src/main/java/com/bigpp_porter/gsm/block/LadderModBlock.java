package com.bigpp_porter.gsm.block;
import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.stream.Stream;

public class LadderModBlock extends LadderBlock {

    private boolean isEnabled() {
        return true;
        //return SweetConcreteConfig.enableLadders;
    }

    public LadderModBlock(Properties builder) {
        super(builder);
        //super(Block.Properties.create(Material.ROCK, dyeColor).hardnessAndResistance(0.4F).sound(SoundType.LADDER));
        //setRegistryName(dyeColor.getName() + "_concrete_ladder");
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (group == ItemGroup.SEARCH || isEnabled())
            super.fillItemGroup(group, items);
    }

    public static Stream<Block> allBlocks() {
        return Stream.of(
                /*
                ConcreteLadderBlocks.WHITE,
                ConcreteLadderBlocks.ORANGE,
                ConcreteLadderBlocks.MAGENTA,
                ConcreteLadderBlocks.LIGHT_BLUE,
                ConcreteLadderBlocks.YELLOW,
                ConcreteLadderBlocks.LIME,
                ConcreteLadderBlocks.PINK,
                ConcreteLadderBlocks.GRAY,
                ConcreteLadderBlocks.LIGHT_GRAY,
                ConcreteLadderBlocks.CYAN,
                ConcreteLadderBlocks.PURPLE,
                ConcreteLadderBlocks.BLUE,
                ConcreteLadderBlocks.BROWN,
                ConcreteLadderBlocks.GREEN,
                ConcreteLadderBlocks.RED,
                ConcreteLadderBlocks.BLACK

                 */
        );
    }
}