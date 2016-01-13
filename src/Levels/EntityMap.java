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

/**
 *
 * @author Mug3r
 */
public class EntityMap {
    
    private ImageManager im;
    private int NoE = 0;
    private Entity[] e;
    
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
        
        loadEntityMap(NoE);
        
        
    }
    
    public void loadEntityMap(int Entities){
        
        e = new Entity[Entities];
    
    }
    
    public void Update(){
    
        for(int i = 0; i < NoE; i++){
        
            e[i].Update();
            
        }
        
    }
    
    public void Render(Graphics g){
    
        for(int i = 0; i < NoE; i++){
        
            e[i].Render(g);
            
        }
        
    }
    
}
