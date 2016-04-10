package blep.modtech.machine.generator;

import blep.modtech.block.BlockMod;
import blep.modtech.util.IModTechTileBlock;
import blep.modtech.util.LogHelper;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Blue <boo122333@gmail.com>.
 */
public class BlockGenerator extends BlockMod implements IModTechTileBlock, ITileEntityProvider
{
    public BlockGenerator()
    {
        super(Material.iron);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            TileEntity genericTile = worldIn.getTileEntity(pos);
            if (genericTile instanceof TileEntityGeneratorBase)
            {
                TileEntityGeneratorBase generator = (TileEntityGeneratorBase) genericTile;
                LogHelper.info(generator.getEnergyStored(side));
            }
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }

    @Override
    public Class<? extends TileEntity> getTileEntityClass()
    {
        return TileEntityGeneratorBase.class;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityGeneratorBase();
    }
}
