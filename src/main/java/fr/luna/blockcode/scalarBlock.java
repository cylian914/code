package fr.luna.blockcode;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class scalarBlock  extends Block {
    bigC c;
    public scalarBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (level.getGameRules().getBoolean(GameRule.RULE_SUPRESSION))
        {
            long mem = Runtime.getRuntime().freeMemory();
            blockcode.LOGGER.info(String.valueOf(mem));
            mem = 0;
            try
            {
                SignBlockEntity ble = (SignBlockEntity)level.getBlockEntity(blockPos.above());
                mem = Integer.parseInt(ble.getFrontText().getMessages(true)[0].getString());
            } catch (Exception ignored) {}
            blockcode.LOGGER.info(String.valueOf(mem));
            c = new bigC((int)(mem));
            mem = Runtime.getRuntime().freeMemory();
            blockcode.LOGGER.info(String.valueOf(mem));
        }
    }
}
class bigC {
    public long[] filler;

    bigC(int nb)
    {
        filler = new long[nb];
    }
}