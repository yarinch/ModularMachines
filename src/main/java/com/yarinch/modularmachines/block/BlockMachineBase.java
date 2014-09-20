package com.yarinch.modularmachines.block;

import com.yarinch.modularmachines.tileentity.TileEntityMachineCore;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockMachineBase extends BlockMM {

    public BlockMachineBase() {
        super();
        this.setBlockName("machineBase");
        this.setBlockTextureName("machineBase");
    }

    protected TileEntityMachineCore searchCore(World world, int x, int y, int z) {
        for (int x0 = -1; x0 <= 1; x0++) {
            for (int y0 = -1; y0 <= 1; y0++) {
                for (int z0 = -1; z0 <= 1; z0++) {
                    if (world.getBlock(x + x0, y + y0, z + z0) instanceof BlockMachineCore) {
                        TileEntityMachineCore te = (TileEntityMachineCore)world.getTileEntity(x + x0, y + y0, z + z0);
                        te.multiblockCheck();
                        return te;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        TileEntityMachineCore te = searchCore(world, x, y, z);
        if (te != null && te.isFormed()) {
            if (world.isRemote) {
                player.addChatMessage(new ChatComponentText("Opening GUI..."));
            }
            return true;
        }
        return false;
    }
}