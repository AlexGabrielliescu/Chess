
public class specialMoves {
	static boolean enpassant;
	static Location enpassantLocation = new Location(0,0);
	static Location enpassantPiece = new Location(0,0);
	public static void enpassantable(boolean bool) {
		enpassant = bool;
	}
	public static void setEnpassantLoc(Location loc) {
		enpassantLocation = loc;
	}
}
//specialMoves.enpassant&&(loc.column+1==realColumn||loc.column-1==realColumn)&&loc.row+1==row&&realColumn==specialMoves.enpassantLocation.column&&row==specialMoves.enpassantLocation.row&&pieces[realColumn][row]==' '
//specialMoves.enpassant&&(loc.column+1==realColumn||loc.column-1==realColumn)&&loc.row-1==row&&realColumn==specialMoves.enpassantLocation.column&&row==specialMoves.enpassantLocation.row&&pieces[realColumn][row]==' '