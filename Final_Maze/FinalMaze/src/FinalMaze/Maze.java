package FinalMaze;
import java.net.*;
import java.io.*;
import static FinalMaze.MazeMethods.Maze;
import java.util.Scanner;
public class Maze 
{
    static String responseLine;
    static String input;
    static String Location;
    static String theNine;
    static String win;
    static int x;
    
    static int y;  
    static String [][] maze = {
        {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"},
        {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"},
        {"O","O","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","O","O"},
        {"O","O","R","P","W","P","P","P","P","W","P","P","P","W","P","P","P","P","W","P","P","P","P","P","W","W","W","W","W","W","P","P","P","P","P","P","P","P","P","P","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","O","O"},
        {"O","O","W","P","W","P","W","W","P","W","P","W","P","W","P","W","W","P","W","P","W","W","W","P","W","W","W","W","W","W","P","W","W","W","W","W","W","W","W","W","P","W","W","W","W","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","P","W","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","P","P","W","W","W","W","P","W","P","P","P","P","P","P","P","P","P","W","P","P","P","P","W","P","P","P","P","P","P","P","P","P","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","W","P","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","W","W","W","P","W","P","W","W","W","W","W","W","W","W","W","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","P","P","W","P","P","P","P","P","P","P","P","P","W","W","P","W","P","W","P","W","P","P","P","P","P","P","P","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","P","P","W","P","W","P","W","P","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","P","P","W","P","W","P","W","W","W","W","W","W","W","W","P","W","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","W","W","P","W","P","W","W","W","W","P","W","P","W","P","P","P","W","P","W","P","P","P","P","W","P","P","P","P","P","P","P","P","P","W","W","W","W","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","P","P","P","W","P","P","W","P","W","P","P","P","P","W","P","W","W","W","W","W","P","W","P","W","W","P","W","P","W","W","W","W","W","W","W","W","W","P","P","P","W","W","W","W","W","W","W","W","W","W","W","W","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","O","O"},
        {"O","O","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","P","P","P","P","P","W","P","W","P","P","W","P","W","P","P","P","P","P","P","P","P","P","W","P","W","P","W","P","P","P","P","P","W","P","P","P","P","P","W","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","P","P","W","P","P","P","W","W","P","P","P","W","P","W","P","W","W","W","W","W","W","P","W","W","W","W","P","W","W","W","W","W","W","W","W","W","P","W","P","W","P","W","W","W","W","W","P","W","P","W","W","W","P","P","P","W","P","W","P","P","P","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","W","W","W","W","P","W","W","W","P","W","P","P","P","P","P","P","W","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","P","W","P","P","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","W","W","W","W","P","W","W","W","P","W","W","W","W","W","W","P","W","P","W","P","W","W","P","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","P","P","P","P","P","W","W","W","P","W","W","W","W","W","W","P","W","P","W","P","W","W","P","W","P","P","P","P","P","P","W","P","P","W","P","W","P","P","P","W","P","W","P","W","P","P","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","W","P","W","W","P","W","O","O"},
        {"O","O","W","W","W","W","P","W","P","W","W","W","P","W","W","W","P","W","W","P","P","P","W","P","W","P","W","P","W","W","P","W","W","W","W","W","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","P","W","W","W","P","W","P","W","P","W","P","W","P","W","P","P","W","P","W","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","W","W","W","W","W","P","W","P","W","P","P","P","P","W","P","W","P","W","P","W","P","W","W","P","P","P","P","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","P","W","P","P","P","P","P","W","W","W","P","W","P","W","P","W","W","W","W","P","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","P","W","P","P","P","W","P","W","P","W","W","W","W","P","W","P","W","P","W","P","W","P","P","W","W","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","W","W","W","W","P","W","P","W","P","W","P","P","P","P","P","W","P","W","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","P","P","P","P","W","P","W","P","W","P","W","P","P","W","P","W","P","W","P","W","P","W","W","W","W","P","P","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","P","P","P","P","W","P","W","W","W","W","W","W","W","W","W","W","W","P","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","W","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","W","W","W","W","P","W","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","W","P","W","W","W","W","P","W","P","W","W","P","W","P","W","P","W","W","W","W","P","W","P","P","W","W","W","P","W","P","W","P","P","P","P","W","P","W","P","W","P","P","P","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","W","P","W","W","W","W","P","W","P","W","W","P","W","P","P","P","P","P","P","W","P","W","W","P","P","W","W","P","W","P","W","W","W","W","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","P","P","W","W","W","W","W","W","P","W","P","P","P","W","P","P","W","P","P","P","P","P","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","O","O"},
        {"O","O","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","W","P","P","P","P","P","P","W","P","W","P","W","P","P","W","P","P","W","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","W","P","W","P","W","W","P","W","P","W","P","W","W","P","P","W","P","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","P","P","W","W","W","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","W","W","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","P","W","W","W","P","P","W","P","P","W","P","P","P","W","P","W","P","W","P","W","P","W","P","P","P","W","W","W","W","W","W","P","W","W","P","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","W","P","W","P","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","P","W","W","W","W","P","W","W","P","P","W","W","P","W","P","W","P","W","P","W","P","W","W","W","P","P","P","P","P","P","P","P","P","W","P","W","P","P","P","W","P","W","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","W","P","P","W","W","W","W","W","W","P","W","W","W","W","W","W","P","W","P","W","P","W","P","P","P","P","W","P","W","P","P","W","P","W","P","W","P","W","P","P","P","P","P","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","W","W","P","P","P","P","P","P","P","P","W","P","P","P","P","P","P","W","P","W","P","W","P","W","W","W","W","P","W","W","P","P","W","W","P","W","P","W","P","W","W","W","P","W","P","W","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","P","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","P","W","P","P","P","P","P","P","W","W","W","P","P","P","P","W","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","W","W","W","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","P","W","P","W","W","W","W","W","W","P","P","P","W","P","W","W","W","W","P","W","P","W","P","W","P","W","P","W","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","W","W","W","W","W","W","P","W","P","W","W","W","W","W","W","W","W","W","P","W","P","W","P","W","P","W","W","P","P","P","W","W","W","P","W","P","P","P","P","P","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","W","P","P","P","W","P","W","P","W","P","P","P","P","P","P","P","W","P","W","P","W","P","W","P","W","W","P","W","P","P","W","P","P","W","P","W","W","W","W","W","W","P","W","P","W","P","W","P","W","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","P","W","P","W","W","W","P","W","P","W","W","P","W","W","P","P","W","P","W","P","W","P","P","P","P","P","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","W","P","W","P","P","P","P","P","W","P","W","W","P","W","W","W","P","P","W","W","P","W","P","W","W","W","W","W","W","P","P","P","W","P","W","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","W","P","W","P","W","P","W","P","W","P","W","W","W","P","W","P","W","W","W","W","W","W","W","P","W","W","P","W","W","W","W","P","P","W","P","W","P","P","P","P","P","P","W","W","W","W","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","P","W","W","W","P","W","P","W","P","P","P","P","P","W","P","P","P","P","P","P","P","W","P","W","W","P","W","P","P","P","W","P","P","P","W","W","W","W","W","W","W","P","P","P","P","W","P","W","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","P","P","P","P","P","W","P","W","W","W","W","W","W","W","W","W","P","W","W","W","P","W","P","W","W","P","W","P","W","P","W","P","W","W","W","W","W","P","P","P","W","P","W","W","W","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","W","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","W","P","W","W","P","W","P","P","P","P","P","P","P","P","P","P","P","W","P","P","P","W","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","W","W","P","W","P","P","P","W","P","P","W","P","P","W","P","W","P","W","W","P","W","P","P","P","P","P","W","P","P","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","W","P","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","P","W","P","W","P","W","P","W","P","W","W","W","W","W","P","W","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","W","W","P","W","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","P","P","P","P","P","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","P","W","P","W","P","W","P","W","W","W","W","W","W","P","W","W","W","P","W","W","W","W","W","W","W","W","P","W","W","W","W","P","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","W","P","P","P","P","W","P","P","P","W","P","P","P","W","W","W","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","W","P","W","P","W","P","P","P","P","P","P","W","P","W","W","W","P","P","P","P","P","P","P","P","W","P","W","W","P","P","P","W","W","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","W","P","W","W","W","W","P","W","P","W","P","W","P","W","W","W","P","W","W","W","W","W","W","W","W","W","W","W","W","P","W","W","P","W","P","W","W","P","W","W","W","P","W","P","W","P","W","P","W","W","W","W","W","W","P","W","P","W","W","P","W","P","W","P","P","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","W","W","W","P","W","P","W","P","W","P","W","W","W","P","W","W","W","W","P","P","P","P","P","P","P","P","P","W","W","P","W","P","W","W","P","W","W","W","P","W","P","W","P","W","P","W","P","P","P","P","W","P","W","P","W","W","P","W","P","W","P","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","P","P","P","W","P","W","P","W","P","W","P","W","W","W","P","P","P","P","W","P","W","W","W","W","W","W","W","W","W","W","P","W","P","W","W","P","W","P","P","P","W","P","W","P","W","P","W","W","W","W","P","W","P","W","W","W","W","W","W","P","W","P","W","P","W","W","P","W","W","P","W","P","W","O","O"},
        {"O","O","W","W","W","W","W","P","W","P","W","P","P","P","W","P","W","W","W","W","W","W","P","P","P","W","W","W","W","W","W","P","P","P","W","P","W","P","W","W","P","W","P","W","W","W","P","W","P","W","W","P","P","P","W","P","W","P","W","P","P","P","P","P","P","W","P","W","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","W","P","P","P","W","P","W","W","W","P","W","P","P","P","W","W","W","W","W","W","P","P","P","W","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","P","W","P","W","P","W","P","W","P","W","W","W","W","W","P","W","W","P","W","P","W","W","P","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","P","W","W","W","W","P","P","P","P","W","P","W","P","W","P","P","P","W","W","P","W","P","P","W","P","W","P","W","P","W","P","W","P","P","W","P","W","P","P","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","P","P","P","W","W","P","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","P","W","W","W","W","W","W","P","W","W","P","W","P","W","P","W","P","W","W","P","W","W","P","P","P","W","P","W","P","W","P","W","W","W","W","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","W","P","W","W","W","W","P","P","W","P","W","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","W","W","W","W","W","W","P","W","W","P","W","P","W","P","W","P","W","W","P","W","W","W","W","W","W","P","W","P","W","P","P","P","P","P","P","W","W","P","W","P","W","P","W","P","W","W","W","W","W","W","P","W","P","P","W","P","W","W","P","W","P","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","P","P","P","P","P","P","P","P","P","W","P","W","P","W","P","W","P","W","W","P","W","P","P","P","W","W","P","W","P","W","W","W","W","W","W","W","W","W","P","W","P","P","P","W","P","P","P","P","P","P","W","P","W","P","W","W","P","P","W","P","W","P","W","P","P","P","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","P","P","P","P","P","P","P","P","W","W","P","W","W","W","W","W","W","W","P","W","P","W","P","W","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","P","P","W","P","W","P","P","P","P","W","P","W","P","W","P","W","P","W","P","W","W","P","P","P","W","P","W","W","P","P","P","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","P","P","P","W","W","P","W","P","W","P","W","P","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","W","P","W","W","W","W","W","W","W","P","P","P","P","P","P","P","W","P","W","P","W","P","W","W","P","W","W","P","W","P","W","P","W","W","P","P","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","W","P","W","P","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","P","W","P","W","P","P","P","P","P","P","P","W","W","W","W","W","P","W","P","W","P","W","P","W","W","P","W","W","P","W","P","W","P","W","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","W","W","P","W","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","W","W","P","W","W","W","W","W","W","W","P","W","P","P","P","W","P","W","P","P","P","W","P","W","P","W","P","W","P","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","W","W","P","W","P","W","P","P","W","P","W","P","W","P","W","P","W","P","W","P","P","W","P","W","P","W","P","W","W","W","P","W","P","P","P","P","W","W","P","W","P","W","W","W","P","W","W","W","P","W","P","W","P","W","P","W","W","P","P","W","P","W","P","P","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","P","W","W","P","P","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","W","W","P","W","P","W","W","P","W","W","P","W","P","W","P","P","P","P","P","W","P","W","P","W","P","W","P","W","P","P","W","W","W","W","W","W","W","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","P","W","W","W","W","W","W","P","P","P","P","W","P","W","P","W","P","W","P","P","P","P","W","P","W","P","W","P","W","P","P","P","W","P","W","W","P","W","W","P","W","P","W","P","W","W","W","P","W","P","W","P","W","P","W","P","W","W","P","W","W","P","P","P","P","P","P","P","P","P","P","P","P","P","O"},
        {"O","O","W","P","W","P","P","P","P","P","P","W","W","W","W","W","W","P","W","P","W","P","W","W","W","W","P","W","P","W","P","W","P","W","P","W","W","W","P","W","W","P","W","W","P","P","P","W","P","W","P","P","P","W","P","P","P","W","P","W","P","W","P","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","P","W","W","W","W","W","W","W","P","P","P","W","P","W","P","P","P","W","P","P","P","P","W","P","W","P","P","P","W","P","W","W","W","P","W","W","P","W","W","W","W","W","W","P","W","W","W","W","W","W","W","W","W","P","W","P","W","W","P","W","W","P","W","W","W","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","P","P","P","W","P","P","P","W","P","W","P","W","P","W","P","W","W","W","W","W","W","P","W","P","W","W","W","W","W","P","P","P","P","P","W","W","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","P","W","W","P","W","W","P","W","P","P","P","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","P","P","W","W","P","W","P","W","P","P","P","W","P","W","P","P","P","W","P","P","W","P","W","P","P","P","W","W","W","W","W","W","W","W","P","W","P","W","W","W","W","W","W","P","W","W","W","W","W","P","W","P","W","P","P","P","P","W","W","P","W","W","W","W","W","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","W","P","W","W","W","P","P","P","W","P","W","W","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","P","P","P","P","P","W","W","W","P","W","P","P","P","P","P","P","W","P","W","P","P","P","W","P","W","W","W","W","W","W","W","W","W","P","W","P","P","P","P","P","W","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","W","W","W","P","W","P","P","P","P","P","W","P","W","P","W","P","W","P","W","P","P","W","P","W","P","W","W","W","W","W","W","P","W","W","W","P","W","P","W","W","W","W","P","W","P","W","P","W","P","W","P","W","P","P","P","P","P","P","P","W","P","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","W","W","W","P","P","P","P","W","W","W","W","W","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","P","P","P","P","P","P","W","P","W","W","W","P","W","P","W","P","P","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","P","W","P","W","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","P","W","P","W","W","P","P","P","P","P","W","P","W","P","W","P","W","P","W","P","W","W","P","W","P","W","W","W","W","W","W","P","W","P","W","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","W","P","W","P","W","W","W","W","W","W","W","P","W","P","W","O","O"},
        {"O","O","W","W","P","W","P","W","P","W","W","W","W","W","W","P","W","P","W","P","W","P","W","P","W","P","P","W","P","P","P","P","P","W","W","P","W","P","W","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","W","P","P","W","P","P","P","W","W","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","P","W","W","P","W","P","W","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","P","W","P","W","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","W","W","P","W","W","P","W","P","P","P","W","P","W","P","W","P","W","P","P","P","P","P","P","P","P","W","P","P","P","P","W","P","W","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","P","P","P","P","P","W","P","W","P","P","P","P","P","P","P","P","P","W","O","O"},
        {"O","O","W","P","W","P","P","W","P","P","W","P","W","W","W","P","W","P","W","P","P","P","W","P","W","W","W","W","W","W","P","W","W","W","W","W","W","P","W","W","W","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","W","P","W","W","W","W","W","W","W","P","W","P","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","W","W","P","W","P","W","W","P","P","P","W","P","W","P","W","W","W","W","W","P","W","P","P","P","P","W","P","W","W","W","W","W","W","P","P","P","P","P","W","P","W","P","W","W","P","W","P","W","P","W","P","W","P","P","P","P","P","P","P","P","P","P","P","W","P","P","P","P","P","P","P","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","W","P","W","W","W","W","W","W","P","W","P","P","P","P","P","W","P","W","P","W","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","P","W","P","W","W","P","W","P","W","P","W","P","W","W","W","W","W","W","W","W","W","W","W","W","P","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","W","W","W","W","P","P","P","P","P","P","P","P","P","W","W","P","W","W","P","P","P","W","W","W","W","P","W","P","P","P","P","P","P","P","P","P","P","P","P","P","P","W","P","W","W","P","W","P","W","P","W","P","W","W","W","W","P","W","P","P","P","P","P","P","P","W","W","W","W","W","W","W","W","P","W","O","O"},
        {"O","O","W","P","P","P","P","P","W","W","W","W","W","W","W","P","P","P","P","W","W","W","W","P","P","P","P","P","P","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","P","P","P","P","W","P","P","P","W","P","P","P","P","P","P","W","P","W","W","W","W","W","P","P","P","P","P","P","P","P","P","P","W","O","O"},
        {"O","O","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","W","O","O"},
        {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"},
        {"O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O"},
    };
    public static void main(String [] args)
    {
        MazeGUI gui = new MazeGUI();
        MazeMethods socket = new MazeMethods();
        do
        {
            win = MazeMethods.AroundMouse();
            MazeMethods.Out(win);
            if (!win.equalsIgnoreCase("ooooooooo"))
            {
                MazeMethods.ChangeMaze();
            }
            
        }
        while(!win.equalsIgnoreCase("ooooooooo")||!win.equalsIgnoreCase("wwwwwwwww"));
        //if(!theNine.equalsIgnoreCase("ooooooooo"))
        //{
        //    MazeMethods.Out(MazeMethods.AroundMouse());
        //   MazeMethods.ChangeMaze();
        //}
        MazeMethods.Close();
    }
}
