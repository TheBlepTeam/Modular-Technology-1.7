package blep.modtech.block.farms;

import blep.modtech.block.BlockMod;
import blep.modtech.tileentity.TileEntityTreeFarm;
import blep.modtech.util.LogHelper;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Blue <boo122333@gmail.com>.
 */
public class BlockTreeFarm extends BlockMod implements ITileEntityProvider
{
    public BlockTreeFarm()
    {
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityTreeFarm();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
//        if (!worldIn.isRemote)
//        {
//            TileEntityTreeFarm tile = (TileEntityTreeFarm) worldIn.getTileEntity(pos);
//
//            for (int i = 0; i < tile.getSlots(); i++)
//            {
//                if (tile.getStackInSlot(i) != null)
//                    LogHelper.info(tile.getStackInSlot(i).toString());
//            }
//        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        super.breakBlock(world, pos, state);
//        InventoryHelper.dropInventoryItems(world, new BlockPos(pos).add(0, 0.5, 0), (TileEntityTreeFarm) world.getTileEntity(pos));
        world.removeTileEntity(pos);
    }

    @Override
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity != null && tileentity.receiveClientEvent(eventID, eventParam);
    }
}