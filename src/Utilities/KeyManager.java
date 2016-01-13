package Utilities;

import Entities.Player;
import Levels.Map;
import Levels.MapLoader;
import Main.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {


   private static int dir = 1;
    
    
    public void keyTyped(KeyEvent e) {
        
        
        
    }

   
    public void keyPressed(KeyEvent e) {
    
        switch(e.getKeyCode()){
        
            case KeyEvent.VK_W:
                dir = 1;
                Player.setUp(true);
                Game.animate = true;
                break;
            case KeyEvent.VK_S:
                dir = 2;
                Player.setDn(true);
                Game.animate = true;
                break;
            case KeyEvent.VK_A:
                dir = 3;
                Player.setLt(true);
                Game.animate = true;
                break;
            case KeyEvent.VK_D:
                dir = 4;
                Player.setRt(true);
                Game.animate = true;
                break;
            case KeyEvent.VK_SPACE:
                Player.setAt(true);
                Game.animate = true;
                break;
                
            
        }         
        
    }
        

   
    public void keyReleased(KeyEvent e) {
    
        switch(e.getKeyCode()){
        
            case KeyEvent.VK_W:
                Player.setUp(false);
                Game.animate = false;
                break;
            case KeyEvent.VK_S:
                Player.setDn(false);
                Game.animate = false;
                break;
            case KeyEvent.VK_A:
                Player.setLt(false);
                Game.animate = false;
                break;
            case KeyEvent.VK_D:
                Player.setRt(false);
                Game.animate = false;
                break;
            case KeyEvent.VK_SPACE:
                Player.setAt(false);
                Game.animate = false;
                break;
            
                
            
        }
        

    }
    
    public static void update(){
    
        Player.setDir(dir);
    
    }
}
