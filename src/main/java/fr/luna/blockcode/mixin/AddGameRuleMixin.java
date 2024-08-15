package fr.luna.blockcode.mixin;

import fr.luna.blockcode.GameRule;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRules.class)
public abstract class AddGameRuleMixin {

    @Shadow
    private static <T extends GameRules.Value<T>> GameRules.Key<T> register(String string, GameRules.Category category, GameRules.Type<T> type) {
        return null;
    };

    @Inject(at = @At("TAIL"), method = "<clinit>")
    private static void addRule(CallbackInfo ci){
        GameRule.RULE_SUPRESSION = register("supressionBlock",GameRules.Category.UPDATES,BooleanValueAccesor.callCreate(false));
    }
}
