package com.progra1.game_screem;

import com.progra1.display.Display;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class Player implements KeyListener {

    private final double speed = 5.0d;

    private BufferedImage pSprite;

    private Rectangle rect;

    private double xPos, yPos;
    private int width, heigth;

    private boolean left = false, rigth = false;




    public Player(double xPos, double yPos, int width, int height){
        this.xPos=xPos;
        this.yPos=yPos;
        this.width=width;
        this.heigth=height;
//se hace el cambio de variable de double a int//
        rect = new Rectangle((int)xPos,(int)yPos,width,height);

        try{
            URL url = this.getClass().getResource("/com/progra1/images/Nave.png");
            pSprite = ImageIO.read(url);

        }catch (IOException e){};



    }

    public void draw(Graphics2D g){
        g.drawImage(pSprite, (int)xPos,(int)yPos,width,heigth,null);

    }


    public void update(double delta){
        if(rigth && !left && xPos < Display.WIDTH-width){
            xPos += speed * delta;
            rect.x= (int) xPos;
        }if (!rigth && left && xPos > 10){
            xPos -= speed * delta;
            rect.x=(int) xPos;

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            rigth = true;
        }else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            left=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT){
            rigth = false;
        }else if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT){
            left = false;
        }
    }
}
