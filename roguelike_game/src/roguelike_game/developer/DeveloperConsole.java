/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roguelike_game.developer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @version 09/17/2016
 * @author Andy Walser
 */

@SuppressWarnings("serial")
public class DeveloperConsole extends JFrame {
	private static DeveloperConsole console;
    private JTextField output;
    private JTextArea input;
    private JScrollPane pane;
    private Color foreground = Color.green;
    private Color background = Color.black;
    private Font font = new Font("Ariel",Font.BOLD, 25);
    private DeveloperConsole() {
        super("Developer Comsole");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setUpWindow();
    }
    
    private void setUpWindow() {
        output = new JTextField(" ", 30);
        output.setFont(font);
        output.setForeground(foreground);
        output.setBackground(background);
        add(output, BorderLayout.SOUTH);
        
        input = new JTextArea();
        input.setFont(font);
        input.setForeground(foreground);
        input.setBackground(background);
        pane = new JScrollPane(input, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(pane, BorderLayout.CENTER);
    }
    
    public static DeveloperConsole getInstance() {
        if (console == null) {
            console = new DeveloperConsole();
            return console;
        } else {
            return console;
        }
    }
    
    
}
