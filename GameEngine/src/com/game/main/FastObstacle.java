package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class FastObstacle extends GameObject{

	private Handler handler;
	
	public FastObstacle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler;
		
		velY = 9;
		velX = 2;
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x, (int) y, 16, 16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (y <= 0 || y> Game.HEIGHT - 32)
			velY *= -1;
		if (x <= 0 || x > Game.WIDTH - 16)
			velX *= -1;
		
		handler.addObject (new Trail (x, y, ID.Trail, Color.CYAN, 16, 16, 0.02f, handler));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}
