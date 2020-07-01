package com.bigpp_porter.gsm.init;

import com.bigpp_porter.gsm.GSM;
import com.bigpp_porter.gsm.block.DoorModBlock;
import com.bigpp_porter.gsm.block.LadderModBlock;
import com.bigpp_porter.gsm.block.StairsModBlock;
import com.bigpp_porter.gsm.block.VerticalSlabModBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;


import javax.annotation.Nullable;

public class ModBlocks {
    // Glowstone
    public static SlabBlock glowstone_slab;
    public static StairsBlock glowstone_stairs;
    public static WallBlock glowstone_wall;
    public static FenceBlock glowstone_fence;
    public static LadderBlock glowstone_ladder;
    public static VerticalSlabModBlock glowstone_vertical_slab;
    public static DoorBlock glowstone_door;
    // Emerald
    public static SlabBlock emerald_slab;
    public static StairsBlock emerald_stairs;
    public static WallBlock emerald_wall;
    public static FenceBlock emerald_fence;
    public static LadderBlock emerald_ladder;
    public static VerticalSlabModBlock emerald_vertical_slab;


    public static void registerAll(RegistryEvent.Register<Block> event) {
        // Verify registry event, if ! silent return
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;

        // Glowstone blocks
        glowstone_slab = register("glowstone_slab", new SlabBlock(Block.Properties.create(Material.GLASS, MaterialColor.SAND)
                .hardnessAndResistance(0.3F)
                .sound(SoundType.GLASS)
                .lightValue(15)
        ));
        glowstone_stairs = register("glowstone_stairs", new StairsModBlock(glowstone_slab.getDefaultState(), Block.Properties.from(glowstone_slab)));
        glowstone_wall = register("glowstone_wall", new WallBlock(Block.Properties.from(glowstone_slab)));
        glowstone_fence = register("glowstone_fence", new FenceBlock(Block.Properties.from(glowstone_slab)));
        glowstone_ladder = register("glowstone_ladder", new LadderModBlock(Block.Properties.from(glowstone_slab)));
        glowstone_vertical_slab = register("glowstone_vertical_slab", new VerticalSlabModBlock(Block.Properties.from(glowstone_slab)));
        glowstone_door = register("glowstone_door", new DoorModBlock(Block.Properties.from(glowstone_slab)));

        // Emerald Blocks
        emerald_slab = register("emerald_slab", new SlabBlock(Block.Properties.create(Material.IRON, MaterialColor.EMERALD)
                .hardnessAndResistance(5.0F, 6.0F)
                .sound(SoundType.METAL)
        ));
        emerald_stairs = register("emerald_stairs", new StairsModBlock(emerald_slab.getDefaultState(), Block.Properties.from(emerald_slab)));
        emerald_wall = register("emerald_wall", new WallBlock(Block.Properties.from(emerald_slab)));
        emerald_fence = register("emerald_fence", new FenceBlock(Block.Properties.from(emerald_slab)));
        emerald_ladder = register("emerald_ladder", new LadderModBlock(Block.Properties.from(emerald_slab)));
        emerald_vertical_slab = register("emerald_vertical_slab", new VerticalSlabModBlock(Block.Properties.from(emerald_slab)));
    }

    public static <T extends Block> T register(String name, T block) {
        BlockItem item = new BlockItem(block, new Item.Properties().group(GSM.gsmItemGroup));
        return register(name, block, item);
    }

    public static <T extends Block> T register(String name, T block, @Nullable BlockItem item) {
        ResourceLocation id = GSM.getId(name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null) {
            ModItems.BLOCKS_TO_REGISTER.put(name, item);
        }
        return block;
    }


    /*
    @ObjectHolder("gsm:glowstone_slab")
    public static GlowStone_Slab GLOWSTONE_SLAB;
    @ObjectHolder("gsm:emerald_slab")
    public static Emerald_Slab EMERALD_SLAB;
    //@ObjectHolder("gsm:emerald_stairs")
    //public static Emerald_Stairs EMERALD_STAIRS;

     */

}

