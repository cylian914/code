package fr.luna.blockcode.mixin;

import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.world.level.redstone.NeighborUpdater;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Level.class)
public interface LevelAcessor {
    @Accessor NeighborUpdater getNeighborUpdater();
}
