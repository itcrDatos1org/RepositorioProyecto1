package Karla;

import java.net.*;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.*;

public class nave {
	
	private String nave= "nave.gif";
	
	private int dx;
	
	private int x;
	private int y;
	
	private Image imagen;
	
	public nave(){
		x = 200;
		y = 300;
		ImageIcon ing= new ImageIcon(this.getClass().getResource(nave));
		imagen = ing.getImage();
	}
	
	public void mover(){
		x += dx;
			
	}
	
	public int tenerX(){
		return x;
		
	}
	public int tenerY(){
		return y;
		
	}
	public Image tenerImagen(){
		return imagen;
	}
	
	public void keyPressed(KeyEvent e){
		int key= e.getKeyCode();
		
		if(key== KeyEvent.VK_LEFT){
			dx= -1;
		}
		if(key== KeyEvent.VK_RIGHT){
			dx = 1;
		}
	}
	public void keyReleased(KeyEvent e){
		int key= e.getKeyCode();
		
		if(key== KeyEvent.VK_LEFT){
			dx = 0;
		}
		if(key== KeyEvent.VK_RIGHT){
			dx = 0;
		}
		
		
	}
}

