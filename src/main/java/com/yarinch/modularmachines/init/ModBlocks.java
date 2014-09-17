package com.yarinch.modularmachines.init;

import com.yarinch.modularmachines.block.BlockMM;
import com.yarinch.modularmachines.block.BlockMachineBase;
import com.yarinch.modularmachines.block.BlockMachineCore;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static final BlockMM machineBase = new BlockMachineBase();
    public static final BlockMM machineCore = new BlockMachineCore();

    public static void init() {
        GameRegistry.registerBlock(machineBase, "machineBase");
        GameRegistry.registerBlock(machineCore, "machineCore");
    }
}
