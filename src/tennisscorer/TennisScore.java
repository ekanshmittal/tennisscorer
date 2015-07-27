package tennisscorer;

public enum TennisScore {
	ZERO("0", 0) {
		@Override
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(FIFTEEN);
		}
	},
	FIFTEEN("15", 1) {
		@Override
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(THIRTY);
		}
	},
	THIRTY("30", 2) {
		public void updateScoreForPlayer(Player a, Player b) {
			if (b.getScore() == FORTY) {
				a.setScore(DEUCE);
				b.setScore(DEUCE);
			} else {
				a.setScore(FORTY);
			}
		}
	},
	FORTY("40", 3) {
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(TennisScore.WON);
			b.setScore(TennisScore.LOST);
		}
	},
	DEUCE("DEUCE", 4) {
		public void updateScoreForPlayer(Player a, Player b) {
			if (b.getScore() == TennisScore.ADVANTAGE) {
				a.setScore(TennisScore.DEUCE);
				b.setScore(TennisScore.DEUCE);
			} else {
				a.setScore(TennisScore.ADVANTAGE);
			}
		}
	},
	ADVANTAGE("ADVANTAGE", 5) {
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(TennisScore.WON);
			b.setScore(TennisScore.LOST);
		}
	},
	LOST("LOST", 6), WON("WON", 7);

	private String scoreName;
	private Integer scoreValue;

	TennisScore(String scoreName, Integer scoreValue) {
		this.scoreName = scoreName;
		this.scoreValue = scoreValue;
	}

	public String getScoreName() {
		return scoreName;
	}

	public Integer getScoreValue() {
		return scoreValue;
	}

	public void updateScoreForPlayer(Player a, Player b) {

	}
}
