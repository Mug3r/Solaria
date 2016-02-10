package Main;

import Utilities.MouseManager;
import Utilities.KeyManager;
import Entities.Player;
import Graphics.*;
import Levels.Camera;
import Levels.MapLoader;
import Utilities.CollisionDetector;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Game extends Canvas implements Runnable {
    
    private Thread thread;
    private MouseManager MM = new MouseManager();
    private KeyListener KM = new KeyManager();
    
    private boolean running;
    
    private BufferedImage image;
    private Graphics2D g;
    
    private ImageLoader il;
    private ImageManager im;
    private spriteSheet ss;
    private MapLoader ml;
    private String spriteSheetURL = "/SpriteSheet.png";
    private CollisionDetector cd;
    
    
    public static Player player;
    
    private String[] maps = new String[6];
    private String[] Emaps = new String[6];
    private Camera c;
    
    
    private double averageFPS;
    
    public static final int SCALE = 4;
    public static boolean animate = false;
    
    
    
    public static int width,height;
    
    private static int FPS = 60;
    private static int TPS = 100;
    
    public Game(int w, int h){
    
        super();
        setPreferredSize(new Dimension(w, h));
        setFocusable(true);
        requestFocus(); 
        
        width = w;
        height = h;
        
        il = new ImageLoader();        
        ss = new spriteSheet(il.loadImage(spriteSheetURL));
        im = new ImageManager(ss); 
        
        for(int i = 0; i < maps.length; i++){
        
            maps[i] = ("Res\\map " + (i+1) +".txt");
            Emaps[i] = ("Res\\Emap " + (i+1) +".txt");
            
        }
        
        ml = new MapLoader(maps, im, Emaps);
        player = new Player(445,300,im);
        c = new Camera(Player.x, Player.y);
        
        
    }
    
    public void addNotify(){
        super.addNotify();
        
        if(thread == null){
        thread = new Thread(this);
        thread.start();
        }
        addKeyListener(KM);
        addMouseListener(MM);
    }

    public void run() {
        
        running = true;
            
            image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            
            //Ticks and Frames per second counter
            int frames = 0;
            int ticks = 0;        
            long startTime = System.nanoTime();
            final double ns = 1000000000.0 / 60.0; 
            double delta = 0;
        
            long timer = System.currentTimeMillis();
            requestFocus();
        
            while(running){
           
           long now = System.nanoTime();
           delta += (now - startTime) / ns;
           startTime = now;
           while (delta >= 1){
               Update();
               ticks++;
               delta--;
           }
           
           Render();
           frames++;
           
           if(System.currentTimeMillis() - timer > 1000){
               timer += 1000;
               
                FPS = frames;
                TPS = ticks;
               
               ticks = 0;
               frames = 0;
           }
        }
        stop();
        
    }
    
    private void Render(){
         //Setup
            BufferStrategy bs = this.getBufferStrategy();
		if(bs ==  null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
         //Background
           
            g.setColor( new Color(3, 5, 50));
            g.fillRect(0, 0, width, height);

         //Draw Here
            MapLoader.Render(g);
            player.Render(g);
         //End Draw
            g.dispose();
            bs.show();
        }
    
     private void Update(){
        
        KeyManager.update();
        
        MapLoader.Update();
        player.update();
        if(animate){
        im.update();}
        c.update();
    
     }

    private synchronized void stop() {
        if(!running){return;}
        else{
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      }
        
    }
    
}
