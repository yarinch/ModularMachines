package com.yarinch.modularmachines.block;

import com.yarinch.modularmachines.tileentity.TileEntityMachineCore;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMachineCore extends BlockMachineBase implements ITileEntityProvider {

    public BlockMachineCore() {
        super();
        this.setBlockName("machineCore");
        this.setBlockTextureName("machineCore");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityMachineCore();
    }
}
