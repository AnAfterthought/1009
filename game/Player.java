package com.mygdx.game;

import com.mygdx.game.Character.PlayableCharacter;
import com.mygdx.game.KeyboardControl.KeyMapping;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data @AllArgsConstructor
public class Player {
	private long score;
	private KeyMapping keyMapping;
	private PlayableCharacter characterSelected;
	
	Player(long score, KeyMapping keyMapping, PlayableCharacter characterSelected) {
		this.score = score;
		this.keyMapping = keyMapping;
		this.characterSelected = characterSelected;
	}

	@Override
	public String toString() {
		return "Player [score=" + score + ", keyMapping=" + keyMapping + ", characterSelected="
				+ characterSelected.getName() + "]";
	}
	
	public long getScore() {
		return this.score;
	}
	
	public void setScore(long score) {
		this.score = score;
	}
	
	public KeyMapping getKeyMapping() {
		return this.keyMapping;
	}
	
	public PlayableCharacter getCharacterSelected() {
		return this.characterSelected;
	}
}
