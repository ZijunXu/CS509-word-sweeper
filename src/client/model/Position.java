package client.model;
/**
 * 
 * responsible for the position entity
 *
 */
public class Position {
	public int row;
	public int column;
	
	/** row and column are the player's position of the global board */
	public Position(int column, int row){
		this.column = column;
		this.row = row;
	}
}
