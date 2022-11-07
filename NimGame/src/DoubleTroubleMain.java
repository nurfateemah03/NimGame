
import java.util.*;

public class DoubleTroubleMain {
	public static void main(String[] args) {
		// variables used in main
		Nim nim = new Nim();
		try (Scanner scan2 = new Scanner(System.in)) {
			String player;

			// array
			int[] colors;
			colors = new int[3];
			colors[0] = 3;
			colors[1] = 7;
			colors[2] = 5;

			// intro to the game showing the layout of double trouble and introducing the
			// history of the game.
			try (Scanner scan = new Scanner(System.in)) {
				char[][] doubleTroubleVisual =
						// prints out layout of double trouble for general idea
						{ { ' ', ' ', ' ', ' ', 'G', ' ', ' ' },
								{ ' ', ' ', ' ', 'G', ' ', 'G', ' ' },
								{ ' ', ' ', 'Y', ' ', 'Y', ' ', 'Y' },
								{ ' ', 'Y', ' ', 'Y', ' ', 'Y', ' ', 'Y' },
								{ 'O', ' ', 'O', ' ', 'O', ' ', 'O', ' ', 'O' } };

				// talks about the background of the game
				printdoubleTroubleVisual(doubleTroubleVisual);
				System.out.println(
						"The real name of the game is nim game, and it is a mathematical game of strategy. There have been many different versions of this game, the oldest one dating all the way "
								+
								"back to Ancient Chinese times. However, it was coined by Charles L.Bouton of Harvard University. In 1940, there was a machine called the Nimatron that played nim, and it became "
								+
								"a challenge to beat, it was also one of the first ever electronic computerized games. If a person were to beat it then they were given a coin that said Nim Champ. ");
				System.out.println();
				// determines wheter is player 1 or 2. if 1 is entered the code will run the
				// human part, other wise it will run the computer part.
				System.out.print("Let's start with who is playing first, do you want to be player 1 or 2? ");
				player = scan2.next();

				// starts the game
				if (player.equals("1"))
					nim.startGame(colors, colors.length, "Human");

				else
					nim.startGame(colors, colors.length, "AI");
			}
		}

	}

	// method to print the double trouble layout
	public static void printdoubleTroubleVisual(char[][] doubleTroubleVisual) {
		for (char[] row : doubleTroubleVisual) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

}