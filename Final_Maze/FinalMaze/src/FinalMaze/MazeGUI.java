package FinalMaze;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static FinalMaze.Maze.maze;
public class MazeGUI extends JFrame
{
    static JPanel panel = new JPanel(new GridLayout(80, 80));
    static JButton[][] button = new JButton[80][80];
    static JLabel[][] label = new JLabel[80][80];
    public MazeGUI()
    {
        setSize(1000, 1000);
        setResizable(false);
        add(panel);
        Draw();
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    static void Draw()
    {
        for(int i = 0; i<maze.length; i++)
        {
            for(int j = 0; j<maze[i].length; j++)
            {
                button[i][j] = new JButton();
                label[i][j] = new JLabel();
                if (maze[i][j].equalsIgnoreCase("W"))
                {
                    button[i][j].setBackground(Color.black);
                    panel.add(button[i][j]);
                }
                else if (maze[i][j].equalsIgnoreCase("R"))
                {
                    button[i][j].setBackground(Color.red);
                    panel.add(button[i][j]);
                }
                else if (maze[i][j].equalsIgnoreCase("O"))
                {
                    button[i][j].setBackground(Color.white);
                    panel.add(button[i][j]);
                }
                else if (maze[i][j].equalsIgnoreCase("P"))
                {
                    button[i][j].setBackground(Color.green);
                    panel.add(button[i][j]);
                }
            }
        }
    }
    static void win(String text)
    {
        JOptionPane.showMessageDialog(panel, "You Won in: " + text + "Steps");
    }
    static void lose()
    {
        JOptionPane.showMessageDialog(panel, "You Lose");
    }
    static void reDraw()
    {
        for(int i = 0; i<maze.length; i++)
        {
            for(int j = 0; j<maze[i].length; j++)
            {
                if (maze[i][j].equalsIgnoreCase("W"))
                {
                    button[i][j].setBackground(Color.black);
                    
                }
                else if (maze[i][j].equalsIgnoreCase("R"))
                {
                    button[i][j].setBackground(Color.red);
                    
                }
                else if (maze[i][j].equalsIgnoreCase("O"))
                {
                    button[i][j].setBackground(Color.white);
                    
                }
                else if (maze[i][j].equalsIgnoreCase("P"))
                {
                    button[i][j].setBackground(Color.green);
                    
                }
            }
        }
    }
    
}
