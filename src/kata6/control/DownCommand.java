package kata6.control;

import kata6.control.Command;
import kata6.model.Block;

public class DownCommand implements Command {
    private final Block block;

    public DownCommand(Block block) {
        this.block = block;
    }

    public void execute() {
        block.down();
    }
}