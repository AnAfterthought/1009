package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.PolymorphicPhiters;

public class StartScreen extends AbstractScreen {

	public StartScreen(PolymorphicPhiters game) {
		super(game);
	}

	@Override
	void inputHandler() {
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyDown(int keyCode) {
				if (keyCode == Keys.SPACE) {
					Gdx.input.setInputProcessor(null);
					game.setScreen(new GameScreen(game));
				}
				return true;
			}
		});
	}

	@Override
	public void show() {
		inputHandler();
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0, 0, 0.2f, 1);
		game.getSpriteBatch().begin();
		game.getBitmapFont().draw(this.game.getSpriteBatch(), "Title Screen!", Gdx.graphics.getWidth() * .25f,
				Gdx.graphics.getHeight() * .75f);
		game.getBitmapFont().draw(this.game.getSpriteBatch(), "Press space to play.", Gdx.graphics.getWidth() * .25f,
				Gdx.graphics.getHeight() * .25f);
		game.getSpriteBatch().end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		
	}
}
