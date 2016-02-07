package net.blep.modtech.blocks.block;

import net.blep.modtech.api.BlockProperties;
import net.blep.modtech.api.BlockTexture;
import net.blep.modtech.blocks.ModTileBlock;
import net.blep.modtech.core.proxy.Proxy;
import net.blep.modtech.core.util.EnumMachineProperties;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Kelan on 06/02/2016.
 */
public class BlockMachine extends ModTileBlock
{
    private final String[][] texturesIdle = new String[][]{
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"}
    };

    private final String[][] texturesActive = new String[][]{
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"},
            {"machine_bottom_generic", "machine_top_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic", "machine_side_generic"}
    };

    public BlockMachine()
    {
        super(BlockProperties.GENERIC_MACHINE, "machine");
        setCreativeTab(CreativeTabs.tabBlock);

        setTextureConfiguration(new BlockTexture(texturesIdle, null));
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List items)
    {
        for (int i = 0; i < EnumMachineProperties.values().length; i++)
        {
            items.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isNormalCube()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        try
        {
            return EnumMachineProperties.values()[meta].getTileClass().newInstance();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}