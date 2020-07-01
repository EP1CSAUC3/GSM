package com.bigpp_porter.gsm.init;

import com.bigpp_porter.gsm.GSM;
import com.bigpp_porter.gsm.item.PropertyWand;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;


public class ModItems {
    static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

    public static final PropertyWand glow_wand = new PropertyWand();


    public static void registerAll(RegistryEvent.Register<Item> event) {
        if (!event.getName().equals(ForgeRegistries.ITEMS.getRegistryName())) return;
        // Blocks
        BLOCKS_TO_REGISTER.forEach(ModItems::register);
        // Items
        register("glow_wand", glow_wand);
        // Nothing yet
    }
    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = GSM.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

}
