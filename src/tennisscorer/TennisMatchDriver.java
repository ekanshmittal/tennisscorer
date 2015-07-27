package tennisscorer;

import java.util.Scanner;

public class TennisMatchDriver {
	public static void computeScore(String input) {
		Player playerA = new Player("A");
		Player playerB = new Player("B");
		TennisMatch tennisMatch = new TennisMatch(playerA, playerB);
		char x;
		for (int i = 0; i < input.length(); i++) {
			x = input.charAt(i);
			tennisMatch.updateScore(x);
			System.out.println(tennisMatch.fetchMatchScore());
		}
	}

	public static void main(String args[]) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the current match status");
			String input = scanner.next();
			computeScore(input);
		}
	}
}
