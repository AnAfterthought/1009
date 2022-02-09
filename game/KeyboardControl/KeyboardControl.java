package com.mygdx.game.KeyboardControl;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class KeyboardControl {
	private KeyMapping playerOneKeyMapping;
	private KeyMapping playerTwoKeyMapping;

	@Override
	public String toString() {
		return "KeyboardControl [playerOneKeyMapping=" + playerOneKeyMapping + ", playerTwoKeyMapping="
				+ playerTwoKeyMapping + "]";
	}
	
	public KeyMapping getPlayerOneKeyMapping() {
		return this.playerOneKeyMapping;
	}
	
	public KeyMapping getPlayerTwoKeyMapping() {
		return this.playerTwoKeyMapping;
	}
}
