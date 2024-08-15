package fr.luna.blockcode;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SupressionBlock extends Block {
    public SupressionBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (level.getGameRules().getBoolean(GameRule.RULE_SUPRESSION))
            throw new RuntimeException("Supression block hited");
    }
}
