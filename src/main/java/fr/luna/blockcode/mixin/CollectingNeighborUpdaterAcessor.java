package fr.luna.blockcode.mixin;


import net.minecraft.world.level.redstone.CollectingNeighborUpdater;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CollectingNeighborUpdater.class)
public interface CollectingNeighborUpdaterAcessor {
    @Accessor int getCount();
    @Accessor int getMaxChainedNeighborUpdates();
}
