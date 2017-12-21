package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
	public Vector2 bulletlocation = new Vector2(0,0);
	public Vector2 bulletvelocity = new Vector2(0,0);
	
	public Bullet(Vector2 sentlocation, Vector2 sentvelocity) 
	{
		
		bulletlocation = new Vector2(sentlocation.x,sentlocation.y);
		bulletvelocity = new Vector2(sentvelocity.x,sentvelocity.y);
	}
	public void Update()
	{
		bulletlocation.x += bulletvelocity.x;
		bulletlocation.y += bulletvelocity.y;
	}
}
