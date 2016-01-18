package Levels;

import Entities.Player;
import Graphics.ImageManager;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//Window is 15 Tiles Wide and 10 Tiles High!!!
public class Map {
    
    

    
    private static int step = 0;
    private static int stepX = 0;
    private static int stepY = 0;
    private static int tileNumber = 0;
    public static boolean mapLoaded = false;
    private static boolean mapCleared = false;
    private ImageManager im;
   
    
    private static Tile[] tiles;
    
    private static boolean up = false, dn = false, lt = false, rt = false;
    
    public Map(String file, ImageManager i){
        
        int width = 0, height = 0;
        im = i;
        System.out.println(file);
        
        boolean widthchecked = false;
        
        try {
            Scanner f = new Scanner(new File(file));
            
            while (f.hasNext()){
                
                
                String line = f.nextLine();
                Scanner s = new Scanner(line).useDelimiter("#");
                
                while(s.hasNext()){
                    if(!widthchecked){
                    width++;
                    
                    s.next();} else{s.next();}
                    
                }
                widthchecked = true;
                height++;
                    
            }
            
            
                
                
                
            }
         catch (FileNotFoundException ex) {
            System.out.println("Map not found");
        }
        
        int size = width*height;
        System.out.println(size);
        System.out.println(file);
        loadMap(size, file);
        
        System.out.println("Map: Checked");
    }
    
    public void loadMap(int s, String path){
        
            tiles = new Tile[s];
 
        
            stepX = 0;
            stepY = 0;
            tileNumber = 0;
     
            
            File map = new File(path);
            try{
                Scanner mf = new Scanner(map);
                
                while (mf.hasNext()){
                
                    String line = mf.nextLine();
                    Scanner ms = new Scanner(line).useDelimiter("#");

                    while(ms.hasNext()){

                        int tileX = (stepX)*64;               
                        int tileY = (stepY)*64;
                    
                        int tileType = ms.nextInt();
                        
                        
                    
                        tiles[tileNumber] = new Tile(tileNumber,tileX, tileY, tileType, im);
                        stepX++;
                        tileNumber++;
                    }
                    stepY++;
                    stepX = 0;  
                }
                
                
        }
        catch(FileNotFoundException ex){}
            
        mapLoaded = true;
        System.out.println("Map: Loaded");
        
        
        
    }
    
    public static void Update(){
        

     if(mapLoaded){
        for(int i = 0; i < tiles.length; i++){
        
            tiles[i].Update();
            tiles[i].setDn(dn);
            tiles[i].setUp(up);
            tiles[i].setLt(lt);
            tiles[i].setRt(rt);
            
        }}
     
     MapLoader.cd.Update();
    }
    
    public static void Render(Graphics g){
    
        if(mapLoaded){
       for(int i = 0; i < tiles.length; i++){
        
            tiles[i].Render(g);
            
        }
        } 
    }
    
    public static void setMapCleared(boolean mapCleared) {
        Map.mapCleared = mapCleared;
    }
    

    public static void setUp(boolean up) {Map.up = up;}
    public static void setDn(boolean dn) {Map.dn = dn;}
    public static void setLt(boolean lt) {Map.lt = lt;}
    public static void setRt(boolean rt) {Map.rt = rt;}

    public static Tile getTile(int x, int y) {
        for(int i = 0; i < tiles.length; i++){
            if((tiles[i].getX()) + 64 >= x && (tiles[i].getX()) <= x && (tiles[i].getY()) + 64 >= y && (tiles[i].getY()) <= y ){
                return tiles[i];
            }
        }
        return null;
    }
    
    
    
}
