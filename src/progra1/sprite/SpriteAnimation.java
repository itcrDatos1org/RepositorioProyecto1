package com.progra1.sprite;

import com.progra1.ESTDAT.lista;
import com.progra1.Timer.Timer;
//clase importada para la cracion de Interfaces Graficas
import java.awt.*;
//clase para la cracion de objetos de la clase awt
import java.awt.image.BufferedImage;

import java.util.ArrayList;



//animacion del juego
public class SpriteAnimation {


    //declaracion de variables
    private lista<BufferedImage> sprites = new lista<BufferedImage>();
    private byte currentSprite;

    private boolean loop = false;
    private boolean play = false;
    private boolean destroyAfterAnim = false;

    public Timer timer;
    private int animationSpeed;
    private double xPos, yPos;

//declaracion de metodos

    public SpriteAnimation(double xPos, double yPos, int animationSpeed){
        this.animationSpeed = animationSpeed;
        this.xPos = xPos;
        this.yPos = yPos;

        timer = new Timer();
    }

    public void draw(Graphics2D g){
        if (isSpriteAniDestroyed())
            return;

        g.drawImage(sprites.getHead().getData(),(int)getxPos(),(int) getyPos(),null);
    }

    public void update(double delta){
        if (isSpriteAniDestroyed())
            return;

        if (loop && !play)
            loopAnimation();
        if (play && !loop)
            playAnimation();
    }

    public void stopAnimation(){
        loop=false;
        play=false;
    }
    //envia al principio
    public void resetSprite(){
        loop=false;
        play=false;
        currentSprite=0;
    }

    private void loopAnimation()
    {
        if (timer.isTimerReady(animationSpeed) && currentSprite == sprites.capacidad() - 1)
        {
            currentSprite=0;
            timer.resetTimer();
        }
        else if(timer.timerEvent(animationSpeed) && currentSprite != sprites.capacidad()-1)
        {
            currentSprite++;
        }


    }

    private void playAnimation(){
        if (timer.isTimerReady(animationSpeed) && currentSprite != sprites.capacidad()-1 && !isDestroyAfterAnim()){
            play=false;
            currentSprite = 0;
        }else if (timer.isTimerReady(animationSpeed) && currentSprite == sprites.capacidad() - 1 && isDestroyAfterAnim()){
            sprites = null;
        }else  if (timer.timerEvent(animationSpeed) && currentSprite != sprites.capacidad()-1){
            currentSprite++;
        }

    }


    public boolean isSpriteAniDestroyed(){
        if (sprites==null)
            return true;


        return false;

    }

    public void addSprite (BufferedImage spriteMap, int xPos, int yPos, int width, int height){
        sprites.add(spriteMap.getSubimage(xPos, yPos, width, height));
    }

    public void PlayerAnimation(boolean play, boolean destroyafterAnim){
        this.play = play;
        this.destroyAfterAnim=destroyafterAnim;
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public void setDestroyafterAnim(boolean destroyafterAnim) {
        this.destroyAfterAnim = destroyafterAnim;
    }


    public boolean isDestroyAfterAnim() {
        return destroyAfterAnim;
    }

    public byte getCurrentSprite() {
        return currentSprite;
    }

    public void setCurrentSprite(byte currentSprite) {
        this.currentSprite = currentSprite;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
