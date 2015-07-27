package tennisscorer;

import java.util.HashMap;
import java.util.Map;

public enum TennisScore {
	ZERO("0", 0), FIFTEEN("15", 1), THIRTY("30", 2), FORTY("40", 3), WON("WON",
			4), DEUCE("DEUCE", 5), ADVANTAGE("ADVANTAGE", 6),LOST("LOST",7);

	private String scoreName;
	private Integer scoreValue;
	private static Map<Integer,TennisScore> scoreValuevsTennisScore;
	static{
		TennisScore[] tennisScores = TennisScore.values();
		scoreValuevsTennisScore=new HashMap<Integer, TennisScore>();
		for(TennisScore tennisScore: tennisScores){
			scoreValuevsTennisScore.put(tennisScore.getScoreValue(), tennisScore);
		}		
	}
	
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
	
	public static TennisScore findTennisScore(Integer scoreValue){
		return scoreValuevsTennisScore.get(scoreValue);
	}
}
