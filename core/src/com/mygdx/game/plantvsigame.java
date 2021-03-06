package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer.Random;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;



public class plantvsigame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture shooter;
	Texture background;
	Texture bulletT;
	Texture monster;
	Texture bullet2T;
	
	private int score; 
	private String scoreboard; 
	BitmapFont scoreBitmapFont;
	
	int amoutx = 30;
	Random r = new Random();
	
		
	float screenwidth;
	float screenheight;
	
	Vector2 shooterlocation = new Vector2(0,0);
	Vector2 monsterlocation = new Vector2(0,0);
	
	ArrayList<Bullet> bulletManager = new ArrayList<Bullet>();
	ArrayList<Bullet2> bullet2Manager = new ArrayList<Bullet2>();
	
	@Override
	public void create () {
		screenwidth = Gdx.graphics.getWidth();
		screenheight = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		shooter= new Texture("shooter.png");
		background = new Texture("frontyard.jpg");
		bulletT = new Texture("bullet.png");
		monster = new Texture("monster.png");
		bullet2T = new Texture("bullet2.png");
		
		shooterlocation = new Vector2(265,(screenheight/2)-(shooter.getHeight()/2));
		monsterlocation = new Vector2(905,(screenheight/2)-(shooter.getHeight()/2));
		
		score = (0);
		scoreboard = ("score = 0");
		scoreBitmapFont = new BitmapFont();
	}

	public void update () throws InterruptedException {
		if(Gdx.input.isKeyPressed(Keys.W)) {
			
			shooterlocation.y = shooterlocation.y + 5;
		}
		if(Gdx.input.isKeyPressed(Keys.S)) {
		
			shooterlocation.y = shooterlocation.y - 5;
		}
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			Bullet myBullet = new Bullet(shooterlocation,new Vector2(4,0));
			bulletManager.add(myBullet);
		}
		if(Gdx.input.isKeyPressed(Keys.UP)) {
			
			monsterlocation.y = monsterlocation.y + 5;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
		
			monsterlocation.y = monsterlocation.y - 5;
		}
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			Bullet2 myBullet2 = new Bullet2(monsterlocation,new Vector2(-4,0));
			bullet2Manager.add(myBullet2);
		}
	
	}
	
	@Override
	public void render () {
		int random = (int )(Math.random() * 200 );
		try {
			update();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background,0,0);
		batch.draw(shooter,shooterlocation.x, shooterlocation.y);
		batch.draw(monster,monsterlocation.x,monsterlocation.y);
		
		int count = 0;
		while(count < bulletManager.size()) 
		{
			Bullet currentBullet = bulletManager.get(count);
			currentBullet.Update();
			batch.draw(bulletT,currentBullet.bulletlocation.x,currentBullet.bulletlocation.y);
			count++;
			
		}
		int counter = 0;
		while(counter < bullet2Manager.size()) 
		{
			Bullet2 currentBullet2 = bullet2Manager.get(counter);
			currentBullet2.Update();
			batch.draw(bullet2T,currentBullet2.bullet2location.x,currentBullet2.bullet2location.y);
			counter++;
			
		}
		scoreBitmapFont.setColor(1,0,0,1);
		scoreBitmapFont.draw(batch, scoreboard, 80,80);
		
		
		batch.end();

		Iterator<Bullet> itbullet = bulletManager.iterator();
			while(itbullet.hasNext()) {
			if(bullet.overlaps(monster)) {
				itbullet.remove();
				
				}
			}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shooter.dispose();
	}
}
