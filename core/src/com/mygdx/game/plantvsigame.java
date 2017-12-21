package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class plantvsigame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture shooter;
	Texture background;
	Texture bulletT;
	Texture enemyT;
	
	float screenwidth;
	float screenheight;
	
	Vector2 shooterlocation = new Vector2(0,0);
	
	
	ArrayList<Bullet> bulletManager = new ArrayList<Bullet>();
	ArrayList<Enemy> enemyManager = new ArrayList<Enemy>();
	
	@Override
	public void create () {
		screenwidth = Gdx.graphics.getWidth();
		screenheight = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		shooter= new Texture("shooter.png");
		background = new Texture("frontyard.jpg");
		bulletT = new Texture("bullet.png");
		shooterlocation = new Vector2(265,(screenheight/2)-(shooter.getHeight()/2));
	}

	public void update () {
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			
			shooterlocation.y = shooterlocation.y + 3;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
		
			shooterlocation.y = shooterlocation.y - 3;
		}
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			Bullet myBullet = new Bullet(shooterlocation,new Vector2(4,0));
			bulletManager.add(myBullet);
		}
		
		
	}
	
	@Override
	public void render () {
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background,0,0);
		batch.draw(shooter,shooterlocation.x, shooterlocation.y);
		
		int count = 0;
		while(count < bulletManager.size()) 
		{
			Bullet currentBullet = bulletManager.get(count);
			currentBullet.Update();
			batch.draw(bulletT,currentBullet.bulletlocation.x,currentBullet.bulletlocation.y);
			count++;
		}
		
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shooter.dispose();
	}
}
