
public class King {
	public static boolean isInCheck(char[][] board, boolean whiteMoves) {
		char[][] pieces = new char[22][22];
		for(int i = 14; i >= 7; i--) {
			for(int j = 14; j>=7; j--) {
				pieces[j][i] = board[j-7][i-7];
			}
		}
		for(int i = 21; i >=0; i--) {
			for(int j = 0; j <22; j++) {
			}
		}
		if(whiteMoves) {
			int row = 0;
			int column = 0;
			for(int i = 7; i < 15; i++) {
				for(int j = 7; j < 15; j++) {
					if(pieces[j][i] == 'K') {
						column = j;
						row = i;
					}
				}
			}
			System.out.println(column + ", " + row);
			if(pieces[column-1][row-2]=='n'||pieces[column-2][row-1]=='n'||pieces[column-2][row+1]=='n'||pieces[column+1][row+2]=='n'||pieces[column+2][row+1]=='n'||pieces[column+2][row-1]=='n'||pieces[column+1][row-2]=='n') {
				return true;
			} else if(pieces[column-1][row+1]=='p'||pieces[column+1][row+1]=='p') {
				return true;
			} else {
				for(int i = 1; i < 8; i++) {
					if(pieces[column+i][row+i] == 'b'||pieces[column+i][row+i] == 'q'||pieces[column-i][row+i] == 'b'||pieces[column-i][row+i] == 'q'||pieces[column-i][row-i] == 'b'||pieces[column-i][row-i] == 'q'||pieces[column+i][row-i] == 'b'||pieces[column+i][row-i] == 'q') {
						System.out.println(i);
						for(int j = 1; j < i; j++) {
							if(i==1){
								return true;
							}
							else if((pieces[column+i][row+i] == 'b'||pieces[column+i][row+i] == 'q')&&pieces[column+j][row+j]!=' ') {
								return false;
							}
							else if((pieces[column+i][row-i] == 'b'||pieces[column+i][row-i] == 'q')&&pieces[column+j][row-j]!=' ') {
								return false;
							}
							else if((pieces[column-i][row-i] == 'b'||pieces[column-i][row-i] == 'q')&&pieces[column-j][row-j]!=' ') {
								return false;
							} 
							else if((pieces[column-i][row+i] == 'b'||pieces[column-i][row+i] == 'q')&&pieces[column-j][row+j]!=' ') {
								return false;
							}
						}
					} else if(pieces[column+i][row] == 'r'||pieces[column+i][row] == 'q'||pieces[column-i][row] == 'r'||pieces[column-i][row] == 'q'||pieces[column][row-i] == 'r'||pieces[column][row-i] == 'q'||pieces[column][row+i] == 'r'||pieces[column][row+i] == 'q') {
						for(int j = 1; j < i; j++) {
							if(j==i-1||i==1){
								return true;
							}
							else if((pieces[column+i][row] == 'r'||pieces[column+i][row] == 'q')&&pieces[column+j][row]!=' ') {
								return false;
							}
							else if((pieces[column-i][row] == 'r'||pieces[column-i][row] == 'q')&&pieces[column-j][row]!=' ') {
								return false;
							}
							else if((pieces[column][row-i] == 'r'||pieces[column][row-i] == 'q')&&pieces[column][row-j]!=' ') {
								return false;
							} 
							else if((pieces[column][row+i] == 'r'||pieces[column][row+i] == 'q')&&pieces[column][row+j]!=' ') {
								return false;
							}
						}
					}
				}
			}
		} else  {
			int row = 0;
			int column = 0;
			for(int i = 7; i < 15; i++) {
				for(int j = 7; j < 15; j++) {
					if(pieces[j][i] == 'k') {
						column = j;
						row = i;
					}
				}
			}
			if(pieces[column-1][row-2]=='N'||pieces[column-2][row-1]=='N'||pieces[column-2][row+1]=='N'||pieces[column+1][row+2]=='N'||pieces[column+2][row+1]=='N'||pieces[column+2][row-1]=='N'||pieces[column+1][row-2]=='N') {
				return true;
			}  else if(pieces[column-1][row-1]=='P'||pieces[column+1][row-1]=='P') {
				return true;
			} else {
				for(int i = 1; i < 8; i++) {
					if(pieces[column+i][row+i] == 'B'||pieces[column+i][row+i] == 'Q'||pieces[column-i][row+i] == 'B'||pieces[column-i][row+i] == 'Q'||pieces[column-i][row-i] == 'B'||pieces[column-i][row-i] == 'Q'||pieces[column+i][row-i] == 'B'||pieces[column+i][row-i] == 'Q') {
						for(int j = 1; j < i; j++) {
							if(i==1){
								return true;
							}
							else if((pieces[column+i][row+i] == 'B'||pieces[column+i][row+i] == 'Q')&&pieces[column+j][row+j]!=' ') {
								return false;
							}
							else if((pieces[column+i][row-i] == 'B'||pieces[column+i][row-i] == 'Q')&&pieces[column+j][row-j]!=' ') {
								return false;
							}
							else if((pieces[column-i][row-i] == 'B'||pieces[column-i][row-i] == 'Q')&&pieces[column-j][row-j]!=' ') {
								return false;
							} 
							else if((pieces[column-i][row+i] == 'B'||pieces[column-i][row+i] == 'Q')&&pieces[column-j][row+j]!=' ') {
								return false;
							}
						}
					} else if(pieces[column+i][row] == 'R'||pieces[column+i][row] == 'Q'||pieces[column-i][row] == 'R'||pieces[column-i][row] == 'Q'||pieces[column][row-i] == 'R'||pieces[column][row-i] == 'Q'||pieces[column][row+i] == 'R'||pieces[column][row+i] == 'Q') {
						for(int j = 1; j < i; j++) {
							if(j==i-1||i==1){
								return true;
							}
							else if((pieces[column+i][row] == 'R'||pieces[column+i][row] == 'Q')&&pieces[column+j][row]!=' ') {
								return false;
							}
							else if((pieces[column-i][row] == 'R'||pieces[column-i][row] == 'Q')&&pieces[column-j][row]!=' ') {
								return false;
							}
							else if((pieces[column][row-i] == 'R'||pieces[column][row-i] == 'Q')&&pieces[column][row-j]!=' ') {
								return false;
							} 
							else if((pieces[column][row+i] == 'R'||pieces[column][row+i] == 'Q')&&pieces[column][row+j]!=' ') {
								return false;
							}
						}
						
					}
				}
			}
		}
		return false;
	}
	public static boolean isCheckMate(char[][] pieces, boolean whiteMoves) {
		return false;
	}
}
