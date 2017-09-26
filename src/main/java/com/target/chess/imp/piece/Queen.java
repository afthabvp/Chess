package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Pieces;
import com.target.chess.imp.game.Point;

public class Queen extends Piece {


	public Queen(Color color, Point p) {
		super(color, p);
	}

	@Override
	public boolean isValid(Board board, Point p_to){
		if(super.isValid(board, p_to) == false)
			return false;        
		if((super.getPoint().getX() == p_to.getX()) && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getY() >= 0 && p_to.getY() <= 7)){
			/*
			 * For all possible patterns of movement, the Queen iterates through the board to check
			 * if there are any pieces in the way in that direction
			 */
			if(p_to.getY() > super.getPoint().getY()){
				for(int i = 1; i< p_to.getY()-super.getPoint().getY(); i++){ 
					if(board.hasPiece(super.getPoint().getX(), super.getPoint().getY() + i)){ 
						return false;
					}
				}
				return true;
			}
			if(p_to.getY() < super.getPoint().getY()){
				for(int i= 1; i<super.getPoint().getY() - p_to.getY(); i++){
					if(board.hasPiece(super.getPoint().getX(), p_to.getY() + i)){
						return false;
					}
				}
				return true;
			}
			if(p_to.getY() == super.getPoint().getY()){
				return true;
			}
			return true;
		}
		if((super.getPoint().getY() == p_to.getY()) && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getY() >= 0 && p_to.getY() <= 7)){
			if(p_to.getX() > super.getPoint().getX()){
				for(int i = 1; i<p_to.getX()-super.getPoint().getX(); i++){
					if(board.hasPiece(super.getPoint().getX() + i, super.getPoint().getY())){
						return false;
					}
				}
				return true;
			}
			
			if(p_to.getX() < super.getPoint().getX()){
				for(int i = 1; i<super.getPoint().getX()-p_to.getX(); i++){
					if(board.hasPiece(p_to.getX() + i, super.getPoint().getY())){
						return false;
					}
				}
				return true;
			}
			if(p_to.getX() == super.getPoint().getX()){
				return true;
			}
		}
		if(Math.abs(p_to.getX() - super.getPoint().getX()) == Math.abs(p_to.getY() - super.getPoint().getY()) && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getY() >= 0 && p_to.getY() <= 7)){
			if(p_to.getX() - super.getPoint().getX() > 0 && p_to.getY() - super.getPoint().getY() > 0){
				for(int i= 1; i< p_to.getX()-super.getPoint().getX(); i++){
					if(board.hasPiece(super.getPoint().getX() + i,super.getPoint().getY() + i)){
						return false;
					}
				}
				return true;
			}
			if(p_to.getX() - super.getPoint().getX() < 0 && p_to.getY() - super.getPoint().getY() < 0){
				for(int i = 1; i< super.getPoint().getX() - p_to.getX(); i++){
					if(board.hasPiece(p_to.getX() + i, p_to.getY() + i)){
						return false;
					}
				}
				return true;
			}
			if(((p_to.getX() - super.getPoint().getX()) > 0) && ((p_to.getY() - super.getPoint().getY()) < 0)){
				for(int i = 1; i< p_to.getX() - super.getPoint().getX(); i++){
					if(board.hasPiece(super.getPoint().getX() + i, super.getPoint().getY() - i)){
						return false;
					}
				}
				return true;
			}
			if(p_to.getX() - super.getPoint().getX() < 0 && p_to.getY() - super.getPoint().getY() > 0){
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
		return Pieces.Queen.getValue();
	}
}