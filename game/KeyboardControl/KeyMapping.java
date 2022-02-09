package com.mygdx.game.KeyboardControl;

import com.badlogic.gdx.Input.Keys;

public class KeyMapping {
	private String left, right;
	private String jump, crouch;
	private String attack, special;

	public KeyMapping() {
		// Needed for serialisation to work
	}

	public KeyMapping(String left, String right, String jump, String crouch, String attack, String special) {
		this.left = left;
		this.right = right;
		this.jump = jump;
		this.crouch = crouch;
		this.attack = attack;
		this.special = special;
	}

	public int getLeft() {
		return Keys.valueOf(this.left);
	}

	public void setLeft(int left) {
		this.left = Keys.toString(left);
	}

	public int getRight() {
		return Keys.valueOf(this.right);
	}

	public void setRight(int right) {
		this.right = Keys.toString(right);
	}

	public int getJump() {
		return Keys.valueOf(this.right);
	}

	public void setJump(int jump) {
		this.jump = Keys.toString(jump);
	}

	public int getCrouch() {
		return Keys.valueOf(this.crouch);
	}

	public void setCrouch(int crouch) {
		this.crouch = Keys.toString(crouch);
	}

	public int getAttack() {
		return Keys.valueOf(this.attack);
	}

	public void setAttack(int attack) {
		this.attack = Keys.toString(attack);
	}

	public int getSpecial() {
		return Keys.valueOf(this.special);
	}

	public void setSpecial(int special) {
		this.special = Keys.toString(special);
	}

	@Override
	public String toString() {
		return "KeyMapping [left=" + left + ", right=" + right + ", jump=" + jump + ", crouch=" + crouch + ", attack="
				+ attack + ", special=" + special + "]";
	}
}
