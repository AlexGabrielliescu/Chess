
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
