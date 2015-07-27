package tennisscorer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TennisMatchTest {

	@Test
	public void testUpdateScore() {
		Player playerA = new Player("A");
		Player playerB = new Player("B");
		TennisMatch tennisMatch = new TennisMatch(playerA, playerB);
		tennisMatch.updateScore('A');
		assertEquals("Score of A : 15 and B : 0", "A:15 B:0", tennisMatch.fetchMatchScore());
	}

	@Test
	public void testHasPlayerWon() {
		Player playerA = new Player("A");
		Player playerB = new Player("B");
		TennisMatch tennisMatch = new TennisMatch(playerA, playerB);
		tennisMatch.updateScore('A');
		assertEquals("Should return false", false, tennisMatch.hasPlayerWon(playerA));
	}

	@Test
	public void testFetchMatchScore() {
		Player playerA = new Player("A");
		Player playerB = new Player("B");
		TennisMatch tennisMatch = new TennisMatch(playerA, playerB);
		assertEquals("Score of A : 15 and B : 0", "A:0 B:0", tennisMatch.fetchMatchScore());
	}

}
