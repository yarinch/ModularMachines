package com.yarinch.modularmachines.block;

import com.yarinch.modularmachines.tileentity.TileEntityMachineCore;
import net.minecraft.world.World;

public class BlockMachineBase extends BlockMM {

    public BlockMachineBase() {
        super();
        this.setBlockName("machineBase");
        this.setBlockTextureName("machineBase");
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
            if (world.isRemote) {
                    for (int x2 = -1; x2 <= 1; x2++) {
                        for (int y2 = -1; y2 <= 1; y2++) {
                            for (int z2 = -1; z2 <= 1; z2++) {
                                if (!(world.getBlock(x2 + x, y2 + y, z2 + z) instanceof BlockMachineCore)) {
                                    ((TileEntityMachineCore)world.getTileEntity(x2 + x, y2 + y, z2 + z)).multiblockCheck();
                                    return;
                                }
                            }
                        }
                    }
            }
    }
}