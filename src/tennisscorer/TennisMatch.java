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
		return playerA.getPlayerName() + ":"
				+ playerA.getScore().getScoreName() + " "
				+ playerB.getPlayerName() + ":"
				+ playerB.getScore().getScoreName();
	}

	private void increaseScoreOfPlayer(Player playerA, Player playerB) {
		playerA.getScore().updateScoreForPlayer(playerA, playerB);
	}
}
