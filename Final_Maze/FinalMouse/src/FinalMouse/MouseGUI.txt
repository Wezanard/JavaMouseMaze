package FinalMouse;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static FinalMouse.Mouse.memory;
public class MouseGUI extends JFrame
{
    static JPanel panel = new JPanel(new GridLayout(200, 200));
    static JButton[][] button = new JButton[25][25];
    static JLabel[][] label = new JLabel[25][25];
    public MouseGUI()
    {
        setSize(1000, 1000);
        setResizable(true);
        add(panel);
        Remember();
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    static void Remember()
    {
        for(int i = 0; i<memory.length; i++)
        {
            for(int j = 0; j<memory[i].length; j++)
            {
                button[i][j] = new JButton();
                label[i][j] = new JLabel();
                if (memory[i][j].equalsIgnoreCase("W"))
                {
                    button[i][j].setBackground(Color.black);
                    panel.add(button[i][j]);
                }
                else if (memory[i][j].equalsIgnoreCase("R"))
                {
                    button[i][j].setBackground(Color.red);
                    panel.add(button[i][j]);
                }
                else if (memory[i][j].equalsIgnoreCase("O"))
                {
                    button[i][j].setBackground(Color.white);
                    panel.add(button[i][j]);
                }
                else if (memory[i][j].equalsIgnoreCase("P"))
                {
                    button[i][j].setBackground(Color.green);
                    panel.add(button[i][j]);
                }
            }
        }
    }
    static void reRemember()
    {
        for(int i = 0; i<memory.length; i++)
        {
            for(int j = 0; j<memory[i].length; j++)
            {
                if (memory[i][j].equalsIgnoreCase("W"))
                {
                    button[i][j].setBackground(Color.black);
                    
                }
                else if (memory[i][j].equalsIgnoreCase("R"))
                {
                    button[i][j].setBackground(Color.red);
                    
                }
                else if (memory[i][j].equalsIgnoreCase("O"))
                {
                    button[i][j].setBackground(Color.white);
                    
                }
                else if (memory[i][j].equalsIgnoreCase("P"))
                {
                    button[i][j].setBackground(Color.green);
                    
                }
            }
        }
    }
    
}
