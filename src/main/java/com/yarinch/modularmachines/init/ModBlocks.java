package com.yarinch.modularmachines.init;

import com.yarinch.modularmachines.block.BlockMM;
import com.yarinch.modularmachines.block.BlockMachineBase;
import com.yarinch.modularmachines.block.BlockMachineCore;
import com.yarinch.modularmachines.tileentity.TileEntityMachineCore;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;

public class ModBlocks {

    public static final BlockMM machineBase = new BlockMachineBase();
    public static final BlockContainer machineCore = new BlockMachineCore();

    public static void init() {
        GameRegistry.registerBlock(machineBase, "machineBase");
        GameRegistry.registerBlock(machineCore, "machineCore");
    }

    public static void initTE() {
        GameRegistry.registerTileEntity(TileEntityMachineCore.class, "machineCoreTE");
    }
}
