import java.util.ArrayList;

public class King {
	public static boolean isInCheck(char[][] board, boolean whiteMoves) {
		char[][] pieces = new char[22][22];
		for(int i = 14; i >= 7; i--) {
			for(int j = 14; j>=7; j--) {
				pieces[j][i] = board[j-7][i-7];
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
			if(pieces[column-1][row-2]=='n'||pieces[column-2][row-1]=='n'||pieces[column-2][row+1]=='n'||pieces[column+1][row+2]=='n'||pieces[column+2][row+1]=='n'||pieces[column+2][row-1]=='n'||pieces[column+1][row-2]=='n') {
				return true;
			} else if(pieces[column-1][row+1]=='p'||pieces[column+1][row+1]=='p') {
				return true;
			} else {
				for(int i = 1; i < 8; i++) {
					if(pieces[column+i][row+i] == 'b'||pieces[column+i][row+i] == 'q'||pieces[column-i][row+i] == 'b'||pieces[column-i][row+i] == 'q'||pieces[column-i][row-i] == 'b'||pieces[column-i][row-i] == 'q'||pieces[column+i][row-i] == 'b'||pieces[column+i][row-i] == 'q') {
						for(int j = 1; j < i; j++) {
							if(i==1||j==i-1){
								return true;
							}
							else if((pieces[column+i][row+i] == 'b'||pieces[column+i][row+i] == 'q')&&pieces[column+j][row+j]!=' ') {
								if(pieces[column+i][row] == 'r'||pieces[column+i][row] == 'q'||pieces[column-i][row] == 'r'||pieces[column-i][row] == 'q'||pieces[column][row-i] == 'r'||pieces[column][row-i] == 'q'||pieces[column][row+i] == 'r'||pieces[column][row+i] == 'q') {
									for(int k = 1; k < i; k++) {
										if(k==i-1||i==1){
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
								return false;
							}
							else if((pieces[column+i][row-i] == 'b'||pieces[column+i][row-i] == 'q')&&pieces[column+j][row-j]!=' ') {
								if(pieces[column+i][row] == 'r'||pieces[column+i][row] == 'q'||pieces[column-i][row] == 'r'||pieces[column-i][row] == 'q'||pieces[column][row-i] == 'r'||pieces[column][row-i] == 'q'||pieces[column][row+i] == 'r'||pieces[column][row+i] == 'q') {
									for(int k = 1; k < i; k++) {
										if(k==i-1||i==1){
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
								return false;
							}
							else if((pieces[column-i][row-i] == 'b'||pieces[column-i][row-i] == 'q')&&pieces[column-j][row-j]!=' ') {
								if(pieces[column+i][row] == 'r'||pieces[column+i][row] == 'q'||pieces[column-i][row] == 'r'||pieces[column-i][row] == 'q'||pieces[column][row-i] == 'r'||pieces[column][row-i] == 'q'||pieces[column][row+i] == 'r'||pieces[column][row+i] == 'q') {
									for(int k = 1; k < i; k++) {
										if(k==i-1||i==1){
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
								return false;
							} 
							else if((pieces[column-i][row+i] == 'b'||pieces[column-i][row+i] == 'q')&&pieces[column-j][row+j]!=' ') {
								if(pieces[column+i][row] == 'r'||pieces[column+i][row] == 'q'||pieces[column-i][row] == 'r'||pieces[column-i][row] == 'q'||pieces[column][row-i] == 'r'||pieces[column][row-i] == 'q'||pieces[column][row+i] == 'r'||pieces[column][row+i] == 'q') {
									for(int k = 1; j < i; j++) {
										if(k==i-1||i==1){								
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
					
					} else if(i == 7) {
						return false;
					}
				}
			}
		}  else {
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
			} else if(pieces[column-1][row+1]=='P'||pieces[column+1][row+1]=='P') {
				return true;
			} else {
				for(int i = 1; i < 8; i++) {
					if(pieces[column+i][row+i] == 'B'||pieces[column+i][row+i] == 'Q'||pieces[column-i][row+i] == 'B'||pieces[column-i][row+i] == 'Q'||pieces[column-i][row-i] == 'B'||pieces[column-i][row-i] == 'Q'||pieces[column+i][row-i] == 'B'||pieces[column+i][row-i] == 'Q') {
						for(int j = 1; j < i; j++) {
							if(i==1||j==i-1){
								return true;
							}
							else if((pieces[column+i][row+i] == 'B'||pieces[column+i][row+i] == 'Q')&&pieces[column+j][row+j]!=' ') {
								if(pieces[column+i][row] == 'R'||pieces[column+i][row] == 'Q'||pieces[column-i][row] == 'R'||pieces[column-i][row] == 'Q'||pieces[column][row-i] == 'R'||pieces[column][row-i] == 'Q'||pieces[column][row+i] == 'R'||pieces[column][row+i] == 'Q') {
									for(int k = 1; k < i; k++) {
										if(k==i-1||i==1){
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
								return false;
							}
							else if((pieces[column+i][row-i] == 'B'||pieces[column+i][row-i] == 'Q')&&pieces[column+j][row-j]!=' ') {
								if(pieces[column+i][row] == 'R'||pieces[column+i][row] == 'Q'||pieces[column-i][row] == 'R'||pieces[column-i][row] == 'Q'||pieces[column][row-i] == 'R'||pieces[column][row-i] == 'Q'||pieces[column][row+i] == 'R'||pieces[column][row+i] == 'Q') {
									for(int k = 1; k < i; k++) {
										if(k==i-1||i==1){
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
								return false;
							}
							else if((pieces[column-i][row-i] == 'B'||pieces[column-i][row-i] == 'Q')&&pieces[column-j][row-j]!=' ') {
								if(pieces[column+i][row] == 'R'||pieces[column+i][row] == 'Q'||pieces[column-i][row] == 'R'||pieces[column-i][row] == 'Q'||pieces[column][row-i] == 'R'||pieces[column][row-i] == 'Q'||pieces[column][row+i] == 'R'||pieces[column][row+i] == 'Q') {
									for(int k = 1; k < i; k++) {
										if(k==i-1||i==1){
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
								return false;
							} 
							else if((pieces[column-i][row+i] == 'B'||pieces[column-i][row+i] == 'Q')&&pieces[column-j][row+j]!=' ') {
								if(pieces[column+i][row] == 'R'||pieces[column+i][row] == 'Q'||pieces[column-i][row] == 'R'||pieces[column-i][row] == 'Q'||pieces[column][row-i] == 'R'||pieces[column][row-i] == 'Q'||pieces[column][row+i] == 'R'||pieces[column][row+i] == 'Q') {
									for(int k = 1; j < i; j++) {
										if(k==i-1||i==1){								
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
					
					} else if(i == 7) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static boolean isCheckMate(char[][] board, boolean whiteMoves) {
		System.out.println("check1 ");
		if(isInCheck(board, whiteMoves)) {
			char[][] pieces = new char[22][22];
			for(int i = 14; i >= 7; i--) {
				for(int j = 14; j>=7; j--) {
					pieces[j][i] = board[j-7][i-7];
				}
			}
			System.out.println("check2");
			if(whiteMoves) {
				ArrayList<Location> validMoves = new ArrayList<Location>();
				ArrayList<Character> validPieces = new ArrayList<Character>();
				validPieces.add('p');
				validPieces.add('b');
				validPieces.add('q');
				validPieces.add('R');
				validPieces.add('n');
				validPieces.add('k');
				validPieces.add(' ');
				int row = 0;
				int column = 0;
				System.out.println("check3");
				for(int i = 7; i < 15; i++) {
					for(int j = 7; j < 15; j++) {
						if(pieces[j][i] == 'K') {
							column = j;
							row = i;
						}
					}
				}
				System.out.println("X: " + column + "Y: " + row);
				for(int i = -1; i <= 1; i ++) {
					for(int j = -1; j<=1; j++) {
						if(validPieces.contains(pieces[column+j][row+i])&&(row!=0&&column!=0)) {
							System.out.println("check4");
							validMoves.add(new Location(column+j,row+i));
							System.out.println("Column: " + (column+j) + "Row: " + (row+i));
						}
					}
				}
				for(int i = 0; i < validMoves.size(); i++) {
					Location loc = validMoves.get(i);
					if(!(loc.column == -1 && loc.row == -1)) {
						System.out.println("check5");
						char piece = pieces[loc.column][loc.row];
						System.out.println(">" +piece+ "<");
						char[][] nextBoard = new char[8][8];
						for(int j = 7; j>=0; j--) {
							for(int k = 0; k <8; k++) {
								nextBoard[k][j] = pieces[k+7][j+7];
							}
						}
						nextBoard[loc.column-7][loc.row-7] = 'K';
						nextBoard[column-7][row-7] = ' ';
						for(int j = 7; j>=0; j--) {
							for(int k = 0; k < 8; k++) {
								System.out.print(nextBoard[k][j] + " ");
							}
							System.out.println();
						}
						if(isInCheck(nextBoard, whiteMoves)) {
							System.out.println((column-7) + "and " + (row-7));
							System.out.println((loc.column-7) + "and " + (loc.row-7));
							nextBoard[column-7][row-7] = 'K';
							nextBoard[loc.column-7][loc.row-7] = 'X';
							System.out.println(board[6][3]);
							loc.column = -1;
							loc.row = -1;
						} else {
							return false;
						}
						if(i==validMoves.size()-1) {
							return true;
						}
					}
				}
			}
		} else {
			System.out.println("cringe");
			return false;
		}
		return whiteMoves;
	}
}
