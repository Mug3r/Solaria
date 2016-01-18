/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Graphics.ImageManager;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mug3r
 */
public class Entity {
    
    private BufferedImage skin;
    public int x, y, xs, ys;
    public boolean walkable = false;
    public boolean up = false, dn = false, lt = false, rt = false;
    private int speed = 2;
    
    public Entity(int type, int xco, int yco, ImageManager im){
    
        switch(type){
        
            //Tree small
            case 1: 
                skin = im.tree[0];
                x = xco;
                y = yco;
                xs = 64;
                ys = 128;
                walkable = false;
                break;
            //Tree Large
            case 2:
                skin = im.tree[1];
                x = xco;
                y = yco;
                xs = 128;
                ys = 160;
                walkable = false;
                break;
            //Rock Small
            case 3:
                skin = im.rock[0];
                x = xco;
                y = yco;
                xs = 32;
                ys = 32;
                walkable = false;
                break;
            //Rock Large
            case 4:
                skin = im.rock[1];
                x = xco;
                y = yco;
                xs = 64;
                ys = 64;
                walkable = false;
                break;
            //Chest Small
            case 5:
                skin = im.chest[0];
                x = xco;
                y = yco;
                xs = 64;
                ys = 64;
                walkable = false;
                break;
            //Chest Large
            case 6:
                skin = im.chest[1];
                x = xco;
                y = yco;
                xs = 128;
                ys = 64;
                walkable = false;
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
    
        g.drawImage(skin, x, y, xs, ys, null);
    
    }

    public void setUp(boolean up) {this.up = up;}
    public void setDn(boolean dn) {this.dn = dn;}
    public void setLt(boolean lt) {this.lt = lt;}
    public void setRt(boolean rt) {this.rt = rt;}
    
    
    
}
