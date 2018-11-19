package FinalMouse;
import java.io.*;
import java.text.*;
import java.util.*;
public class MouseLogger 
{
    //Instance Variables
    static FileOutputStream fd;
    static PrintWriter pw;
    static String mouseFile = ".\\MouseLog.txt";
    static final boolean APPENDING = true;
    
    //Add Date Information
    static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    static Date date = new Date();
    static boolean error = false;
    MouseLogger()
    {
        try
        {
            File f = new File(mouseFile);
            if(!f.exists())
                f.createNewFile();            
        }
        catch (Exception e)
        {
            System.out.println("Permission?");
        }
    }
    static void Log(String s)
    {
        try
        {
            fd = new FileOutputStream(mouseFile, APPENDING);
            pw = new PrintWriter(fd);
            if (error == true)
            {
                pw.println(dateFormat.format(date) + " - Error: " + s + "\n");
                //pw.println(dateFormat.format(date));
            }
            else
            {
                pw.println(dateFormat.format(date) + " - "+ s + "\n");
                //pw.println(dateFormat.format(date));
            }
            
        }
        catch (Exception e)
        {
            System.out.println("File Not Found");
        }
        finally
        {
            pw.close();
        }
    }
    static void Debug(String s)
    {
        try
        {
            fd = new FileOutputStream(mouseFile, APPENDING);
            pw = new PrintWriter(fd);
            pw.println("Debug Event: " + s + "\n");
            pw.println(dateFormat.format(date));
            
        }
        catch (Exception e)
        {
            System.out.println("File Not Found");
        }
        finally
        {
            pw.close();
        }
    }
    public static void Error(IOException s)
    {
        error = true;
        Log(s.getMessage());
        error = false;
    }    
}    
