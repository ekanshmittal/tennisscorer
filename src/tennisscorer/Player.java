package tennisscorer;

public class Player {
	private String playerName;
	private TennisScore score;

	public Player(String playerName) {
		this.playerName = playerName;
		this.score = TennisScore.ZERO;
	}

	public String getPlayerName() {
		return playerName;
	}

	public TennisScore getScore() {
		return score;
	}

	public void setScore(TennisScore score) {
		this.score = score;
	}

}
