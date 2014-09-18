package com.yarinch.modularmachines;

import com.yarinch.modularmachines.init.ModBlocks;
import com.yarinch.modularmachines.proxy.IProxy;
import com.yarinch.modularmachines.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ModularMachines {
    
    @Mod.Instance(Reference.MOD_ID)
    public static ModularMachines instance;

    @SidedProxy(clientSide = "com.yarinch.modularmachines.proxy.ClientProxy", serverSide = "com.yarinch.modularmachines.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
