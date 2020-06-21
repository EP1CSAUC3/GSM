package com.bigpp_porter.gsm;

import com.bigpp_porter.gsm.blocks.Emerald_Slab;
import com.bigpp_porter.gsm.blocks.GlowStone_Slab;
import com.bigpp_porter.gsm.blocks.ModBlocks;
import com.bigpp_porter.gsm.setup.ClientProxy;
import com.bigpp_porter.gsm.setup.GSM_base;
import com.bigpp_porter.gsm.setup.IProxy;
import com.bigpp_porter.gsm.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("gsm")
public class GSM {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static final ItemGroup itemGroup = new GSM_base();
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public GSM() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new GlowStone_Slab());
            event.getRegistry().register(new Emerald_Slab());

            //ModBlocks.EMERALD_SLAB = new Item.Properties().group(itemGroup)).setRegistryName(ModBlocks.EMERALD_SLAB.getRegistryName();
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.GLOWSTONE_SLAB, new Item.Properties()).setRegistryName("glowstone_slab"));
            event.getRegistry().register(new BlockItem(ModBlocks.EMERALD_SLAB, new Item.Properties()).setRegistryName("emerald_slab"));

        }
    }
}
