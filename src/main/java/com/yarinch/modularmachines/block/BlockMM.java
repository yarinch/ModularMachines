package com.yarinch.modularmachines.block;

import com.yarinch.modularmachines.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMM extends Block {

    public BlockMM(Material material) {
        super(material);
        this.setHardness(2F);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    public BlockMM() {
        this(Material.rock);
        this.setStepSound(Block.soundTypeStone);
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
