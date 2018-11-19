package FinalMouse;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import static FinalMouse.Mouse.memory;
import java.util.Random;
public class MouseMethods        
{
    static Random rand = new Random();
    static Socket Mouse = null;
    static PrintWriter os = null;
    static DataInputStream is = null;
    public static String replace = "Z";
    public static int count = 0;
    MouseMethods()
    {
        try
        {
            Mouse = new Socket("127.0.0.1", 13000);
            os = new PrintWriter(Mouse.getOutputStream(),true);
            is = new DataInputStream(Mouse.getInputStream());
        }
        catch(IOException e)
        {
            MouseLogger.Error(e);
        }
    }
    static void Out(String output)
    {
        os.println(output);
        MouseLogger.Log("Mouse Sent: " + output);
    }
    static String In()
    {
       try
       {
           String responseLine = is.readLine();
           MouseLogger.Log("Mouse Received: " + responseLine);
           return responseLine;
       }
       catch (IOException e)
       {
           MouseLogger.Error(e);
       }
       return null;
    }
    static void OneDirection()
    {
        String Location;
        Location = In();
        if (Location.charAt(1)=='P')
        {
            do
            {
                String newLocation = Location.substring(0,1) + "R" + Location.substring(3,4) + "P" + Location.substring(5);
                Out(newLocation);
                Location = In();
            }
            while(!Location.equalsIgnoreCase("ooooooooo"));
        }
        else if(Location.charAt(3)=='P')
        {
            do
            {
                String newLocation = Location.substring(0,3) + "R" +  "P" + Location.substring(5);
                Out(newLocation);
                Location = In();
            }
            while(!Location.equalsIgnoreCase("ooooooooo"));
            
        }
        else if(Location.charAt(5)=='P')
        {
            do
            {
                String newLocation = Location.substring(0,4) + "P" + "R" + Location.substring(6);
                Out(newLocation);
                Location = In();
            }
            while(!Location.equalsIgnoreCase("ooooooooo"));
            
        }
        else if(Location.charAt(7)=='P')
        {
            do
            {
                String newLocation = Location.substring(0,4) + "P" + Location.substring(5,6) + "R" + Location.substring(8,9);
                Out(newLocation);
                Location = In();
            }
            while(!Location.equalsIgnoreCase("ooooooooo"));           
        }
    }
    static void Close()
    {
        try
        {
            os.close();
            is.close();
            Mouse.close();
        }
        catch (IOException e)
        {
           MouseLogger.Error(e);
        }
        
    }
    static void SimpleMouse()
    {
        String Location;
        do
        {
            Location = In();
            if (Location.equalsIgnoreCase("ooooooooo"))
            {
                break;
            }
            else if(Location.equalsIgnoreCase("wwwwwwwww"))
            {
                break;
            }
            Move(Location, "P");
        }
        while(!Location.equalsIgnoreCase("ooooooooo"));
    }
    static void MoveUp(String Location)
    {
        String newLocation = Location.substring(0,1) + "R" + Location.substring(2,4) + "P" + Location.substring(5,9);
        Out(newLocation);
    }
    static void MoveRight(String Location)
    {
        String newLocation = Location.substring(0,4) + "P" + "R" + Location.substring(6,9);
        Out(newLocation);
    }
    static void MoveDown(String Location)
    {
        String newLocation = Location.substring(0,4) + "P" + Location.substring(5,7) + "R" + Location.substring(8,9);
        Out(newLocation); 
    }
    static void MoveLeft(String Location)
    {
        String newLocation = Location.substring(0,3) + "R" +  "P" + Location.substring(5,9);
        Out(newLocation); 
    }
    static void SmartMouse()
    {
        
    }
    static int RememberMouseX()
    {
        for(int x=0;x<memory.length;x++)
        {
            for(int y=0;y<memory[x].length;y++)
            {
                if (memory[x][y].equalsIgnoreCase("R"))
                {
                    return x;
                }
            }
        }
        return -1;
    }
    static int RememberMouseY()
    {
        for(int x=0;x<memory.length;x++)
        {
            for(int y=0;y<memory[x].length;y++)
            {
                if (memory[x][y].equalsIgnoreCase("R"))
                {
                    return y;
                }
            }
        }
        return -1;
    }
    static void UpdateMem(String Input)
    {        
        int y = RememberMouseY();
        int x = RememberMouseX();
        if(Check(memory[x-1][y-1]))
        {
            memory[x-1][y-1] = Input.substring(0,1);
        }
        if(Check(memory[x-1][y]))
        {
            memory[x-1][y] = Input.substring(1,2);
        }
        if(Check(memory[x-1][y+1]))
        {
            memory[x-1][y+1] = Input.substring(2,3);
        }
        if(Check(memory[x][y-1]))
        {
            memory[x][y-1] = Input.substring(3,4);
        }
        if(Check(memory[x][y]))
        {
            memory[x][y] = Input.substring(4,5);
        }
        if(Check(memory[x][y+1]))
        {
            memory[x][y+1] = Input.substring(5,6);
        }
        if(Check(memory[x+1][y-1]))
        {
            memory[x+1][y-1] = Input.substring(6,7);
        }
        if(Check(memory[x+1][y]))
        {
            memory[x+1][y] = Input.substring(7,8);
        }
        if(Check(memory[x+1][y+1]))
        {
            memory[x+1][y+1] = Input.substring(8,9);
        }
    }
    static void Move(String Location, String Desire)
    {
        UpdateMem(Location);
        int y = RememberMouseY();
        int x = RememberMouseX();
        count++;
        int choice = random("P");
        switch(choice)
        {
            case 0:
            {
                MoveUp(Location);
                memory[x][y] = replace;
                memory[x-1][y] = "R";
                replace="Z";
                break;
            }
            case 2:
            {
                MoveLeft(Location);
                memory[x][y] = replace;
                memory[x][y-1] = "R";
                replace="Z";
                break;
            }
            case 3:
            {
                MoveRight(Location);
                memory[x][y] = replace;
                memory[x][y+1] = "R";
                replace="Z";
                break;
            }
            case 1:
            {
                MoveDown(Location);
                memory[x][y] = replace;
                memory[x+1][y] = "R";
                replace="Z";
                break;
            }
        }
    }
    static int random(String desire)
    {
        ArrayList<Integer> choice = new ArrayList<>();
        int y = RememberMouseY();
        int x = RememberMouseX();
        int randomCount=0;       
        if(memory[x-1][y].equalsIgnoreCase(desire))//UP
        {
            choice.add(0);
            randomCount++;
        }
        if(memory[x+1][y].equalsIgnoreCase(desire))//DOWN
        {
            choice.add(1);
            randomCount++;
        }
        if(memory[x][y-1].equalsIgnoreCase(desire))//LEFT
        {
            choice.add(2);
            randomCount++;
        }
        if(memory[x][y+1].equalsIgnoreCase(desire))//RIGHT
        {
            choice.add(3);
            randomCount++;
        }
        if(randomCount==0)
        {
            if(desire.equalsIgnoreCase("P"))
            {
                desire="Z";
                replace="Q";
                
            }
            else if(desire.equalsIgnoreCase("Z"))
            {
                desire="Q";
                replace="F";
            }
            return(random(desire));
        }
        int num = rand.nextInt(randomCount);
        return choice.get(num);
    }
    static boolean Check(String s)
    {
        if(s.equalsIgnoreCase("Z"))
        {
            return false;
        }
        else if(s.equalsIgnoreCase("Q"))
        {
            return false;
        }
        else if(s.equalsIgnoreCase("F"))
        {
            return false;
       }
        else
        {
            return true;
        }
    }
}
