import java.util.Scanner;
public class piecePrinter {
	static char[][] pieces;
	static boolean whiteMoves = true;
	public static void setPieces(char[][] piecesArray) {
		pieces = piecesArray;
	}
	public static void printPieces() {
		for(int i = 7; i >= 0; i--) {
			for(int j = 0; j < 8; j++) {
					System.out.print("| "+pieces[j][i] + " ");
					if(j==7) {
						System.out.print("| " + ((i)+1));
					}
			}
			//System.out.println("\n________________________________");
			System.out.println("\n----------------------------------");
		}
		System.out.println("  a   b   c   d   e   f   g   h");
	}
	public static void askForNextMove() {
		Scanner scan = new Scanner(System.in);
		if(whiteMoves) {
			System.out.println("White to move:");
		} else {
			System.out.println("Black to move:");
		}
		String s = scan.next();
		movePieces.checkMove(s, whiteMoves, pieces);
	}
	public static void didTheMove() {
		whiteMoves = !whiteMoves;
	}
	public static char[][] getPieces(){
		return pieces;
	}
}
