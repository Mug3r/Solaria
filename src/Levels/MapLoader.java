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
    private static String[] files, Efiles;
    private static ImageManager im;
    private static EntityMap[] Emap;
    static CollisionDetector cd;
    private static boolean loaded = false;
    
    public MapLoader(String[] maps, ImageManager IM, String[] Emaps){
        
        im = IM;
        map = new Map[maps.length+1];
        files = maps;
        Emap = new EntityMap[Emaps.length+1];
        Efiles = Emaps;
        
        loadMap();
        
    }
    
    public static void loadMap(){
    
        map[currentMap] = new Map(files[currentMap], im);
        Emap[currentMap] = new EntityMap(Efiles[currentMap], im);
        cd = new CollisionDetector(Player.x, Player.y, Game.player, map[currentMap], Emap[currentMap]);
        currentMap++;
        loaded = true;
    }
    
    
    public static void Update(){
    
        if(loaded){
            map[currentMap - 1].Update();
            Emap[currentMap - 1].Update();
        }
        
    }
    
    public static void Render(Graphics g){
        
        if(loaded){
            map[currentMap - 1].Render(g);
            Emap[currentMap - 1].Render(g);
        }
        
    
    }
    
    
}
