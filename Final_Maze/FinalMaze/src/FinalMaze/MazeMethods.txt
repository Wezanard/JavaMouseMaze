package FinalMaze;
import java.net.*;
import java.io.*;
import static FinalMaze.Maze.maze;
public class MazeMethods 
{
    static ServerSocket Maze = null;
    static DataInputStream is;
    static PrintWriter os;
    static Socket clientSocket = null;
    static int count = 0;
    MazeMethods()
    {
        try
        {
            Maze = new ServerSocket(13000);
            clientSocket = Maze.accept();
            is = new DataInputStream(clientSocket.getInputStream());
            os = new PrintWriter(clientSocket.getOutputStream(),true);
        }
        catch (IOException e)
        {
            MazeLogger.Error(e);
        }
    }
    static void Out(String output)
    {
        os.println(output);
        MazeLogger.Log("Maze Sent: " + output);
    }
    static String In()
    {
        try
        {
            String input = is.readLine();
            MazeLogger.Log("Maze Recieved: " + input);
            return input;
        }
        catch (IOException e)
        {
            MazeLogger.Error(e);
        }
        return null;
    }
    static void Close()
    {
        try
        {
            os.close();
            is.close();
            clientSocket.close();
            Maze.close();
        }
        catch (IOException e)
        {
            MazeLogger.Error(e);
        }        
    }
    static int FindMouseX()
    {
        for(int x=0;x<maze.length;x++)
        {
            for(int y=0;y<maze[x].length;y++)
            {
                if (maze[x][y].equalsIgnoreCase("R"))
                {
                    return x;
                }
            }
        }
        return -1;
    }
    static int FindMouseY()
    {
        for(int x=0;x<maze.length;x++)
        {
            for(int y=0;y<maze[x].length;y++)
            {
                if (maze[x][y].equalsIgnoreCase("R"))
                {
                    return y;
                }
            }
        }
        return -1;
    }
    static String AroundMouse()
    {
        int y = FindMouseY();
        int x = FindMouseX();
        String theNine = maze[x-1][y-1]+maze[x-1][y]+maze[x-1][y+1]+maze[x][y-1]+maze[x][y]+maze[x][y+1]+maze[x+1][y-1]+maze[x+1][y]+maze[x+1][y+1];
        count++;
        if(count==3201)
        {
            theNine="wwwwwwwww";
            for(int i = 0; i<maze.length; i++)
            {
                for(int j = 0; j<maze[i].length; j++)
                {
                    maze[i][j]="W";
                }
            }
            MazeGUI.reDraw();
            MazeGUI.lose();
            return theNine;
                
        }
        else if(theNine.equalsIgnoreCase("wooprowoo"))
        {
            theNine = "ooooooooo";
            for(int i = 0; i<maze.length; i++)
            {
                for(int j = 0; j<maze[i].length; j++)
                {
                    maze[i][j]="O";
                }
            }
            MazeGUI.reDraw();
            MazeGUI.win("" + count);
            return theNine;
            
        }
        else
        {
            return theNine;
        }
    }
    static void ChangeMaze()
    {
        String MouseInput = In();
        int y = FindMouseY();
        int x = FindMouseX();
        maze[x-1][y-1] = MouseInput.substring(0,1);
        maze[x-1][y] = MouseInput.substring(1,2);
        maze[x-1][y+1] = MouseInput.substring(2,3);
        maze[x][y-1] = MouseInput.substring(3,4);
        maze[x][y] = MouseInput.substring(4,5);
        maze[x][y+1] = MouseInput.substring(5,6);
        maze[x+1][y-1] = MouseInput.substring(6,7);
        maze[x+1][y] = MouseInput.substring(7,8);
        maze[x+1][y+1] = MouseInput.substring(8,9);
        try
        {    
            Thread.sleep(20);
        }
        catch(InterruptedException e)
        {
            MazeLogger.Error(e);
        }
        MazeGUI.reDraw();
    }
}
