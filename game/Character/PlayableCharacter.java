package com.mygdx.game.Character;

import java.util.EnumMap;
import java.util.Map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import lombok.Data;

@Data
public abstract class PlayableCharacter {

	private float width;
	private float height;
	private Vector2 position;
	private String name;
	private CharacterState state;
	private double health;
	private Map<CharacterState, Animation<TextureRegion>> animation;
	protected double attackScale;
	protected float movementScale;
	public static final boolean DIRECTION_LEFT = true;
	public static final boolean DIRECTION_RIGHT = false;

	public PlayableCharacter(float width, float height, String name, double health, AssetManager manager) {
		this.width = width;
		this.height = height;
		this.name = name;
		this.health = health;
		this.state = CharacterState.IDLE;

		this.position = new Vector2(0, 0);
		animation = new EnumMap<CharacterState, Animation<TextureRegion>>(CharacterState.class);
		for (CharacterState state : CharacterState.values()) {
			TextureAtlas texture = manager
					.get(String.format("spritesheets/%s/%s.ATLAS", this.getClass().getSimpleName(), state));
			this.animation.put(state, new Animation<TextureRegion>(1f / 10f, texture.getRegions()));
		}
		
		System.out.println(this.width + " " + this.height);
	}

	public abstract void special();

	public Animation<TextureRegion> getAnimation(CharacterState state) {
		return animation.get(state);
	}

	public float getXCoordinate() {
		return this.position.x;
	}

	public void setXCoordinate(float xCoordinate) {
		this.position.x = xCoordinate;
	}

	public float getYCoordinate() {
		return this.position.y;
	}

	public void setYCoordinate(float yCoordinate) {
		this.position.y = yCoordinate;
	}
	
	public void setMovementScale(float movementScale) {
		this.movementScale = movementScale;
	}
	
	public double getHealth() {
		return this.health;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
	
	public CharacterState getState() {
		return this.state;
	}
	
	public void setState(CharacterState state) {
		this.state = state;
	}
	
	public void move(int screenWidth, float delta, boolean direction ) {
		this.setState(CharacterState.RUN);
		this.setXCoordinate(this.getXCoordinate() + (direction ? -1 : 1) * this.movementScale * delta);
		//governBoundaries(screenWidth, this.getXCoordinate());
	}
	
	public String getName() {
		return this.name;
	}
	
	/*private void governBoundaries(int screenWidth, float xCoordinate) {
		if (xCoordinate >= screenWidth - getWidth()) {
			setXCoordinate(xCoordinate - getWidth());
		}
		
		if (xCoordinate <= 0) {
			setXCoordinate(0);
		}
		
	}*/

}
