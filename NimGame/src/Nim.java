
import java.util.*;

public class Nim {
    // variables for class nim
    int colors_ind;
    int colors_rmvd;
    int queryLength;
    int queryColor;
    int i, j;
    Scanner scan = new Scanner(System.in);
    // random class for when computer move needs to be random
    Random rand = new Random();

    // takes input from users
    public void query() {
        System.out.print("Enter 1 for Green. Enter 2 for Yellow, Enter 3 for Orange: \n");
        queryColor = scan.nextInt();

        System.out.println("How many do you want to remove?\n");
        queryLength = scan.nextInt();

    }

    // finds the the nim sum of colors
    int nimSum(int[] colors, int length) {
        int s = colors[0];
        for (i = 1; i < length; i++) {
            s = s ^ colors[i];
        }
        return s;
    }

    // doing the optimal move if not optimal then do a random move
    public void smartMove(int[] colors, int length) {
        int nowsum = nimSum(colors, length);
        if (nowsum != 0) {
            for (i = 0; i < length; i++) {
                if ((colors[i] ^ nowsum) < colors[i]) {
                    colors_ind = i;
                    colors_rmvd = colors[i] - (colors[i] ^ nowsum);
                    colors[i] = (colors[i] ^ nowsum);
                    break;
                }
            }
        } else {
            int[] ColorsIndex = new int[length];

            for (i = 0, j = 0; i < length; i++)
                if (colors[i] > 0) {
                    ColorsIndex[j] = i;
                    ++j;
                }
            colors_ind = ColorsIndex[rand.nextInt(j)];
            colors_rmvd = 1 + rand.nextInt(colors[colors_ind]);
            colors[colors_ind] = colors[colors_ind] - colors_rmvd;

        }
    }

    public void displayBoard(int[] colors, int length) {
        System.out.println("\nDouble Trouble Board looks like:");
        for (i = 0; i < length; i++)
            if (i == 1) {
                System.out.print("Yellow: " + colors[i] + " ");
            } else if (i == 2) {
                System.out.print("Orange: " + colors[i] + " ");
            } else {
                System.out.print("Green: " + colors[i] + " ");
            }
        System.out.println();
    }

    // starting game
    public void startGame(int[] colors, int n, String move) {

        while (!gameOver(colors, n)) {
            displayBoard(colors, n);
            if (move.equals("AI")) {
                System.out.println("\nAI's turn!");
                smartMove(colors, n);
                int tmp = colors_ind + 1;
                String tmp2;
                if (tmp == 1) {
                    tmp2 = "Green";
                } else if (tmp == 2) {
                    tmp2 = "Yellow";
                } else {
                    tmp2 = "Orange";
                }
                System.out.println("AI removes " + colors_rmvd + " from color " + tmp2);
                move = "Human";
            } else if (move.equals("Human")) {
                System.out.println("\nYour turn!");
                query();

                colors[queryColor - 1] -= queryLength;
                String tmp2;
                if (queryColor == 1) {
                    tmp2 = "Green";
                } else if (queryColor == 2) {
                    tmp2 = "Yellow";
                } else {
                    tmp2 = "Orange";
                }
                System.out.println("Human removes " + queryLength + " from color " + tmp2);
                move = "AI";
            }

        }

        displayBoard(colors, n);
        anounceWinner(move);
    }

    // who wins the game?
    public void anounceWinner(String move) {
        if (move.equals("AI"))
            System.out.println(

                    "\nYOU WON:)");
        else if (move.equals("Human"))
            System.out.println(

                    "\nYOU LOST:(");
    }

    // checks if doubletrouble ended
    public boolean gameOver(int[] colors, int length) {
        // as long as the colors dont run out, it wont be gameover
        for (i = 0; i < length; i++) {
            if (colors[i] != 0)
                return false;
        }
        return true;
    }
}
