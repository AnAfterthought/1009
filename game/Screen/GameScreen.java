package com.mygdx.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Character.CharacterState;
import com.mygdx.game.Character.PlayableCharacter;
import com.mygdx.game.Player;
import com.mygdx.game.PolymorphicPhiters;

public class GameScreen extends AbstractScreen {

	private PlayableCharacter player1Character, player2Character;
	private Player player1, player2;
	private float animationTime = 0;
	private float moveSpeed;
	private Rectangle player1Hitbox, player2Hitbox;
	private float healthBarWidth = Gdx.graphics.getWidth()/7 * 3;
	private double player1OriginalHealth, player2OriginalHealth;
	private boolean finish;

	public GameScreen(PolymorphicPhiters game) {
		super(game);

		this.player1 = game.getPlayer1();
		this.player2 = game.getPlayer2();
		this.player1Character = this.player1.getCharacterSelected();
		this.player2Character = this.player2.getCharacterSelected();
		this.player1Hitbox = new Rectangle();
		this.player2Hitbox = new Rectangle();

		this.moveSpeed = 0.5f;
		this.player1OriginalHealth = this.player1Character.getHealth();
		this.player2OriginalHealth = this.player2Character.getHealth();
	}

	@Override
	void inputHandler() {
		if (Gdx.input.isKeyPressed(player1.getKeyMapping().getLeft())) {
			player1Character.move(Gdx.graphics.getWidth(), animationTime, PlayableCharacter.DIRECTION_LEFT);
		}

		if (Gdx.input.isKeyPressed(player1.getKeyMapping().getRight())) {
			player1Character.move(Gdx.graphics.getWidth(), animationTime, PlayableCharacter.DIRECTION_RIGHT);
		}
		
		if (Gdx.input.isKeyPressed(player1.getKeyMapping().getAttack())) {
			if (player1Hitbox.overlaps(player2Hitbox)) {
				if (player2Character.getHealth() - 10 > 0) {
					player2Character.setHealth(player2Character.getHealth() - 10);
				} else if (player2Character.getHealth() - 10 <= 0) {
					player2Character.setHealth(0);
					player1.setScore(player1.getScore() + 1);
				}
			}
		}

		if (Gdx.input.isKeyPressed(player2.getKeyMapping().getLeft())) {
			player2Character.move(Gdx.graphics.getWidth(), animationTime, PlayableCharacter.DIRECTION_LEFT);
		}

		if (Gdx.input.isKeyPressed(player2.getKeyMapping().getRight())) {
			player2Character.move(Gdx.graphics.getWidth(), animationTime, PlayableCharacter.DIRECTION_RIGHT);
		}
		
		if (Gdx.input.isKeyPressed(player2.getKeyMapping().getAttack())) {
			if (player2Hitbox.overlaps(player1Hitbox)) {
				if (player1Character.getHealth() - 10 > 0) {
					player1Character.setHealth(player1Character.getHealth() - 10);
				} else if (player1Character.getHealth() - 10 <= 0) {
					player1Character.setHealth(0);
					player2.setScore(player2.getScore() + 1);
				}
			}
		}
	}
	
	private void governState() {
		
		if (player1Character.getAnimation(player1Character.getState()).isAnimationFinished(animationTime)) {
			if (Gdx.input.isKeyJustPressed(player1.getKeyMapping().getLeft()) || Gdx.input.isKeyJustPressed(player1.getKeyMapping().getRight())) {
				player1Character.setState(CharacterState.IDLE);
			}
		}
		if (player2Character.getAnimation(player2Character.getState()).isAnimationFinished(animationTime)) {
			if (Gdx.input.isKeyJustPressed(player2.getKeyMapping().getLeft()) || Gdx.input.isKeyJustPressed(player2.getKeyMapping().getRight())) {
				player2Character.setState(CharacterState.IDLE);
			}
		}
	}

	@Override
	public void show() {
	}

	@Override
	public void render(float delta) {
		animationTime += delta;

		ScreenUtils.clear(0, 0, 0.2f, 1);

		game.getSpriteBatch().begin();

		game.getSpriteBatch()
				.draw((TextureRegion) player1Character.getAnimation(player1Character.getState())
						.getKeyFrame(animationTime, true), player1Character.getXCoordinate(),
						player1Character.getYCoordinate());

		game.getSpriteBatch()
				.draw((TextureRegion) player2Character.getAnimation(player2Character.getState())
						.getKeyFrame(animationTime, true), player2Character.getXCoordinate(),
						player2Character.getYCoordinate());
		
		player1Hitbox.x = player1Character.getXCoordinate() + 15;
		player1Hitbox.y = 0;
		player1Hitbox.width = 21;
		player1Hitbox.height = 30;
		
		player2Hitbox.x = player2Character.getXCoordinate() + 100;
		player2Hitbox.y = 0;
		player2Hitbox.width = 28;
		player2Hitbox.height = 45;
		
		game.getSpriteBatch().end();
		
		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(0, Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/16, healthBarWidth, Gdx.graphics.getHeight()/16);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(0, Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/16, (float)(healthBarWidth * player1Character.getHealth()/player1OriginalHealth), Gdx.graphics.getHeight()/16);
        
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(Gdx.graphics.getWidth()/7 * 4, Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/16, healthBarWidth, Gdx.graphics.getHeight()/16);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.rect(Gdx.graphics.getWidth()/7 * 4 + (healthBarWidth - (float)(healthBarWidth * player2Character.getHealth()/player2OriginalHealth)), Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/16, (float)(healthBarWidth * player2Character.getHealth()/player2OriginalHealth), Gdx.graphics.getHeight()/16);
        shapeRenderer.end();

		inputHandler();
		governState();
		
		if (player1.getScore() == 2) {
			System.out.println("Player 1 wins");
			finish = true;
		} else if (player2.getScore() == 2) {
			System.out.println("Player 2 wins");
			finish = true;
		}
		
		if ((player1Character.getHealth() == 0 || player2Character.getHealth() == 0) && !finish) {
			player1Character.setHealth(player1OriginalHealth);
			player2Character.setHealth(player2OriginalHealth);
			
		}
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
		Gdx.input.setInputProcessor(null);
	}
}
