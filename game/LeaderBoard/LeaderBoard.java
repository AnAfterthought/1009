package com.mygdx.game.LeaderBoard;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class LeaderBoard {
	private ArrayList<LeaderBoardRecord> rankings;

	public void updateRankings(LeaderBoardRecord record) {
		this.rankings.add(record);
	}

	@Override
	public String toString() {
		return "LeaderBoard [rankings=" + rankings + "]";
	}
}
