package fr.luna.blockcode;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SkipperBlock extends Block {
    public SkipperBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        level.neighborChanged(blockPos,this,blockPos);
    }
}
