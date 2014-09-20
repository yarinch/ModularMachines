package com.yarinch.modularmachines.block;

import com.yarinch.modularmachines.reference.Reference;
import com.yarinch.modularmachines.tileentity.TileEntityMachineCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMachineCore extends BlockContainer {

    public BlockMachineCore() {
        super(Material.rock);
        this.setBlockName("machineCore");
        this.setBlockTextureName("machineCore");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
        return new TileEntityMachineCore();
    }

    @Override
    public String getUnlocalizedName() {
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
