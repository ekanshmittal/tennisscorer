package tennisscorer;

public enum TennisScore {
	ZERO("0") {
		@Override
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(FIFTEEN);
		}
	},
	FIFTEEN("15") {
		@Override
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(THIRTY);
		}
	},
	THIRTY("30") {
		public void updateScoreForPlayer(Player a, Player b) {
			if (b.getScore() == FORTY) {
				a.setScore(DEUCE);
				b.setScore(DEUCE);
			} else {
				a.setScore(FORTY);
			}
		}
	},
	FORTY("40") {
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(TennisScore.WON);
			b.setScore(TennisScore.LOST);
		}
	},
	DEUCE("DEUCE") {
		public void updateScoreForPlayer(Player a, Player b) {
			if (b.getScore() == TennisScore.ADVANTAGE) {
				a.setScore(TennisScore.DEUCE);
				b.setScore(TennisScore.DEUCE);
			} else {
				a.setScore(TennisScore.ADVANTAGE);
				b.setScore(NON_ADVANTAGE);
			}
		}
	},
	NON_ADVANTAGE("-"){
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(TennisScore.DEUCE);
			b.setScore(TennisScore.DEUCE);
		}
	},
	ADVANTAGE("ADVANTAGE") {
		public void updateScoreForPlayer(Player a, Player b) {
			a.setScore(TennisScore.WON);
			b.setScore(TennisScore.LOST);
		}
	},
	LOST("LOST"), WON("WON");

	private String scoreName;
	
	TennisScore(String scoreName) {
		this.scoreName = scoreName;
	}

	public String getScoreName() {
		return scoreName;
	}
	public void updateScoreForPlayer(Player a, Player b) {

	}
}
