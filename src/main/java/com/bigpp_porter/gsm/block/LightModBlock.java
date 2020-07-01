package com.bigpp_porter.gsm.block;

import jdk.nashorn.internal.ir.Block;
import jdk.nashorn.internal.ir.Statement;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class LightModBlock extends Block {
    public LightModBlock(long token, int finish, Statement... statements) {
        super(token, finish, statements);
    }

}
