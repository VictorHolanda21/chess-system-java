package chess;

import boardgame.Position;

public class ChessPosition {

	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if(column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return this.column;
	}

	public int getRow() {
		return this.row;
	}
	
	protected Position toPosition() {
		return new Position(8 - this.row, this.column - 'a');
	}
	
	protected static ChessPosition fromPosition(Position pos) {
		return new ChessPosition(
					(char)('a' + pos.getColumn()),
					8 - pos.getRow()
				);
	}
	
	@Override
	public String toString() {
		return "" + this.column + this.row;
	}
}
