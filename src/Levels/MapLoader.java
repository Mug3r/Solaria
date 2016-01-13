/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Levels;

import Entities.Player;
import Graphics.ImageManager;
import Main.Game;
import Utilities.CollisionDetector;
import java.awt.Graphics;

/**
 *
 * @author Mug3r
 */
public class MapLoader {
    
    public static Map[] map;
    public static int currentMap = 0;
    private static String[] files;
    private static ImageManager im;
    static CollisionDetector cd;
    
    public MapLoader(String[] maps, ImageManager IM){
        
        im = IM;
        map = new Map[maps.length+1];
        files = maps;
        
        loadMap();
        
    }
    
    public static void loadMap(){
    
        map[currentMap] = new Map(files[currentMap], im);
        cd = new CollisionDetector(Player.x, Player.y, Game.player, map[currentMap]);
        currentMap++;
    }
    
    
    public static void Update(){
    
        map[currentMap].Update();
        
        
    }
    
    public static void Render(Graphics g){
    
        map[currentMap].Render(g);
        
        
    
    }
    
    
}
