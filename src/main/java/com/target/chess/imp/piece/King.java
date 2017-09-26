package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Pieces;
import com.target.chess.imp.game.Point;

public class King extends Piece{

    public King(Color color, Point p) {
		super(color, p);
	}

	@Override
	public boolean isValid(Board board, Point p_to){
		if(super.isValid(board, p_to) == false)
			return false;        
		if(Math.abs(p_to.getX() - super.getPoint().getX()) <= 1 && Math.abs(p_to.getX() - super.getPoint().getY()) <=1 && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getX() >= 0 && p_to.getX() <= 7)){
			return true;
		}
		/*
		 * Allow for castling
		 */							
		if(super.getColor() == Color.BLACK){ //case that piece is black
			if(board.hasPiece(7, 7)){
				if(board.getSquare(7,7).getType().equals(Pieces.Rook.getValue())){ //checks if there is rook in correct position
					if(super.getPoint().getX() == 4 && super.getPoint().getY() == 7 && p_to.getX() == 6 && p_to.getX() ==7){
						if(!board.hasPiece(5, 7) && !board.hasPiece(6,7)){ //checks if proper castling rules followed
							board.setBlackCastled(true);
							return true;
						}
					}
				}
			}
			//applies same reasoning to a black king, hardcoded positions for rook and king used
		}else if(super.getColor() == Color.WHITE){ //case that piece is black
			if(board.hasPiece(7, 0)){
				if(board.getSquare(7, 0).getType().equals(Pieces.Rook.getValue())){
					if(super.getPoint().getX() == 4 && super.getPoint().getY() == 0 && p_to.getX() == 6 && p_to.getX() ==0){
						if(!board.hasPiece(5, 0) && !board.hasPiece(6,0)){
							board.setWhiteCastled(true);
							return true;
						}
					}
				}
			}
		}
		return false;
    }

	@Override
	public String getType() {
		return Pieces.King.getValue();
	}

}