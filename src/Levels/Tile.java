
package Levels;

import Graphics.ImageManager;
import static Main.Game.SCALE;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

//Window is 15 Tiles Wide and 10 Tiles High!!!

public class Tile {

    private int x, y;
    public boolean up = false, dn = false, lt = false, rt = false, walkable = false;
    private int speed = 2, height = 0;
    private BufferedImage tile;
    
    public Tile(int tN, int xco, int yco, int type, ImageManager im) {
        
        x = xco;
        y = yco;
        
        switch (type){
            
            case 0:
               tile = im.grass;
               walkable = true;
               break;
            case 1:
               tile = im.stone;
               walkable = false;
               height = 0;
               break;
            case 2:
               tile = im.empty;
               walkable = false;
               break;
            case 3:
               
               break;
                
            case 4:
               
               break;
            case 5:   
               
               break;
        }
        
    }
    
      public void Update() {
        
       if(up){           
           y += 2*speed;         
       }else if(dn){       
           y -= 2*speed;           
       }
       
       if(lt){       
           x += 2*speed;
       }else if(rt){       
           x -= 2*speed;           
       }
        
    }
                
        
    
    
    public void Render(Graphics g){
    
        g.drawImage(tile, x, y, 64, 64,  null);
    
    }

    public void setUp(boolean u) {up = u;}
    public void setDn(boolean d) {dn = d;}
    public void setLt(boolean l) {lt = l;}
    public void setRt(boolean r) {rt = r;}
    public void setSpeed(int s) {speed = s;}
    public int getX() {return x;}
    public int getY() {return y;} 
 
}
