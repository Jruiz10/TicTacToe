import java.util.Scanner;

/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * 
 * @author RUIZ
 * @date 2/26/18
 */
public class TTTConsole {

	public static Scanner scanner = new Scanner(System.in);
	public static TicTacToe board = new TicTacToe();
	public static int HUMAN_PLAYER = 1, COMPUTER_PLAYER = 2;

	/* The entry main method (the program starts here) */
	public static void main(String[] args) {

		int currState = ITicTacToe.PLAYING;

		while (currState == ITicTacToe.PLAYING) {
			board.printBoard();
			while (currState == ITicTacToe.PLAYING) {
				board.printBoard();

				// Print message if game-over
				currState = board.checkForWinner();

				if (currState == ITicTacToe.PLAYING) {
					System.out.println("Please enter a position 0-8: ");
					int loc = scanner.nextInt();
					if ((loc > 8) && (loc < 0)) {
						board.setMove(HUMAN_PLAYER, loc);
						board.setMove(COMPUTER_PLAYER, board.getComputerMove());
					} else {
						System.out.println("Number is out of bounds. Try a number from 0 to 8");
					}
				}

				if (currState == ITicTacToe.CROSS_WON) {
					System.out.println("'X' won! Bye!");
				} else if (currState == ITicTacToe.NOUGHT_WON) {
					System.out.println("'O' won! Bye!");
				} else if (currState == ITicTacToe.TIE) {
					System.out.println("It's a TIE! Bye!");

				}
			}
		}
	}
}