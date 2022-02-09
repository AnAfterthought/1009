package com.mygdx.game.Character;

import com.badlogic.gdx.assets.AssetManager;

public class Tammy extends PlayableCharacter {

	public Tammy(float width, float height, String name, double health, AssetManager manager, float xCoordinate,
			float yCoordinate) {
		super(width, height, name, health, manager);
		setMovementScale(10f);
		setXCoordinate(xCoordinate);
		setYCoordinate(yCoordinate);
	}

	@Override
	public void special() {
		// function body for dash
		System.out.println("Tammy dash");
	}
}
