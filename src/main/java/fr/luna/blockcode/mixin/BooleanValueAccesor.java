package fr.luna.blockcode.mixin;

import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(targets = "net.minecraft.world.level.GameRules$BooleanValue")
public interface BooleanValueAccesor {
    @Invoker
    static GameRules.Type<GameRules.BooleanValue> callCreate(boolean bl) {
        return null;
    }
}
