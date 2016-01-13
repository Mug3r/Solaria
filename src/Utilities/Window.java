package Utilities;

import Main.Game;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Window {
    
    public static int width, height;
    public static Game g;
    
    public Window(String Title, int w, int h){
    
        width = w;
        height = h;
        
        g = new Game(width, height);
        
        start();
    }
    
    public static void start(){
    
        JFrame window = new JFrame();
        window.setSize(new Dimension(width, height));
        window.add(g);
        window.setTitle("Solaria");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setAlwaysOnTop(true);
        window.setUndecorated(true);
        window.setVisible(true);
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
        cursorImg, new Point(0, 0), "blank cursor");
        window.getContentPane().setCursor(blankCursor);
        
    
    }
    
}
