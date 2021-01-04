package kata6;

import kata6.control.UpCommand;
import kata6.control.RightCommand;
import kata6.control.LeftCommand;
import kata6.control.DownCommand;
import kata6.control.Command;
import kata6.model.Block;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {

    private Block block;
    private BlockPanel BlockDisplay;
    private Map<String, Command> commands;

    public static void main(String[] args) {
	    new Main().exectute();
    }

    public Main(){
        this.block = new Block();
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,722);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.commands = createCommands();
    }

    private JMenuBar toolbar() {
        JMenuBar result = new JMenuBar();
        result.setLayout(new FlowLayout(FlowLayout.CENTER));
        result.add(button("D"));
        result.add(button("L"));
        result.add(button("U"));
        result.add(button("R"));
        return result;
    }

    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(command).execute();
            }
        });
        return button;
    }

    private void exectute() {
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel panel = new BlockPanel();
        this.BlockDisplay = panel;
        panel.display(block);
        this.block.register(panel);
        return panel;
    }

    private Map<String, Command> createCommands() {
        Map<String , Command> commands = new HashMap<>();
        commands.put("U",new UpCommand(block));
        commands.put("D",new DownCommand(block));
        commands.put("L",new LeftCommand(block));
        commands.put("R",new RightCommand(block));
        return commands;
    }

}
