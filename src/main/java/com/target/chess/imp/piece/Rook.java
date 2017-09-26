package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Pieces;
import com.target.chess.imp.game.Point;

public class Rook extends Piece{

    public Rook(Color color, Point p) {
		super(color, p);
	}

	@Override
	public boolean isValid(Board board, Point p_to){
		if(super.isValid(board, p_to) == false)
			return false;
		if(board.hasPiece(p_to.getX(), p_to.getY())){
			if(board.getSquare(p_to.getX(), p_to.getX()).getColor() == super.getColor()){
				return false;
			}
		}
		if((super.getPoint().getX() == p_to.getX()) && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getY() >= 0 && p_to.getY() <= 7)){
			if(p_to.getY() > super.getPoint().getY()){ //checks if there are any pieces in the way if the rook is moving down
				for(int i = 1; i< p_to.getY()-super.getPoint().getY(); i++){ //iterates through board to check for pieces
					if(board.hasPiece(super.getPoint().getX(), super.getPoint().getY() + i)){
						return false;
					}
				}
				return true;
			}
			if(p_to.getY() < super.getPoint().getY()){ //checks if there are pieces in the way if the rook moves up
				for(int i= 1; i<super.getPoint().getY() - p_to.getY(); i++){ //iterates through board, checks for pieces
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
			if(p_to.getX() > super.getPoint().getX()){ //checks if there are pieces in the way if rook moves right
				for(int i = 1; i<p_to.getX()-super.getPoint().getX(); i++){ //iterates through board checking for pieces
					if(board.hasPiece(super.getPoint().getX() + i, super.getPoint().getY())){
						return false;
					}
				}
				return true;
			}
			
			if(p_to.getX() < super.getPoint().getX()){ //checks if there are pieces in teh way if the rook moves left
				for(int i = 1; i<super.getPoint().getX()-p_to.getX(); i++){ //iterates through board
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
		return false;
	}
  

	@Override
	public String getType() {
		return Pieces.Rook.getValue();
	}
}