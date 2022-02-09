package com.mygdx.game.LeaderBoard;

public class LeaderBoardRecord implements Comparable<LeaderBoardRecord> {
	private String name;
	private long score;

	public LeaderBoardRecord() {
		// Needed for serialisation to work
	}

	public LeaderBoardRecord(String name, long score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "LeaderBoardRecord [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(LeaderBoardRecord o) {
		if (this.score > o.getScore()) {
			return 1;
		} else if (this.score < o.getScore()) {
			return -1;
		} else {
			return 0;
		}
	}
}
