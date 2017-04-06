package com.progra1.game_screem;

import com.progra1.ESTDAT.lista;

import java.awt.*;
import java.util.ArrayList;

/**/

public class BasicBlocks {
    public lista<Rectangle> wall = new lista<Rectangle>();

    public BasicBlocks(){
        basicBlock(75,450);
        basicBlock(275,450);
        basicBlock(475,450);
        basicBlock(675,450);

    }

    public void draw(Graphics2D g){
        g.setColor(Color.CYAN);
        for (int i =0; i<wall.capacidad();i++){
            g.fill(wall.getI(i));

        }
    }

    public void basicBlock(int xPos, int yPos){
        int wallWidth = 3;
        int x = 0;
        int y = 0;

        for (int i=0; i<13; i ++){
            if ((14+(i*2)+wallWidth<22+wallWidth)){
                row(14+(i*2)+wallWidth,xPos-(i*3), yPos +(i*3));
                x=(i*3)+3;

            }else{
                row(22+wallWidth , xPos-x,yPos+(i*3));
                y=(i*3);

            }
        }
    }
    public void row(int rows, int xPos, int yPos){
        for (int i=0; i < rows; i++) {
            Rectangle brick = new Rectangle(xPos + (i * 3), yPos, 3, 3);
            wall.add(brick);
        }
    }
}
