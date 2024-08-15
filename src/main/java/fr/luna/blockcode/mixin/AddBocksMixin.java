package fr.luna.blockcode.mixin;

import fr.luna.blockcode.*;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.ToIntFunction;

import static net.minecraft.world.level.block.Blocks.register;

@Debug(export = true)
@Mixin(Blocks.class)
public abstract class AddBocksMixin {
    @Shadow
    protected static ToIntFunction<BlockState> litBlockEmission(int i) {
        return null;
    }

    @Inject(at = @At("HEAD"), method = "<clinit>")
    private static void addBlock(CallbackInfo ci){
        BlockItemStorage.SupressionBlock = Blocks.register("blocksupression", new SupressionBlock(BlockBehaviour.Properties.of()));
        BlockItemStorage.SkipperBlock = Blocks.register("skipper", new SkipperBlock(BlockBehaviour.Properties.of()));
        BlockItemStorage.scalarBlock = Blocks.register("scalar", new scalarBlock(BlockBehaviour.Properties.of()));
        BlockItemStorage.maxUpdateBlock = Blocks.register("for", new maxUpdate(BlockBehaviour.Properties.of()));
        BlockItemStorage.passUpdateBlock = Blocks.register("pass", new passUpdate(BlockBehaviour.Properties.of()));
        BlockItemStorage.lightSupressionBlock = register("lightsup", new lightSupressionBlock(BlockBehaviour.Properties.of().lightLevel(litBlockEmission(15))));

    }
}
