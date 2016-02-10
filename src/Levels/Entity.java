/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Graphics.ImageManager;
import static Main.Boot.scaleHeight;
import static Main.Boot.scaleWidth;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mug3r
 */
public class Entity {
    
    private BufferedImage skin;
    public int x, y, xs, ys;
    public boolean walkable = false, interactible = false, near = false;
    public boolean up = false, dn = false, lt = false, rt = false;
    private int speed = 2, menuID = 0;
    
    public Entity(int type, int xco, int yco, ImageManager im){
    
        switch(type){
            //void
            case 0:
                walkable = true;
                break;
            //Tree small
            case 1: 
                skin = im.tree[0];
                x = xco;
                y = yco;
                xs = 64;
                ys = 128;
                interactible = false;
                walkable = false;
                menuID = 0;
                break;
            //Tree Large
            case 2:
                skin = im.tree[1];
                x = xco;
                y = yco;
                xs = 128;
                ys = 160;
                interactible = false;
                walkable = false;
                menuID = 0;
                break;
            //Rock Small
            case 3:
                skin = im.rock[0];
                x = xco;
                y = yco;
                xs = 32;
                ys = 32;
                interactible = false;
                walkable = false;
                menuID = 0;
                break;
            //Rock Large
            case 4:
                skin = im.rock[1];
                x = xco;
                y = yco;
                xs = 64;
                ys = 64;
                interactible = false;
                walkable = false;
                menuID = 0;
                break;
            //Chest Small
            case 5:
                if(!near){
                    skin = im.chest[0];
                } else {skin = im.chest[2];}
                x = xco;
                y = yco;
                xs = 64;
                ys = 64;
                interactible = true;
                walkable = false;
                menuID = 1;
                break;
            //Chest Large
            case 6:
                if(!near){
                    skin = im.chest[1];
                } else {skin = im.chest[3];}
                x = xco;
                y = yco;
                xs = 128;
                ys = 64;
                interactible = true;
                walkable = false;
                menuID = 2;
                break;
        }
        
    }

    public int getX() {return x;}
    public int getY() {return y;}  
    
    public void Update(){
    
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
    
        g.drawImage(skin, x, y, xs*scaleWidth, ys*scaleHeight, null);
    
    }

    public void setUp(boolean up) {this.up = up;}
    public void setDn(boolean dn) {this.dn = dn;}
    public void setLt(boolean lt) {this.lt = lt;}
    public void setRt(boolean rt) {this.rt = rt;}
    
    
    
}
