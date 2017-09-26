package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Pieces;
import com.target.chess.imp.game.Point;

public class Knight extends Piece{

    public Knight(Color color, Point p) {
		super(color, p);
	}

	@Override
	public boolean isValid(Board board, Point p_to){
		if(super.isValid(board, p_to) == false)
			return false;       

		if(Math.abs(p_to.getX() - super.getPoint().getX()) == 2 && Math.abs(p_to.getY() - super.getPoint().getY()) == 1 && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getY() >= 0 && p_to.getY() <= 7)){

			return true;
		}else if(Math.abs(p_to.getX() -super.getPoint().getX()) == 1 && Math.abs(p_to.getY() - super.getPoint().getY()) == 2 && (p_to.getX() >= 0 && p_to.getX() <= 7) && (p_to.getY() >= 0 && p_to.getY() <= 7)){

			return true;
		}else{
			return false;
		}
    }

	@Override
	public String getType() {
		return Pieces.Knight.getValue();
	}

}