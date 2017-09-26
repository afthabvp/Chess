package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Pieces;
import com.target.chess.imp.game.Point;

public class Bishop extends Piece{

	public Bishop(Color color, Point p) {
		super(color, p);
	}

	@Override
	public boolean isValid(Board board, Point p_to){
		if(super.isValid(board, p_to) == false)
			return false;

		if(Math.abs(p_to.getX() - super.getPoint().getX()) == Math.abs(p_to.getY() - super.getPoint().getY()) && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getY() >= 0 && p_to.getY() <= 7)){ //case that it moved in the correct pattern
			if(p_to.getX() - super.getPoint().getX() > 0 && p_to.getY() - super.getPoint().getY() > 0){ //checks if moved to the right and down, iterates through board,
				for(int i= 1; i< p_to.getX()-super.getPoint().getX(); i++){   // finds if there are any pieces in the way
					if(board.hasPiece(super.getPoint().getX() + i,super.getPoint().getY() + i)){
						return false;
					}
				}
				return true;
			}
			if(p_to.getX() - super.getPoint().getX() < 0 && p_to.getY() - super.getPoint().getY() < 0){ //checks if it moved left and up
				for(int i = 1; i< super.getPoint().getX() - p_to.getX(); i++){
					if(board.hasPiece(p_to.getX() + i, p_to.getY() + i)){
						return false;
					}
				}
				return true;
			}
			if(((p_to.getX() - super.getPoint().getX()) > 0) && ((p_to.getY() - super.getPoint().getY()) < 0)){ //checked if it moved right and up
				for(int i = 1; i< p_to.getX() - super.getPoint().getX(); i++){
					if(board.hasPiece(super.getPoint().getX() + i, super.getPoint().getY() - i)){
						return false;
					}
				}

				return true;
			}
			if(p_to.getX() - super.getPoint().getX() < 0 && p_to.getY() - super.getPoint().getY() > 0){ //checks if it moved left and down
				for(int i = 1; i< Math.abs(p_to.getX() - super.getPoint().getX()); i++){
					if(board.hasPiece(super.getPoint().getX() -i, super.getPoint().getY() + i)){
						return false;
					}
				}
				return true;
			}
			return true;
		}
		return false; 

	}

	@Override
	public String getType() {
		return Pieces.Bishop.getValue();
	}



}