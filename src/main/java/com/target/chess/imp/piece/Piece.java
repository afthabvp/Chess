package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Point;

public abstract class Piece {

	
	Point point;
	private Color color;

	public Piece(Color color, Point p) {
		super();
		this.color = color;
		this.point = p;
	}


	


	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}





	/**
	 * @param point the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}





	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}





	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}





	public boolean isValid(Board board, Point p_to){
		//no move
		if(this.getPoint().getX() == p_to.getX() &&  this.getPoint().getY() == p_to.getY())
			return false; 
		if(this.getPoint().getX() < 0 || this.getPoint().getX() > 7 
				|| this.getPoint().getY() < 0 || this.getPoint().getY() > 7 
				|| p_to.getX() < 0 || p_to.getX() > 7 
				|| p_to.getY() <0 || p_to.getY() > 7){
			return false;
		}
		if(board.hasPiece(p_to.getX(), p_to.getY())){
			if(board.getSquare(p_to.getX(), p_to.getX()).getColor() == getColor()){
				return false;
			}
		}
		return true;
	}

	
	public abstract String getType();



}