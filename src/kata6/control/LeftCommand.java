package kata6.control;

import kata6.control.Command;
import kata6.model.Block;

public class LeftCommand implements Command {
    private final Block block;

    public LeftCommand(Block block) {
        this.block = block;
    }


    public void execute() {
        block.left();
    }
}