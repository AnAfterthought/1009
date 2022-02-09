package com.mygdx.game.Character;

import com.badlogic.gdx.assets.AssetManager;

public class Jerry extends PlayableCharacter {

	public Jerry(float width, float height, String name, double health, AssetManager manager, float xCoordinate,
			float yCoordinate) {
		super(width, height, name, health, manager);
		setMovementScale(8f);
		setXCoordinate(xCoordinate);
		setYCoordinate(yCoordinate);
	}

	@Override
	public void special() {
		// heal
		this.setHealth(this.getHealth() + 25);
	}
}
