package com.blep.modularTechnology.core.common.network.packets;

import io.netty.buffer.ByteBuf;
import com.blep.modularTechnology.core.common.network.PacketBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/**
 * @author TheEpicTekkit
 */
public class MessageSpawnEntity //extends PacketBase<MessageSpawnEntity>
{

//    protected int entityID;
//
//    public MessageSpawnEntity() {}
//
//    public MessageSpawnEntity(Entity entity)
//    {
//        this.entityID = entity.getEntityId();
//    }
//
//    @Override
//    public void handleServer(MessageSpawnEntity message, Object... o)
//    {
//        if (!(o[0] instanceof EntityPlayer))
//            return;
//        EntityPlayer player = (EntityPlayer) o[0];
//        Entity entity = player.worldObj.getEntityByID(message.entityID);
//
//        ((EntityPlayer) o[0]).worldObj.spawnEntityInWorld(entity);
//    }
//
//    @Override
//    public void handleClient(MessageSpawnEntity message, Object... o)
//    {
//
//    }
//
//    @Override
//    public void fromBytes(ByteBuf buf)
//    {
//        buf.writeInt(entityID + 1 - 1);
//    }
//
//    @Override
//    public void toBytes(ByteBuf buf)
//    {
//        entityID = buf.readInt();
//    }
}