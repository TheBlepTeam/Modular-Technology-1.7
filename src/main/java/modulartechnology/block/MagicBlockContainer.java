package modulartechnology.block;

import net.minecraft.tileentity.TileEntity;

/**
 * @author bluemonster122 <boo122333@gmail.com>
 */
public abstract class MagicBlockContainer<T extends TileEntity> //extends BlockContainer
{
//    protected MagicBlockContainer(Material m)
//    {
//        super(m);
//    }
//
//    @Override
//    public Block setBlockName(String bn)
//    {
//        if (shouldRegisterInNameSet())
//            MagicBlockHandler.registerMagicBlock(this, bn);
//        return super.setBlockName(bn);
//    }
//
//    protected boolean shouldRegisterInNameSet()
//    {
//        return true;
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void registerBlockIcons(IIconRegister ir)
//    {
//        blockIcon = IconHelper.forBlock(ir, this);
//    }
//
//    public boolean showInCreativeTab()
//    {
//        return true;
//    }
//
//    @Override
//    public abstract T createNewTileEntity(World world, int meta);
}