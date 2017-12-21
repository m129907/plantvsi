package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.plantvsigame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	     config.width =1000;
	     config.height = 600;
	     config.title = "PlantVsI Dont give me I Senpaiiiiiiiiiiiiiiiiiiiiiii";
		new LwjglApplication(new plantvsigame(), config);
	}

}
