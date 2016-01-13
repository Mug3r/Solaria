package Utilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressed");
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
System.out.println("Mouse In");    }

    @Override
    public void mouseExited(MouseEvent e) {
System.out.println("Mouse Out");
        }
    
}
