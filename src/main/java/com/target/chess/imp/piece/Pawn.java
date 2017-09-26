package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Pieces;
import com.target.chess.imp.game.Point;

public class Pawn extends Piece {
	
	
	public Pawn(Color color, Point p) {
		super(color, p);
	}
	
	
	@Override
	public boolean isValid(Board b, Point p_to){
		if(super.isValid(b, p_to) == false)
			return false;  
		if(super.getColor() == Color.BLACK){ //case that pawn is white
			if(this.getPoint().getX() == 6){  //case that pawn is in original position
				//allows pawn to move two spaces ahead as long as there is no space in between
				if(Math.abs(p_to.getY() - this.getPoint().getY()) == 1 && p_to.getX() == this.getPoint().getX() -1 &&  b.hasPiece(p_to.getX(), p_to.getY())){
					return true;
				}else if(p_to.getY() == this.getPoint().getY() && p_to.getX() == this.getPoint().getX() -1 && ! b.hasPiece(p_to.getX(), p_to.getY())){
					return true;
				}else if(p_to.getY() == this.getPoint().getY() && p_to.getX() == this.getPoint().getX() - 2 && ! b.hasPiece(p_to.getX(), p_to.getY())){
					return true;
				}
				return false;
			}else{//case pawn is nt in original position
				//check if pawn is capturing another piece
				if(Math.abs(p_to.getY() - this.getPoint().getY()) == 1 && p_to.getX() == this.getPoint().getX() -1 &&  b.hasPiece(p_to.getX(), p_to.getY())){ 
					return true;
				//check that pawn is moving forward one square
				}else if(p_to.getY() == this.getPoint().getY() && p_to.getX() == this.getPoint().getX() -1 && ! b.hasPiece(p_to.getX(), p_to.getY())){
					return true;
				}
				return false;
			}
		}else{//case that pawn is black, repeat same rules as for white
			if(this.getPoint().getX() == 1){
				if(Math.abs(p_to.getY() - this.getPoint().getY()) == 1 && p_to.getX() == this.getPoint().getX() +1 && b.hasPiece(p_to.getX(), p_to.getY())){
					//System.out.println("Legal move: " + getType()  + " from: (" + this.getPoint().getY() + "," + this.getPoint().getX() + ") to (" + p_to.getY() + "," + p_to.getX() + ")");

					return true;
				}else if(p_to.getY() == this.getPoint().getY() && p_to.getX() == this.getPoint().getX() +1 && ! b.hasPiece(p_to.getX(), p_to.getY())){
					//System.out.println("Legal move: " + getType()  + " from: (" + this.getPoint().getY() + "," + this.getPoint().getX() + ") to (" + p_to.getY() + "," + p_to.getX() + ")");

					return true;
				}else if(p_to.getY() == this.getPoint().getY() && p_to.getX() == this.getPoint().getX() + 2 && ! b.hasPiece(p_to.getX(), p_to.getY())){
					//System.out.println("Legal move: " + getType()  + " from: (" + this.getPoint().getY() + "," + this.getPoint().getX() + ") to (" + p_to.getY() + "," + p_to.getX() + ")");

					return true;
				}
				return false;
			}else{//case pawn is nt in original position
				if(Math.abs(p_to.getY() - this.getPoint().getY()) == 1 && p_to.getX() == this.getPoint().getX() +1 &&  b.hasPiece(p_to.getX(), p_to.getY())){
					//System.out.println("Legal move: " + getType()  + " from: (" + this.getPoint().getY() + "," + this.getPoint().getX() + ") to (" + p_to.getY() + "," + p_to.getX() + ")");

					return true;
				}else if(p_to.getY() == this.getPoint().getY() && p_to.getX() == this.getPoint().getX() +1 && ! b.hasPiece(p_to.getX(), p_to.getY())){
					//System.out.println("Legal move: " + getType()  + " from: (" + this.getPoint().getY() + "," + this.getPoint().getX() + ") to (" + p_to.getY() + "," + p_to.getX() + ")");

					return true;
				}
				return false;
			}
		}
	}


	@Override
	public String getType() {
		return Pieces.Pawn.getValue();
	}


}