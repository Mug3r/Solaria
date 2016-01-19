/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Graphics.ImageManager;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mug3r
 */
public class EntityMap {
    
    private ImageManager im;
    private int NoE = 0;
    private static Entity[] e;
    private boolean loaded = false;
    private static boolean up = false, dn = false, lt = false, rt = false;
    
    public EntityMap(String file, ImageManager im){   
       
        this.im = im;
        
        
        try {
            Scanner f = new Scanner(new File(file));
            
            while (f.hasNext()){               
                
                String line = f.nextLine();
                NoE++;
                
            }         

            }
         catch (FileNotFoundException ex) {
            System.out.println("Entity Map not found");
        }
        
        loadEntityMap(NoE + 1, file);
        
        
    }
    
    public void loadEntityMap(int Entities, String path){
        
        try {
            e = new Entity[Entities];
            
            Scanner m = new Scanner(new File(path));
            int i = 1;
            while(m.hasNext()){
                
                String line = m.nextLine();
                
                Scanner l = new Scanner(line).useDelimiter("#");
                
                while(l.hasNext()){
                    
                    int id, x, y;
                    
                    id = Integer.parseInt(l.next());
                    System.out.println(id);
                    x = Integer.parseInt(l.next());
                    System.out.println(x);
                    y = Integer.parseInt(l.next());
                    System.out.println(y);
                    
                    e[i] = new Entity(id, x, y, im);
                    
                    i++;
                    
                }
                
            }
        } catch (FileNotFoundException ex) {           
            System.out.println("EntityMap not found");
        }
        e[0] = new Entity(0, 0, 0, im);
        loaded = true;
    
    }
    
    public static Entity getEntity(int x, int y) {
        for(int i = 0; i < e.length; i++){
            if((e[i].getX()) + e[i].xs >= x && (e[i].getX()) <= x && (e[i].getY()) + e[i].ys >= y && (e[i].getY()) <= y ){
                return e[i];
            }
        }
        return e[0];
    }
    
    public void Update(){
    
        if(loaded){
            for(int i = 0; i < NoE; i++){
        
                e[i].Update();
                e[i].setDn(dn);
                e[i].setUp(up);
                e[i].setLt(lt);
                e[i].setRt(rt);
            
            }
        
        }
    }
    
    public void Render(Graphics g){
    
        if(loaded){
            for(int i = 0; i < NoE; i++){
        
                e[i].Render(g);
            
            }
        
        }
    }

    public static void setUp(boolean up) {EntityMap.up = up;}
    public static void setDn(boolean dn) {EntityMap.dn = dn;}
    public static void setLt(boolean lt) {EntityMap.lt = lt;}
    public static void setRt(boolean rt) {EntityMap.rt = rt;}
    
    
    
}
