package com.bigpp_porter.gsm.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

    @Override
    public void init() {

    }

    @Override
    public World getClientWorld() {
        //Client side code
        return Minecraft.getInstance().world;
    }
}
