import java.util.*;
public class main {
		public static void main(String[] args) {
			char[][] pieces = new char[8][8];
//Makes all the squares empty
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j < 8; j++) {
					pieces[i][j] = ' ';
				}
			}
//Makes the Pawns
			for(int i = 0; i < 8; i++) {
				pieces[i][1] = 'P';
				pieces[i][6] = 'p';
			}
		
//Makes the Rooks
			pieces[0][0] = 'R';
			pieces[7][0] = 'R';
			pieces[0][7] = 'r';
			pieces[7][7] = 'r';
//Makes the Knights
			pieces[1][0] = 'N';
			pieces[6][0] = 'N';
			pieces[1][7] = 'n';
			pieces[6][7] = 'n';
//Makes the Bishops
			pieces[2][0] = 'B';
			pieces[5][0] = 'B';
			pieces[2][7] = 'b';
			pieces[5][7] = 'b';
//Makes the Queens and Kings
			pieces[3][0] = 'Q';
			pieces[3][7] = 'q';
			pieces[4][0] = 'K';
			pieces[4][7] = 'k';
			startGame(pieces);
		}
		public static void startGame(char[][] pieces) {
			piecePrinter.setPieces(pieces);
			piecePrinter.printPieces();
			piecePrinter.askForNextMove();
		}
}
