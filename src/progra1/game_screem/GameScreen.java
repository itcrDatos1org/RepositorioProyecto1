package com.progra1.game_screem;

import com.progra1.state.SuperStateMachine;

import java.awt.*;

public class GameScreen implements SuperStateMachine {

    private Player player;
    private BasicBlocks bb;

    public GameScreen(){
        player = new Player(300,500,50,70);
        bb = new BasicBlocks();
    }

    @Override
    public void update(double delta) {
        player.update(delta);
    }

    @Override
    public void draw(Graphics2D g) {
        player.draw(g);
        bb.draw(g);

    }

    @Override
    public void init(Canvas canvas) {
        canvas.addKeyListener(player);

    }
}
