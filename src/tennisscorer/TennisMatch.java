package tennisscorer;

public class TennisMatch {
	private final Character PLAYER_A = 'A';
	private final Character PLAYER_B = 'B';

	private Player playerA;
	private Player playerB;

	public TennisMatch(Player playerA, Player playerB) {
		this.playerA = playerA;
		this.playerB = playerB;
	}

	public void updateScore(char point) {
		if (point == PLAYER_A) {
			increaseScoreOfPlayer(playerA, playerB);
		} else if (point == PLAYER_B) {
			increaseScoreOfPlayer(playerB, playerA);
		}
	}

	public boolean hasPlayerWon(Player player) {
		return player.getScore() == TennisScore.WON;
	}

	public String fetchMatchScore() {
		return playerA.getScore().getScoreName() + " "
				+ playerB.getScore().getScoreName();
	}

	private void increaseScoreOfPlayer(Player playerA, Player playerB) {
		TennisScore scorePlayerA = playerA.getScore();
		TennisScore scorePlayerB = playerB.getScore();

		if (scorePlayerA.getScoreValue() < TennisScore.THIRTY.getScoreValue()) {
			setScoreForPlayer(playerA, scorePlayerA.getScoreValue() + 1);

		} else if (scorePlayerA == TennisScore.THIRTY) {
			if (scorePlayerB == TennisScore.FORTY) {
				playerA.setScore(TennisScore.DEUCE);
				playerB.setScore(TennisScore.DEUCE);
			} else {
				playerA.setScore(TennisScore.FORTY);
			}
		} else if (scorePlayerA == TennisScore.FORTY) {
			playerA.setScore(TennisScore.WON);
			playerB.setScore(TennisScore.LOST);
		} else if (scorePlayerA == TennisScore.DEUCE) {
			if (scorePlayerB == TennisScore.ADVANTAGE) {
				playerA.setScore(TennisScore.DEUCE);
				playerB.setScore(TennisScore.DEUCE);
			} else {
				playerA.setScore(TennisScore.ADVANTAGE);

			}
		} else if (scorePlayerA == TennisScore.ADVANTAGE) {
			playerA.setScore(TennisScore.WON);
			playerB.setScore(TennisScore.LOST);

		}
	}

	private void setScoreForPlayer(Player player, Integer score) {
		player.setScore(TennisScore.findTennisScore(score));

	}

}
