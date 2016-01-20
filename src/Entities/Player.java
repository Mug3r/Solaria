package Entities;

import Graphics.ImageManager;
import Levels.MapLoader;
import static Main.Boot.scaleHeight;
import static Main.Boot.scaleWidth;
import Utilities.CollisionDetector;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class Player {

   
    
    public BufferedImage player, attack;
    
    
    private ImageManager im;
    public static int dir = 1;
    public static int x = 0, y = 0, h = 0, ax = 0, ay = 0;
    
    private double health;
    private boolean running = false;
    private static boolean up = false, dn = false, lt = false, rt = false;    
    public static boolean collidedlt = false, collidedrt = false, collidedfw = false, collideddn = false, attacking = false;
    private int lastSwing = 180;
    
    public Player(int xco, int yco, ImageManager im){
    
        this.im = im;
        x = xco;
        y = yco;       
        
    }
    
    public void update(){
        
        
            //Forward
                if(up){
                if(!collidedfw){y -= 2;}
                }
            //Back
                else if(dn){
                if(!collideddn){y += 2;}
                }
        
                
       
            //Left
                if(lt){
                if(!collidedlt){x -= 2;}
                }
            //Right
                else if(rt){
                if(!collidedrt){x += 2;}
                }
                
                if(lastSwing >= 1){
                
                    lastSwing++;
                    System.out.println(lastSwing);
                    
                }
                
                
                            
        
    }
    
    
    public void Render(Graphics g){
       
        
        
        switch (dir){
            //Void
            case 0:
                
                break;
            //Forward
            case 1:
                player = im.player[0];
                attack = im.attack[0];
                ax = x + 5;
                ay = y - 16;
                break;
            //Back
            case 2:
                player = im.player[2];
                attack = im.attack[2];
                ax = x + 5;
                ay = y + 22;
                break;
            //Left
            case 3:
                player = im.player[3];
                attack = im.attack[3];
                ax = x - 16;
                ay = y + 5;
                break;
            //Right
            case 4:
                player = im.player[1];
                attack = im.attack[1];
                ax = x + 16;
                ay = y + 5;
                break;
                         
        }
        
        g.drawImage(player, x, y, 64*scaleWidth, 64*scaleHeight,  null);
        
        if(attacking){
            if(lastSwing <= 0){
                
            Attack();
            lastSwing = 180;
            
            }            
            
        }
    }
    
    public void Attack(){
    
        
        
    }
    
    
    
    public static void setDir(int d){dir = d;}
    public static int getDir(){return dir;}
    
    public static void setUp(boolean u) {up = u; setDir(1);}
    public static void setDn(boolean d) {dn = d; setDir(2);}
    public static void setLt(boolean l) {lt = l; setDir(3);}
    public static void setRt(boolean r) {rt = r; setDir(4);}
    public static void setAt(boolean a) {attacking = a;}
  

    public static boolean isUp() {return up;}
    public static boolean isDn() {return dn;}
    public static boolean isLt() {return lt;}
    public static boolean isRt() {return rt;}   

    public static int getX() {return x;}
    public static int getY() {return y;}
    
    public static void setX(int x) {Player.x = x;}
    public static void setY(int y) {Player.y = y;}  
    
    
    
}
