package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class plantvsigame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture shooter;
	Texture background;
	
	float screenwidth;
	float screenheight;
	
	Vector2 shooterlocation = new Vector2(0,0);
	
	@Override
	public void create () {
		screenwidth = Gdx.graphics.getWidth();
		screenheight = Gdx.graphics.getHeight();
		
		batch = new SpriteBatch();
		shooter= new Texture("shooter.png");
		background = new Texture("frontyard.jpg");
		
		shooterlocation = new Vector2(265,(screenheight/2)-(shooter.getHeight()/2));
	}

	public void update () {
		//if(Gdx.input.isKeyPressed(Keys.UP))
	}
	
	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background,0,0);
		batch.draw(shooter,shooterlocation.x, shooterlocation.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shooter.dispose();
	}
}
