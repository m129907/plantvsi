package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet2 {
	public Vector2 bullet2location = new Vector2(0,0);
	public Vector2 bullet2velocity = new Vector2(0,0);
	
	public Bullet2(Vector2 sentlocation, Vector2 sentvelocity) 
	{
		
		bullet2location = new Vector2(sentlocation.x,sentlocation.y);
		bullet2velocity = new Vector2(sentvelocity.x,sentvelocity.y);
	}
	public void Update()
	{
		bullet2location.x += bullet2velocity.x;
		bullet2location.y += bullet2velocity.y;
	}
}
