/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Entities.Player;

/**
 *
 * @author Mug3r
 */
public class Camera {
    
   public static int x, y;
    public static boolean up = false,dn = false,lt = false,rt = false;
    
    public Camera(int xc, int yc){
    
       x = xc;
       y = yc;
        
    }
    
    public void update(){
        
        if(Player.x < x){        
            Map.setLt(true);
            EntityMap.setLt(true);
            x = Player.x;
        } else {Map.setLt(false); EntityMap.setLt(false);}
        
        if(Player.x > x){        
            Map.setRt(true);
            EntityMap.setRt(true);
            x = Player.x;
        } else {Map.setRt(false); EntityMap.setRt(false);}
        
        if(Player.y < y){
            Map.setUp(true);
            EntityMap.setUp(true);
            y = Player.y;
        } else { Map.setUp(false); EntityMap.setUp(false);}
        
        if(Player.y > y){
            Map.setDn(true);
            EntityMap.setDn(true);
            y = Player.y;
        } else { Map.setDn(false); EntityMap.setDn(false);}
        
    }
    
}
