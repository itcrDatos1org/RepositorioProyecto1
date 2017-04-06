package com.dregronprogram.enemy_bullets;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.dregronprogram.game_screen.BasicBlocks;
import com.dregronprogram.game_screen.Player;

public abstract class EnemyWeaponType {

	public abstract void draw(Graphics2D g);
	public abstract void update(double delta, BasicBlocks blocks, Player player);
	
	public abstract boolean collision(Rectangle rect);
	public abstract boolean destory();
	
	protected abstract void wallCollide(BasicBlocks blocks);
	protected abstract void isOutofBounds();
	
	public abstract int getxPos();
	public abstract int getyPos();
}
