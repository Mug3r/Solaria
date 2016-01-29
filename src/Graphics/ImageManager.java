
package Graphics;

import java.awt.image.BufferedImage;


public class ImageManager {
    
    
    private int width = 64, height = 64;
    public BufferedImage grass, stone, empty;
    public BufferedImage[] player = new BufferedImage[4];
    public BufferedImage[] attack = new BufferedImage[4];
    public BufferedImage[][] playeranim = new BufferedImage[4][3];
    public BufferedImage[] tree = new BufferedImage[2];
    public BufferedImage[] rock = new BufferedImage[2];
    public BufferedImage[] chest = new BufferedImage[4];
    int i = 0;
    boolean up = true, dn = false;
    int delta = 0;
    
    public  ImageManager(spriteSheet ss){
    
        grass = ss.crop(0, 0, 16, 16);
        stone = ss.crop(0, 1, 16, 16);
        empty = ss.crop(0, 2, 16, 16);
        player[0] = ss.crop32(5, 0, 32, 32);
        player[1] = ss.crop32(5, 1, 32, 32);
        player[2] = ss.crop32(5, 2, 32, 32);
        player[3] = ss.crop32(5, 3, 32, 32);
        playeranim[0][0] = ss.crop32(6, 0, 32, 32);
        playeranim[0][1] = ss.crop32(5, 0, 32, 32);
        playeranim[0][2] = ss.crop32(7, 0, 32, 32);
        
        playeranim[1][0] = ss.crop32(6, 1, 32, 32);
        playeranim[1][1] = ss.crop32(5, 1, 32, 32);
        playeranim[1][2] = ss.crop32(7, 1, 32, 32);
        
        playeranim[2][0] = ss.crop32(6, 2, 32, 32);
        playeranim[2][1] = ss.crop32(5, 2, 32, 32);
        playeranim[2][2] = ss.crop32(7, 2, 32, 32);
        
        playeranim[3][0] = ss.crop32(6, 3, 32, 32);
        playeranim[3][1] = ss.crop32(5, 3, 32, 32);
        playeranim[3][2] = ss.crop32(7, 3, 32, 32);
        
        attack[0] = ss.crop32(3, 0, 32, 32);
        attack[1] = ss.crop32(3, 1, 32, 32);
        attack[2] = ss.crop32(3, 2, 32, 32);
        attack[3] = ss.crop32(3, 3, 32, 32);
        
        tree[0] = ss.crop(1, 0, 32, 64);
        tree[1] = ss.crop(1, 2, 64, 80);
    }
    
    public void update(){
       
    if(delta >= 10){
        
        if(up){
            if(i <= 1){
                player[0]=playeranim[0][i];
                player[1]=playeranim[1][i];
                player[2]=playeranim[2][i];
                player[3]=playeranim[3][i];
                i++; delta =0;} else {dn = true; up = false;}
        }
        
        if(dn){
            if(i >= 1){
                player[0]=playeranim[0][i];
                player[1]=playeranim[1][i];
                player[2]=playeranim[2][i];
                player[3]=playeranim[3][i];
                i--; delta = 0;} else{ dn = false; up = true;} 
        } 
        
        
    }else {delta++;}

}
}
    