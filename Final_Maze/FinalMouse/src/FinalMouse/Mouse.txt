package FinalMouse;
public class Mouse 
{
    static String[][] memory = new String [200][200];
    public static void main(String[] args) 
    {
        for(int x=0;x<memory.length;x++)
        {
            for(int y=0;y<memory[x].length;y++)
            {
                memory[x][y] = "O";            
            }
        }
        memory[100][100] = "R";
        MouseMethods socket = new MouseMethods();
        MouseMethods.SimpleMouse();
        MouseMethods.Close();
        
        
    }
    
}
