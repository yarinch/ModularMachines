package com.yarinch.modularmachines.tileentity;

import com.yarinch.modularmachines.block.BlockMachineBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachineCore extends TileEntity {

    private boolean isFormed;
    private int timer = 0;

    @Override
    public void updateEntity() {
        if (++timer == 60) {
            timer = 0;
            multiblockCheck();
        }
    }

    public void multiblockCheck() {
        if (worldObj.isRemote) {
            check:
            {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            if (!isBlockMachine(xCoord + x, yCoord + y, zCoord + z)) {
                                isFormed = false;
                                break check;
                            }
                        }
                    }
                }
                isFormed = true;
            }
        }
    }

    private boolean isBlockMachine(int x, int y, int z) {
        return worldObj.getBlock(x, y, z) instanceof BlockMachineBase;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        multiblockCheck();
    }
}
