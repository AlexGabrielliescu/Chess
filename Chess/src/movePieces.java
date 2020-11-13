import java.util.ArrayList;
import java.util.Scanner;
public class movePieces {
	public static void checkMove(String s, boolean whiteMoves, char[][] pieces) {
			ArrayList<Location> pieceLocations = new ArrayList<Location>();
			ArrayList<Character> validPieces = new ArrayList<Character>();
			ArrayList<Character> validBlackPieces = new ArrayList<Character>();
			validPieces.add('P');
			validPieces.add('B');
			validPieces.add('N');
			validPieces.add('R');
			validPieces.add('Q');
			validPieces.add('K');
			validBlackPieces.add('p');
			validBlackPieces.add('b');
			validBlackPieces.add('n');
			validBlackPieces.add('r');
			validBlackPieces.add('q');
			validBlackPieces.add('k');
	
			char piece = ' ';
			char column = ' ';
			int row = 0;
			int realColumn = 0;
			if(s.length() == 2) {
				System.out.println("bruh");
				if(whiteMoves) {
					piece = 'P';
				} else {
					piece = 'p';
				}
				try {
					row = Integer.parseInt(String.valueOf(s.charAt(1)));
					} catch(java.lang.NumberFormatException e) {
						piecePrinter.printPieces();
						System.out.println("This is not a valid move!");
						piecePrinter.askForNextMove();
					}
				column = s.charAt(0);
				row--;
				if(column == 'a') {
					realColumn = 0;
				}
				else if(column == 'b') {
					realColumn = 1;
				}
				else if(column == 'c') {
					realColumn = 2;
				}
				else if(column == 'd') {
					realColumn = 3;
				}
				else if(column == 'e') {
					realColumn = 4;
				}
				else if(column == 'f') {
					realColumn = 5;
				}
				else if(column == 'g') {
					realColumn = 6;
				}
				else if(column == 'h') {
					realColumn = 7;
				} else {
					piecePrinter.printPieces();
					System.out.println("This is not a valid move!");
					piecePrinter.askForNextMove();
				}
				System.out.println("Piece: " + piece + " Column: " + (realColumn) +  " Row: " + row);
			} else if(s.length() == 3){
				System.out.println("bbruh");
				//if(s.equals("O-O")) {
					
				//} else {
				piece = s.charAt(0);
					try {
						row = Integer.parseInt(String.valueOf(s.charAt(2)));
					} catch(java.lang.NumberFormatException e) {
						piecePrinter.printPieces();
						System.out.println("This is not a valid move!");
						piecePrinter.askForNextMove();
					}
					column = s.charAt(1);
					row--;
					if(column == 'a') {
						realColumn = 0;
					}
					else if(column == 'b') {
						realColumn = 1;
					}
					else if(column == 'c') {
						realColumn = 2;
					}
					else if(column == 'd') {
						realColumn = 3;
					}
					else if(column == 'e') {
						realColumn = 4;
					}
					else if(column == 'f') {
						realColumn = 5;
					}
					else if(column == 'g') {
						realColumn = 6;
					}
					else if(column == 'h') {
						realColumn = 7;
					} else {
						piecePrinter.printPieces();
						System.out.println("This is not a valid move!");
						piecePrinter.askForNextMove();
					}
					System.out.println("Piece: " + piece + " Column: " + (realColumn) +  " Row: " + (row));
				}
			/*} else {
				if(s.equals("O-O-O")) {
					
				} else {
					System.out.println("This is not a valid move!");
					piecePrinter.printPieces();
					piecePrinter.askForNextMove();
				}
			
			}*/
			if(!validPieces.contains(Character.toUpperCase(piece))) {
				piecePrinter.printPieces();
				System.out.println("This is not a valid move!");
				piecePrinter.askForNextMove();
			}
			if(realColumn < 0||realColumn>7) {
				piecePrinter.printPieces();
				System.out.println("This is not a valid move!");
				System.out.println("Column " + realColumn);
				piecePrinter.askForNextMove();
			}
			if(row < 0 || row >7) {
				piecePrinter.printPieces();
				System.out.println("This is not a valid move!");
				System.out.println(row);
				piecePrinter.askForNextMove();
			}
			for(int i = 0; i < 8; i++) {
				for(int j = 0; j <8; j++) {
					if(pieces[j][i] == piece) {
						pieceLocations.add(new Location(j,i));
						System.out.println("X: " + (j) + " Y: " + (i) + " Piece: " + piece);
					}
				}
			}
			char pieceAt = pieces[realColumn][row];
			if(whiteMoves) {
				System.out.println("check");
				if(piece == 'N') {
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						if(((loc.row-1==row&&loc.column-2==realColumn)||(loc.row-2==row&&loc.column-1==realColumn)||(loc.row-2==row&&loc.column+1==realColumn)||(loc.row-1==row&&loc.column+2==realColumn)||(loc.row+2==row&&loc.column+1==realColumn)||(loc.row+2==row&&loc.column-1==realColumn)||(loc.row+1==row&&loc.column-2==realColumn)||(loc.row+1==row&&loc.column+2==realColumn))&&!validPieces.contains((pieces[realColumn][row]))) {
							pieces[loc.column][loc.row] = ' ';
							pieces[realColumn][row] = piece;
							if(King.isInCheck(pieces, whiteMoves)) {
								pieces[realColumn][row] = pieceAt;
								pieces[loc.column][loc.row] = piece;
								piecePrinter.printPieces();
								System.out.println("This is not a valid move!");
								piecePrinter.askForNextMove();
							}else if(King.isCheckMate(pieces, !whiteMoves)){
								if(whiteMoves) {System.out.println("Black wins"); }
								else {System.out.println("White wins!");}
							}else {
								piecePrinter.setPieces(pieces);
								piecePrinter.didTheMove();
								piecePrinter.printPieces();
								piecePrinter.askForNextMove();
								specialMoves.enpassant = false;
							}
						} else if(i == pieceLocations.size()-1) {
							piecePrinter.printPieces();
							System.out.println("This is not a valid move!");
							piecePrinter.askForNextMove();					
						}
					}
				} else  if(piece == 'P') {
						for(int i = 0; i < pieceLocations.size(); i++) {
							Location loc = pieceLocations.get(i);
							System.out.println(loc.column + ", " + loc.row);
							if(((loc.row+1==row&&loc.column==realColumn&&pieces[realColumn][row]==' ')||(loc.row+2==row&&loc.column==realColumn&&pieces[realColumn][row]==' '&&loc.row==1)||(loc.row+1==row&&loc.column+1==realColumn&&pieces[realColumn][row]!=' ')||(loc.row+1==row&&loc.column-1==realColumn&&pieces[realColumn][row]!=' '))&&!validPieces.contains(pieces[realColumn][row])) {
								pieces[loc.column][loc.row] = ' ';
								pieces[realColumn][row] = piece;
								if(King.isInCheck(pieces, whiteMoves)) {
									pieces[realColumn][row] = pieceAt;
									pieces[loc.column][loc.row] = piece;
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();
								} else if(King.isCheckMate(pieces, !whiteMoves)){
									if(whiteMoves) {System.out.println("Black wins"); }
									else {System.out.println("White wins!");}
								} else {
									if(loc.row==1&&row==loc.row+2) {
										specialMoves.setEnpassantLoc(new Location(loc.column,loc.row+1));
										specialMoves.enpassantable(true);
									}  else {
										specialMoves.setEnpassantLoc(new Location(0,0));
										specialMoves.enpassantable(false);
									}
									if(row == 7){
										 System.out.println("What piece will you promote to?");
										 boolean goodAnswer = false;
										 Scanner scan = new Scanner(System.in);
										while(!goodAnswer) {
											String promotion = scan.next();
											if(validPieces.contains(Character.toUpperCase(promotion.charAt(0)))) {
												pieces[realColumn][row] = Character.toUpperCase(promotion.charAt(0));
												goodAnswer = true;
											} else {
												System.out.println("That is not a valid piece!");
											}
										}
										scan.close();
									}
									piecePrinter.setPieces(pieces);
									piecePrinter.didTheMove();
									piecePrinter.printPieces();
									piecePrinter.askForNextMove();
								}
							} else if(specialMoves.enpassant&&(loc.column+1==realColumn||loc.column-1==realColumn)&&loc.row+1==row&&realColumn==specialMoves.enpassantLocation.column&&row==specialMoves.enpassantLocation.row&&pieces[realColumn][row]==' ') {
								pieces[loc.column][loc.row] = ' ';
								pieces[specialMoves.enpassantLocation.column][specialMoves.enpassantLocation.row-1] = ' ';
								pieces[realColumn][row] = piece;
								if(King.isInCheck(pieces, whiteMoves)) {
									pieces[realColumn][row] = pieceAt;
									pieces[specialMoves.enpassantLocation.column][specialMoves.enpassantLocation.row-1] = 'p';
									pieces[loc.column][loc.row] = piece;	
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();
								} else if(King.isCheckMate(pieces, !whiteMoves)){
									if(whiteMoves) {System.out.println("Black wins"); }
									else {System.out.println("White wins!");}
								} else {
									piecePrinter.setPieces(pieces);
									piecePrinter.didTheMove();
									piecePrinter.printPieces();
									piecePrinter.askForNextMove();
									specialMoves.enpassant = false;
									specialMoves.setEnpassantLoc(new Location(0,0));
									specialMoves.enpassantable(false);
								}
								
							} 
							System.out.println("im done with life");
							if(i == pieceLocations.size()-1) {
								piecePrinter.printPieces();
								System.out.println("This is not a valid move!2");
								piecePrinter.askForNextMove();					
							}
						}
						
				} else if(piece == 'B'){
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						for(int j = 1; j <= 7; j++) {
							if(((loc.column+j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row-j==row)||(loc.column+j==realColumn&&loc.row-j==row))&&!validPieces.contains(pieces[realColumn][row])){
								boolean canMove = false;							 
								for(int k = 1; k < j; k++) {
									if(k==j-1||j==1) {
										canMove = true;
									} else
									if((loc.column+j==realColumn&&loc.row+j==row)&&(pieces[loc.column+k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column+j==realColumn&&loc.row-j==row)&&(pieces[loc.column+k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row+j==row)&&(pieces[loc.column-k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row-j==row)&&(pieces[loc.column-k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} 
								}
								if(canMove||j==1) {
									pieces[loc.column][loc.row] = ' ';
									pieces[realColumn][row] = piece;
									if(King.isInCheck(pieces, whiteMoves)) {
										pieces[realColumn][row] = pieceAt;
										pieces[loc.column][loc.row] = piece;
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();
									} else if(King.isCheckMate(pieces, !whiteMoves)){
										if(whiteMoves) {System.out.println("Black wins"); }
										else {System.out.println("White wins!");}
									} else {
										piecePrinter.setPieces(pieces);
										piecePrinter.didTheMove();
										piecePrinter.printPieces();
										piecePrinter.askForNextMove();
										specialMoves.enpassant = false;
									}
								} else if(i == pieceLocations.size()-1) {
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();		
								}
							}  
						} 
					}
				} else if (piece == 'R'){
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						for(int j = 1; j <= 7; j++) {
							if(((loc.column+j==realColumn&&loc.row==row)||(loc.column-j==realColumn&&loc.row==row)||(loc.column==realColumn&&loc.row-j==row)||(loc.column==realColumn&&loc.row+j==row))&&!validPieces.contains(pieces[realColumn][row])){
								boolean canMove = false;							 
								for(int k = 1; k < j; k++) {
									if(k==j-1||j==1) {
										canMove = true;
									} else
									if((loc.column+j==realColumn&&loc.row==row)&&(pieces[loc.column+k][loc.row]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row==row)&&(pieces[loc.column-k][loc.row]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row+j==row)&&(pieces[loc.column][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row-j==row)&&(pieces[loc.column][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} 
								}
								if(canMove||j==1) {
									pieces[loc.column][loc.row] = ' ';
									pieces[realColumn][row] = piece;
									if(King.isInCheck(pieces, whiteMoves)) {
										pieces[realColumn][row] = pieceAt;
										pieces[loc.column][loc.row] = piece;
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();
									}else if(King.isCheckMate(pieces, !whiteMoves)){
										if(whiteMoves) {System.out.println("Black wins"); }
										else {System.out.println("White wins!");}
									} else {
										piecePrinter.setPieces(pieces);
										piecePrinter.didTheMove();
										piecePrinter.printPieces();
										piecePrinter.askForNextMove();
										specialMoves.enpassant = false;
									}
								} else if(i == pieceLocations.size()-1) {
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();		
								}
							}  
						} 
					}
				} else if(piece == 'Q') {
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						for(int j = 1; j <= 7; j++) {
							if(((loc.column+j==realColumn&&loc.row==row)||(loc.column-j==realColumn&&loc.row==row)||(loc.column==realColumn&&loc.row-j==row)||(loc.column==realColumn&&loc.row+j==row)||(loc.column+j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row-j==row)||(loc.column+j==realColumn&&loc.row-j==row))&&!validPieces.contains(pieces[realColumn][row])){
								boolean canMove = false;							 
								for(int k = 1; k < j; k++) {
									if(k==j-1||j==1) {
										canMove = true;
									} else
									if((loc.column+j==realColumn&&loc.row==row)&&(pieces[loc.column+k][loc.row]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row==row)&&(pieces[loc.column-k][loc.row]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row+j==row)&&(pieces[loc.column][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row-j==row)&&(pieces[loc.column][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column+j==realColumn&&loc.row+j==row)&&(pieces[loc.column+k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column+j==realColumn&&loc.row-j==row)&&(pieces[loc.column+k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row+j==row)&&(pieces[loc.column-k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row-j==row)&&(pieces[loc.column-k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} 
								}
								if(canMove||j==1) {
									pieces[loc.column][loc.row] = ' ';
									pieces[realColumn][row] = piece;
									if(King.isInCheck(pieces, whiteMoves)) {
										pieces[realColumn][row] = pieceAt;
										pieces[loc.column][loc.row] = piece;
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();
									} else if(King.isCheckMate(pieces, !whiteMoves)){
										if(whiteMoves) {System.out.println("Black wins"); }
										else {System.out.println("White wins!");}
									} else {
										piecePrinter.setPieces(pieces);
										piecePrinter.didTheMove();
										piecePrinter.printPieces();
										piecePrinter.askForNextMove();
										specialMoves.enpassant = false;
									}
								} else if(i == pieceLocations.size()-1) {
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();		
								}
							}  
						} 
					}
	
				} else if(piece == 'K') {
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						for(int j = 1; j <= 7; j++) {
							if(((loc.column+1==realColumn&&loc.row==row)||(loc.column-1==realColumn&&loc.row==row)||(loc.column==realColumn&&loc.row-1==row)||(loc.column==realColumn&&loc.row+1==row)||(loc.column+1==realColumn&&loc.row+1==row)||(loc.column-1==realColumn&&loc.row+1==row)||(loc.column-1==realColumn&&loc.row-1==row)||(loc.column+1==realColumn&&loc.row-1==row))&&!validPieces.contains(pieces[realColumn][row])){
								pieces[loc.column][loc.row] = ' ';
								pieces[realColumn][row] = piece; 
								if(King.isInCheck(pieces, whiteMoves)) {
									pieces[realColumn][row] = pieceAt;
									pieces[loc.column][loc.row] = piece;
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();
								} else if(King.isCheckMate(pieces, !whiteMoves)){
									if(whiteMoves) {System.out.println("Black wins"); }
									else {System.out.println("White wins!");}
								} else {
									piecePrinter.setPieces(pieces);
									piecePrinter.didTheMove();
									piecePrinter.printPieces();
									piecePrinter.askForNextMove();
									specialMoves.enpassant = false;
								}
							} else if(i == pieceLocations.size()-1) {
								piecePrinter.printPieces();
								System.out.println("This is not a valid move!");
								piecePrinter.askForNextMove();		
							}
						}
					}
				} else {
					piecePrinter.printPieces();
					System.out.println("This is not a valid move!");
					piecePrinter.askForNextMove();
				}
			} 
			else {
				if(piece == 'n' ) {
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						if(((loc.row-1==row&&loc.column-2==realColumn)||(loc.row-2==row&&loc.column-1==realColumn)||(loc.row-2==row&&loc.column+1==realColumn)||(loc.row-1==row&&loc.column+2==realColumn)||(loc.row+2==row&&loc.column+1==realColumn)||(loc.row+2==row&&loc.column-1==realColumn)||(loc.row+1==row&&loc.column-2==realColumn))&&!validPieces.contains(pieces[realColumn][row])) {
							pieces[loc.column][loc.row] = ' ';
							pieces[realColumn][row] = piece;
							if(King.isInCheck(pieces, whiteMoves)) {
								pieces[realColumn][row] = pieceAt;
								pieces[loc.column][loc.row] = piece;
								piecePrinter.printPieces();
								System.out.println("This is not a valid move!");
								piecePrinter.askForNextMove();
							} else if(King.isCheckMate(pieces, !whiteMoves)){
								if(whiteMoves) {System.out.println("Black wins"); }
								else {System.out.println("White wins!");}
							} else {
								piecePrinter.setPieces(pieces);
								piecePrinter.didTheMove();
								piecePrinter.printPieces();
								piecePrinter.askForNextMove();
								specialMoves.enpassant = false;
							}
						} else if(i == pieceLocations.size()-1) {
							piecePrinter.printPieces();
							System.out.println("This is not a valid move!");
							piecePrinter.askForNextMove();					
						}
					}
				} else if(piece == 'p') {
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						if(((loc.row-1==row&&loc.column==realColumn&&pieces[realColumn][row]==' ')||(loc.row-2==row&&loc.column==realColumn&&pieces[realColumn][row]==' ')&&loc.row==6||(loc.row-1==row&&loc.column+1==realColumn&&pieces[realColumn][row]!=' ')||(loc.row-1==row&&loc.column-1==realColumn&&pieces[realColumn][row]!=' '))&&!validBlackPieces.contains(pieces[realColumn][row])) {
							pieces[loc.column][loc.row] = ' ';
							pieces[realColumn][row] = piece;
							if(King.isInCheck(pieces, whiteMoves)) {
								pieces[realColumn][row] = pieceAt;
								pieces[loc.column][loc.row] = piece;
								piecePrinter.printPieces();
								System.out.println("This is not a valid move!");
								piecePrinter.askForNextMove();
							} else if(King.isCheckMate(pieces, !whiteMoves)){
								if(whiteMoves) {System.out.println("Black wins"); }
								else {System.out.println("White wins!");}
							} else {
								if(loc.row==6&&row==loc.row-2) {
									specialMoves.setEnpassantLoc(new Location(loc.column,loc.row-1));
									specialMoves.enpassantable(true);
								}  else {
									specialMoves.setEnpassantLoc(new Location(0,0));
									specialMoves.enpassantable(false);
								}
								if(row == 0){
									 System.out.println("What piece will you promote to?");
									 boolean goodAnswer = false;
									 Scanner scan = new Scanner(System.in);
									while(!goodAnswer) {
										String promotion = scan.next();
										if(validPieces.contains(Character.toUpperCase(promotion.charAt(0)))) {
											pieces[realColumn][row] = Character.toLowerCase(promotion.charAt(0));
											goodAnswer = true;
										} else {
											System.out.println("That is not a valid piece!");
										}
									}
									scan.close();
								}
								piecePrinter.setPieces(pieces);
								piecePrinter.didTheMove();
								piecePrinter.printPieces();
								piecePrinter.askForNextMove();
							}	
						} else if(specialMoves.enpassant&&(loc.column+1==realColumn||loc.column-1==realColumn)&&loc.row-1==row&&realColumn==specialMoves.enpassantLocation.column&&row==specialMoves.enpassantLocation.row&&pieces[realColumn][row]==' ') {
							pieces[loc.column][loc.row] = ' ';
							pieces[specialMoves.enpassantLocation.column][specialMoves.enpassantLocation.row+1] = ' ';
							pieces[realColumn][row] = piece;
							if(King.isInCheck(pieces, whiteMoves)) {
								pieces[realColumn][row] = pieceAt;
								pieces[loc.column][loc.row] = piece;
								pieces[specialMoves.enpassantLocation.column][specialMoves.enpassantLocation.row+1] = 'P';
								piecePrinter.printPieces();
								System.out.println("This is not a valid move!");
								piecePrinter.askForNextMove();
							} else if(King.isCheckMate(pieces, !whiteMoves)){
								if(whiteMoves) {System.out.println("Black wins"); }
								else {System.out.println("White wins!");}
							} else {
								piecePrinter.setPieces(pieces);
								piecePrinter.didTheMove();
								piecePrinter.printPieces();
								piecePrinter.askForNextMove();
								specialMoves.enpassant = false;
								specialMoves.setEnpassantLoc(new Location(0,0));
								specialMoves.enpassantable(false);
							}
							
						} else if(i == pieceLocations.size()-1) {
							piecePrinter.printPieces();
							System.out.println("This is not a valid move!");
							piecePrinter.askForNextMove();					
						}
					}
					
				} else if(piece == 'b'){
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						for(int j = 1; j <= 7; j++) {
							if(((loc.column+j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row-j==row)||(loc.column+j==realColumn&&loc.row-j==row))&&!validBlackPieces.contains(pieces[realColumn][row])){
								boolean canMove = false;							 
								for(int k = 1; k < j; k++) {
									if(k==j-1||j==1) {
										canMove=true;
									} else
									if((loc.column+j==realColumn&&loc.row+j==row)&&(pieces[loc.column+k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column+j==realColumn&&loc.row-j==row)&&(pieces[loc.column+k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row+j==row)&&(pieces[loc.column-k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row-j==row)&&(pieces[loc.column-k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} 
								}
								if(canMove||j==1) {
									pieces[loc.column][loc.row] = ' ';
									pieces[realColumn][row] = piece;
									if(King.isInCheck(pieces, whiteMoves)) {
										pieces[realColumn][row] = pieceAt;
										pieces[loc.column][loc.row] = piece;
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();
									} else if(King.isCheckMate(pieces, !whiteMoves)){
										if(whiteMoves) {System.out.println("Black wins"); }
										else {System.out.println("White wins!");}
									} else {
										piecePrinter.setPieces(pieces);
										piecePrinter.didTheMove();
										piecePrinter.printPieces();
										piecePrinter.askForNextMove();
										specialMoves.enpassant = false;
									}
								} 
								else if(i == pieceLocations.size()-1) {
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();		
								}
							}  
						} 
					}
	
				} else if(piece == 'r') {
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						for(int j = 1; j <= 7; j++) {
							if(((loc.column+j==realColumn&&loc.row==row)||(loc.column-j==realColumn&&loc.row==row)||(loc.column==realColumn&&loc.row-j==row)||(loc.column==realColumn&&loc.row+j==row))&&!validBlackPieces.contains(pieces[realColumn][row])){
								boolean canMove = false;							 
								for(int k = 1; k < j; k++) {
									if(k==j-1||j==1) {
										canMove = true;
									} else
									if((loc.column+j==realColumn&&loc.row==row)&&(pieces[loc.column+k][loc.row]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row==row)&&(pieces[loc.column-k][loc.row]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row+j==row)&&(pieces[loc.column][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row-j==row)&&(pieces[loc.column][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} 
								}
								if(canMove||j==1) {
									pieces[loc.column][loc.row] = ' ';
									pieces[realColumn][row] = piece;
									if(King.isInCheck(pieces, whiteMoves)) {
										pieces[realColumn][row] = pieceAt;
										pieces[loc.column][loc.row] = piece;
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();
									} else if(King.isCheckMate(pieces, !whiteMoves)){
										if(whiteMoves) {System.out.println("Black wins"); }
										else {System.out.println("White wins!");}
									} else {
										piecePrinter.setPieces(pieces);
										piecePrinter.didTheMove();
										piecePrinter.printPieces();
										piecePrinter.askForNextMove();
										specialMoves.enpassant = false;
									}
								} else if(i == pieceLocations.size()-1) {
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();		
								}
							}  
						} 
					}
	
				} else if(piece == 'q') {
					for(int i = 0; i < pieceLocations.size(); i++) {
						Location loc = pieceLocations.get(i);
						for(int j = 1; j <= 7; j++) {
							if(((loc.column+j==realColumn&&loc.row==row)||(loc.column-j==realColumn&&loc.row==row)||(loc.column==realColumn&&loc.row-j==row)||(loc.column==realColumn&&loc.row+j==row)||(loc.column+j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row+j==row)||(loc.column-j==realColumn&&loc.row-j==row)||(loc.column+j==realColumn&&loc.row-j==row))&&!validBlackPieces.contains(pieces[realColumn][row])){
								boolean canMove = false;							 
								for(int k = 1; k < j; k++) {
									if(k==j-1||j==1) {
										canMove = true;
									} else
									if((loc.column+j==realColumn&&loc.row==row)&&(pieces[loc.column+k][loc.row]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row==row)&&(pieces[loc.column-k][loc.row]!=' ')) {
											piecePrinter.printPieces();
											System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row+j==row)&&(pieces[loc.column][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column==realColumn&&loc.row-j==row)&&(pieces[loc.column][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column+j==realColumn&&loc.row+j==row)&&(pieces[loc.column+k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column+j==realColumn&&loc.row-j==row)&&(pieces[loc.column+k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row+j==row)&&(pieces[loc.column-k][loc.row+k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} else if((loc.column-j==realColumn&&loc.row-j==row)&&(pieces[loc.column-k][loc.row-k]!=' ')) {
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();	
									} 
								}
								if(canMove||j==1) {
									pieces[loc.column][loc.row] = ' ';
									pieces[realColumn][row] = piece;
									if(King.isInCheck(pieces, whiteMoves)) {
										pieces[realColumn][row] = pieceAt;
										pieces[loc.column][loc.row] = piece;
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();
									} else if(King.isCheckMate(pieces, !whiteMoves)){
										piecePrinter.setPieces(pieces);
										piecePrinter.printPieces();
										if(!whiteMoves) {System.out.println("Black wins!"); }
										else {System.out.println("White wins!");}
										System.out.println(whiteMoves);
										return; 
									} else {
										piecePrinter.setPieces(pieces);
										piecePrinter.didTheMove();
										piecePrinter.printPieces();
										piecePrinter.askForNextMove();
										specialMoves.enpassant = false;
									}
								} else if(i == pieceLocations.size()-1) {
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();		
								}
							}  
						} 
					}
				}else if(piece == 'k') {
						for(int i = 0; i < pieceLocations.size(); i++) {
							Location loc = pieceLocations.get(i);
							for(int j = 1; j <= 7; j++) {
								if(((loc.column+1==realColumn&&loc.row==row)||(loc.column-1==realColumn&&loc.row==row)||(loc.column==realColumn&&loc.row-1==row)||(loc.column==realColumn&&loc.row+1==row)||(loc.column+1==realColumn&&loc.row+1==row)||(loc.column-1==realColumn&&loc.row+1==row)||(loc.column-1==realColumn&&loc.row-1==row)||(loc.column+1==realColumn&&loc.row-1==row))&&!validPieces.contains(pieces[realColumn][row])){
									pieces[loc.column][loc.row] = ' ';
									pieces[realColumn][row] = piece; 
									if(King.isInCheck(pieces, whiteMoves)) {
										pieces[realColumn][row] = pieceAt;
										pieces[loc.column][loc.row] = piece;
										piecePrinter.printPieces();
										System.out.println("This is not a valid move!");
										piecePrinter.askForNextMove();
									} else if(King.isCheckMate(pieces, !whiteMoves)){
										if(whiteMoves) {System.out.println("Black wins"); }
										else {System.out.println("White wins!");}
									} else {
										piecePrinter.setPieces(pieces);
										piecePrinter.didTheMove();
										piecePrinter.printPieces();
										piecePrinter.askForNextMove();
										specialMoves.enpassant = false;
									}
								} else if(i == pieceLocations.size()-1) {
									piecePrinter.printPieces();
									System.out.println("This is not a valid move!");
									piecePrinter.askForNextMove();		
								}
							}
						}
				} else {
					piecePrinter.printPieces();
					System.out.println("This is not a valid move!");
					piecePrinter.askForNextMove();
				}
			}
		System.out.println("Piece: " + pieces[6][3]);
	} 
}
