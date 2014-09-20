package com.yarinch.modularmachines.tileentity;

import com.yarinch.modularmachines.block.BlockMachineBase;
import com.yarinch.modularmachines.block.BlockMachineCore;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachineCore extends TileEntity {

    private boolean isFormed;
    private int timer = 0;

    public void multiblockCheck() {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (!isBlockMachine(xCoord + x, yCoord + y, zCoord + z)) {
                        System.out.println(x + " " + y + " " + z);
                        isFormed = false;
                        return;
                    }
                }
            }
        }
        isFormed = true;
    }

    private boolean isBlockMachine(int x, int y, int z) {
        return worldObj.getBlock(x, y, z) instanceof BlockMachineBase || worldObj.getBlock(x, y, z) instanceof BlockMachineCore;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        compound.setBoolean("isFormed", isFormed);
        super.readFromNBT(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        isFormed = compound.getBoolean("isFormed");
        super.writeToNBT(compound);
    }

    @Override
    public void updateEntity() {
        if (++timer == 400) {
            multiblockCheck();
            timer = 0;
        }
    }

    public boolean isFormed() {
        return isFormed;
    }
}