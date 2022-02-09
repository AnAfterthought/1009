package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Character.Jerry;
import com.mygdx.game.Character.CharacterState;
import com.mygdx.game.Character.Tammy;
import com.mygdx.game.KeyboardControl.KeyboardControl;
import com.mygdx.game.KeyboardControl.KeyboardControlDAO;
import com.mygdx.game.Screen.StartScreen;

import lombok.Data;

@Data
public class PolymorphicPhiters extends Game {

	private AssetManager assetManager;
	private SpriteBatch spriteBatch;
	private BitmapFont bitmapFont;

	private Player player1, player2;

	private static final String tammy = "spritesheets/Tammy";
	private static final String jerry = "spritesheets/Jerry";

	private static void loadAssets(AssetManager manager) {
		for (CharacterState state : CharacterState.values()) {
			manager.load(String.format("%s/%s.ATLAS", tammy, state), TextureAtlas.class);
			manager.load(String.format("%s/%s.ATLAS", jerry, state), TextureAtlas.class);
		}
	}
	
	public AssetManager getAssetManager() {
		return this.assetManager;
	}
	
	public SpriteBatch getSpriteBatch() {
		return this.spriteBatch;
	}
	
	public BitmapFont getBitmapFont() {
		return this.bitmapFont;
	}
	
	public Player getPlayer1() {
		return this.player1;
	}
	
	public Player getPlayer2() {
		return this.player2;
	}

	@Override
	public void create() {
		this.assetManager = new AssetManager();
		this.bitmapFont = new BitmapFont();
		this.spriteBatch = new SpriteBatch();

		KeyboardControl controls = new KeyboardControlDAO().getKeyboardControl();
		loadAssets(assetManager);
		assetManager.finishLoading();

		this.player1 = new Player(0, controls.getPlayerOneKeyMapping(),
				new Tammy(112f, 224f, "Tammy", 100, this.getAssetManager(), 0, 0));
		this.player2 = new Player(0, controls.getPlayerTwoKeyMapping(),
				new Jerry(112f, 224f, "Jerry", 150, this.getAssetManager(), 0, 0));
		setScreen(new StartScreen(this));
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		bitmapFont.dispose();
		assetManager.dispose();
	}
}
