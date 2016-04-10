package blep.modtech.machine.farm.treefarm;

import blep.modtech.core.GuiBase;
import blep.modtech.reference.ModInfo;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Blue <boo122333@gmail.com>.
 */
@SideOnly(Side.CLIENT)
public class GuiTreeFarm extends GuiBase<TileEntityTreeFarm>
{
    public GuiTreeFarm(InventoryPlayer inventory, TileEntityTreeFarm tile)
    {
        super(inventory, tile, 225, 168, "TreeFarm", 3, 9, new ContainerTreeFarm(inventory, tile));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        int energystoredpercentage = (int) (52F * (1F - (float) (tile.getEnergyStored(EnumFacing.DOWN)) / (float) (tile.getMaxEnergyStored(EnumFacing.DOWN))));
        this.drawTexturedModalRect(guiLeft + 191, guiTop + 23 + energystoredpercentage, 225, 23 + energystoredpercentage, 16, 53 - energystoredpercentage);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        if (this.isPointInRegion(192, 24, 15, 50, mouseX, mouseY))
        {
            List<String> textLines = new ArrayList<>();
            textLines.add(tile.getEnergyStored(EnumFacing.DOWN) + "/" + tile.getMaxEnergyStored(EnumFacing.DOWN));
            this.drawHoveringText(textLines, mouseX - guiLeft, mouseY - guiTop);
        }
    }
}
