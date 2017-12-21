package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Enemy {
	public Vector2 enemylocation = new Vector2(0,0);
	public Vector2 enemyvelocity = new Vector2(0,0);
	
	public Enemy(Vector2 sentlocation, Vector2 sentvelocity) 
	{
		
		enemylocation = new Vector2(sentlocation.x,sentlocation.y);
		enemyvelocity = new Vector2(sentvelocity.x,sentvelocity.y);
	}
	public void Update()
	{
		enemylocation.x += enemyvelocity.x;
		enemylocation.y += enemyvelocity.y;
	}
}