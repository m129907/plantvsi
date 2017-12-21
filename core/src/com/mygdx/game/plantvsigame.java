package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class plantvsigame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture shooter;
	Texture background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		shooter= new Texture("shooter.png");
		background = new Texture("frontyard.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background,0,0);
		batch.draw(shooter, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shooter.dispose();
	}
}
