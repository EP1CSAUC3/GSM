package com.bigpp_porter.gsm.item;

import com.bigpp_porter.gsm.GSM;
import com.bigpp_porter.gsm.block.LightModBlock;
import com.bigpp_porter.gsm.block.VerticalSlabModBlock;
import com.bigpp_porter.gsm.init.ModBlocks;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.BlockStateContainer;
import net.minecraftforge.common.extensions.IForgeBlockState;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

public class PropertyWand extends Item {

    public PropertyWand() {
        super(new Properties().group(GSM.gsmItemGroup).maxStackSize(1));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        if (!world.isRemote && playerentity != null) {
            BlockPos blockpos = context.getPos();
            this.handleClick(playerentity, world.getBlockState(blockpos), world, blockpos, true, context.getItem());
        }

        return ActionResultType.SUCCESS;
    }

    private void handleClick(PlayerEntity player, BlockState state, IWorld worldIn, BlockPos pos, boolean rightClick, ItemStack stack) {
        //store block properties n such and recreate??
        Block block = state.getBlock();
        if (worldIn.isRemote() == false) {
            newProperties(state, block, worldIn, pos, player);
            String name = String.valueOf(block.getTranslationKey());
            sendMessage(player, new TranslationTextComponent("block name: " + name));
        }
    }
    private static void newProperties(BlockState state, Block block, IWorld worldIn, BlockPos pos, PlayerEntity player){
        if (worldIn.isRemote() == false) {
            IntegerProperty LIGHT_LEVEL = BlockStateProperties.LEVEL_0_15;
            BlockState newState = state.with(LIGHT_LEVEL, 15);
            //worldIn.setBlockState(pos, newState, Constants.BlockFlags.DEFAULT);
            //BlockStateContainer fof = new BlockStateContainer(block, new IProperty[] {LIGHT_LEVEL},);


            sendMessage(player, new TranslationTextComponent("block name: " + state));
        }
    }
    private static void sendMessage(PlayerEntity player, ITextComponent text) {
        ((ServerPlayerEntity)player).sendMessage(text, ChatType.GAME_INFO);
    }
}
