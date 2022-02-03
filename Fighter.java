package com.mygdx.base_game_1;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Fighter {
	private float x;
	private float y;
	private int size;
	private int health;
	private int damage;
	private int speed;
	
	public Fighter(float x, float y, int size, int health, int damage, int speed) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.health = health;
		this.damage = damage;
		this.speed = speed;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public void draw(SpriteBatch batch, TextureRegion region, float x, float y) {
        batch.draw(region, x, y);
    }
	
	private boolean collidesWith(Fighter fighter) {
		if (this.x + this.size < fighter.getX() || this.x - this.size > fighter.getX() + fighter.getSize() || this.y + this.size < fighter.getY() || this.y - this.size > fighter.getY() + fighter.getSize()) {
			return false;
		}
		return true;
	}
	
	public void checkCollision(Fighter fighter) {
		if (collidesWith(fighter))System.out.println(this.health);
	}
	
}

