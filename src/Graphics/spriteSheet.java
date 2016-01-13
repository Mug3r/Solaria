package Graphics;


import java.awt.image.BufferedImage;

public class spriteSheet {

	private BufferedImage sheet;
	
	public spriteSheet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int col, int row, int w, int h){
		return sheet.getSubimage(row * 16, col * 16, w, h);
	}
        
        public BufferedImage crop32(int col, int row, int w, int h){
		return sheet.getSubimage(row * 32, col * 32, w, h);
	}
	
}


    

