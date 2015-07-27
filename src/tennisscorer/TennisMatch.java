package tennisscorer;

public class TennisMatch {
	private String[] scores;

	private String playerA;
	private String playerB;
	private Integer scoreOfPlayerA;
	private Integer scoreOfPlayerB;

	public TennisMatch(String playerA, String playerB) {
		scores = new String[7];
		scores[0] = "0";
		scores[1] = "15";
		scores[2] = "30";
		scores[3] = "40";
		scores[4] = "WON";
		scores[5] = "DEUCE";
		scores[6] = "ADVANTAGE";

		this.playerA = playerA;
		this.playerB = playerB;
		this.scoreOfPlayerA = 0;
		this.scoreOfPlayerB = 0;
	}

	public void updateScore(char point) {
		if (point == 'A') {
			increaseScoreOfPlayer(scoreOfPlayerA, scoreOfPlayerB);
		} else if (point == 'B') {
			increaseScoreOfPlayer(scoreOfPlayerA, scoreOfPlayerB);
		}
	}
	public void hasPlayerWon(String player){
		
	}
	public void displayScore() {
		System.out.println(scoreOfPlayerA + " " + scoreOfPlayerB);
	}
	
	private Integer increaseScoreOfPlayer(Integer scoreA, Integer scoreB) {
		if (scoreA < 3) {
			scoreA += 1;
		} else if (scoreA == 3) {
			if (scoreB == 3) {
				scoreA = 5;
				scoreB = 5;
			} else {
				scoreA = 4;
			}
		} else if (scoreA == 5) {
			scoreA = 6;
		} else if (scoreA == 6) {
			scoreA = 4;
		}
		return scoreA;
	}

	
}
