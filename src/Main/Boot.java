package Main;

import Utilities.Window;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Boot {

    private static Window frame;
    public static Dimension screenSize;
    public static int scaleWidth, scaleHeight;
    
     public static void main(String[]args){
         
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        scaleWidth = 1280/((int)screenSize.getWidth());
        scaleHeight = 1024/((int)screenSize.getHeight());
        frame = new Window("Solaria", width, height);
        
    }
    
    
}
