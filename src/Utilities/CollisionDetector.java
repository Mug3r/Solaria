/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Entities.Player;
import Levels.EntityMap;
import Levels.Map;

/**
 *
 * @author Mug3r
 */
public class CollisionDetector {
    
    private int x, y;
    private Player p;
    private Map m;
    private EntityMap Em;
    private boolean collided = false;
    
    public CollisionDetector(int xcent, int ycent, Player pl, Map map, EntityMap Emap){
    
        x = xcent;
        y = ycent;
        p = pl;
        m = map;
        Em = Emap;
    
    }
    
    public void Update(){
    
        
                x = p.getX() + 32;
                y = p.getY() - 1;
                if(!(m.getTile(x, y).walkable) || !(Em.getEntity(x, y).walkable)){
                p.collidedfw = true;
                } else {p.collidedfw = false;}                
               
                x = p.getX() + 32;
                y = p.getY() + 65;
                if(!(m.getTile(x, y).walkable) || !(Em.getEntity(x, y).walkable)){
                p.collideddn = true;
                } else {p.collideddn = false;}
                               
                x = p.getX() -1;
                y = p.getY() + 32;
                if(!(m.getTile(x, y).walkable) || !(Em.getEntity(x, y).walkable)){
                p.collidedlt = true;
                } else {p.collidedlt = false;}
                
                x = p.getX() + 74;
                y = p.getY() + 32;
                if(!(m.getTile(x, y).walkable) || !(Em.getEntity(x, y).walkable)){
                p.collidedrt = true;
                } else {p.collidedrt = false;}
                
                x = p.getX() + 32;
                y = p.getY() - 1;
                if(Em.getEntity(x, y).interactible){
                    Em.getEntity(x,y).near = true; p.interactablefw = true;
                } else { p.interactablefw = false; }
                
                x = p.getX() + 32;
                y = p.getY() + 65;
                if(Em.getEntity(x, y).interactible){
                    Em.getEntity(x,y).near = true; p.interactablebk = true;
                } else { p.interactablebk = false; }
                
                x = p.getX() -1;
                y = p.getY() + 32;
                if(Em.getEntity(x, y).interactible){
                    Em.getEntity(x,y).near = true; p.interactablelt = true;
                } else { p.interactablelt = false; }
                
                x = p.getX() + 74;
                y = p.getY() + 32;
                if(Em.getEntity(x, y).interactible){
                    Em.getEntity(x,y).near = true; p.interactablert = true;
                } else { p.interactablert = false; }
    }
    
    
    
}
