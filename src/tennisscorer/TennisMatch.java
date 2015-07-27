package tennisscorer;

import tennisscorer.TennisScore;

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

	private Integer increaseScoreOfPlayer(Player playerA, Player playerB) {
		int scoreValueOfPlayerA = playerA.getScore().getScoreValue();
		int scoreValueOfPlayerB = playerB.getScore().getScoreValue();

		if (scoreValueOfPlayerA < TennisScore.THIRTY.getScoreValue()) {
			setScoreForPlayer(playerA, scoreValueOfPlayerA + 1);

		} else if (scoreValueOfPlayerA == TennisScore.THIRTY.getScoreValue()) {
			if (scoreValueOfPlayerB == TennisScore.FORTY.getScoreValue()) {
				setScoreForPlayer(playerA, TennisScore.DEUCE.getScoreValue());
				setScoreForPlayer(playerB, TennisScore.DEUCE.getScoreValue());
			} else {
				setScoreForPlayer(playerA, TennisScore.FORTY.getScoreValue());
			}
		} else if (scoreValueOfPlayerA == TennisScore.FORTY.getScoreValue()) {
			setScoreForPlayer(playerA, TennisScore.WON.getScoreValue());
			setScoreForPlayer(playerB, TennisScore.LOST.getScoreValue());
		} else if (scoreValueOfPlayerA == TennisScore.DEUCE.getScoreValue()) {
			if (scoreValueOfPlayerB == TennisScore.ADVANTAGE.getScoreValue()) {
				setScoreForPlayer(playerA, TennisScore.DEUCE.getScoreValue());
				setScoreForPlayer(playerB, TennisScore.DEUCE.getScoreValue());
			} else {
				setScoreForPlayer(playerA,
						TennisScore.ADVANTAGE.getScoreValue());
			}
		} else if (scoreValueOfPlayerA == TennisScore.ADVANTAGE.getScoreValue()) {
			setScoreForPlayer(playerA, TennisScore.WON.getScoreValue());
			setScoreForPlayer(playerB, TennisScore.LOST.getScoreValue());

		}
		return scoreValueOfPlayerA;
	}

	private void setScoreForPlayer(Player player, Integer score) {
		player.setScore(TennisScore.findTennisScore(score));

	}

}
