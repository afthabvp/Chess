package com.target.chess.imp.game;

import java.util.ArrayList;
import java.util.List;

import com.target.chess.imp.parser.StringCommandParser;
import com.target.chess.imp.piece.Board;
import com.target.chess.imp.piece.Piece;

public class Source {
	public static final int PAWN_ONLY = 2;
	public static final int PAWN_OTHR = 3;
	public static final int OTHR_CONFLICT = 4;




	public static Piece find_source(Board board,Command cmd,Color color){
		List<Piece> temp_list  = new ArrayList<Piece>() ;
		Piece piece = null;
		int x2 = cmd.getTo().getX();
		int y2 = cmd.getTo().getY();
		switch (cmd.getPiece()) {
		case "Pawn":

			if(color.equals(Color.WHITE)){
				int[][] offsets = {
						{-1, 1},
						{-2, 0},
						{-1, 0},
						{-1, -1}
				};
				for (int[] o : offsets) {
					try{
						int temp_x = x2+o[0];
						int temp_y = y2+o[1];
						temp_list.add(board.getSquare(temp_x,temp_y));
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
			}else{
				int[][] offsets = {
						{2, 0},
						{1, 0},
						{1, 1},
						{1, -1}
				};
				for (int[] o : offsets) {
					try{
						int temp_x = x2+o[0];
						int temp_y = y2+o[1];
						temp_list.add(board.getSquare(temp_x,temp_y));
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
			}

			if(cmd.getCmd().length() == PAWN_ONLY){
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Pawn.getValue())){
						return p;
					}
				}

			}else if(cmd.getCmd().length() == PAWN_OTHR){
				int y = StringCommandParser.getMap().get(cmd.getCmd().charAt(0));
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Pawn.getValue()) && p.getPoint().getY() == y){
						return p;
					}
				}
			}
			break;
		case "Rook":
			for(int x = 0; x<8; x++){
				temp_list.add(board.getSquare(x, y2));
			}
			for(int y = 0; y<8; y++){
				temp_list.add(board.getSquare(x2, y));
			}
			if(cmd.getCmd().length() == PAWN_OTHR){
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Pawn.getValue()) && p.getColor().getValue() == color.getValue() ){
						return p;
					}
				}
			}else if(cmd.getCmd().length() == OTHR_CONFLICT){
				int y = StringCommandParser.getMap().get(cmd.getCmd().charAt(0));
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Pawn.getValue()) && p.getPoint().getY() == y){
						return p;
					}
				}
			}

			break;
		case "Knight":
			int[][] offsets = {
					{-2, 1},
					{-1, 2},
					{1, 2},
					{2, 1},
					{2, -1},
					{1, -2},
					{-1, -2},
					{-2, -1}
			};
			for (int[] o : offsets) {
				try{
					int temp_x = x2+o[0];
					int temp_y = y2+o[1];
					temp_list.add(board.getSquare(temp_x,temp_y));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			if(cmd.getCmd().length() == PAWN_OTHR){
				for (Piece p : temp_list){
					if(p != null && p.getType().equalsIgnoreCase(Pieces.Knight.getValue()) && p.getColor().getValue() == color.getValue() ){
						return p;
					}
				}
			}else if(cmd.getCmd().length() == OTHR_CONFLICT){
				int y = StringCommandParser.getMap().get(cmd.getCmd().charAt(1));
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Knight.getValue()) && p.getPoint().getY() == y){
						return p;
					}
				}
			}

			break;
		case "Bishop":
			//all possible moves in the down positive diagonal
			for (int j = y2 + 1, i = x2 + 1; j < 8 && i < 8; j++, i++) {
				temp_list.add(board.getSquare(i, j));
			}
			//all possible moves in the up positive diagonal
			for (int j = y2 - 1, i = x2 + 1; j > -1 && i < 8; j--, i++) {
				temp_list.add(board.getSquare(i, j));
			}
			for (int j = y2 - 1, i = x2 - 1; j > -1 && i > -1; j--, i--) {
				temp_list.add(board.getSquare(i, j));
			}
			//all possible moves in the down negative diagonal
			for (int j = y2 + 1, i = x2 - 1; j < 8 && i > -1; j++, i--) {
				temp_list.add(board.getSquare(i, j));
			}
			if(cmd.getCmd().length() == PAWN_OTHR){
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Bishop.getValue()) && p.getColor().getValue() == color.getValue() ){
						return p;
					}
				}
			}else if(cmd.getCmd().length() == OTHR_CONFLICT){
				int y = StringCommandParser.getMap().get(cmd.getCmd().charAt(1));
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Bishop.getValue()) && p.getPoint().getY() == y){
						return p;
					}
				}
			}

			break;
		case "King":

			temp_list.add(board.getSquare(x2, y2+1));
			temp_list.add(board.getSquare(x2, y2-1));
			temp_list.add(board.getSquare(x2+1, y2));
			temp_list.add(board.getSquare(x2-1, y2));
			temp_list.add(board.getSquare(x2+1, y2+1));
			temp_list.add(board.getSquare(x2-1, y2-1));
			temp_list.add(board.getSquare(x2-1, y2+1));
			temp_list.add(board.getSquare(x2+1, y2-1));
			if(cmd.getCmd().length() == PAWN_OTHR){
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.King.getValue()) && p.getColor().getValue() == color.getValue() ){
						return p;
					}
				}
			}else if(cmd.getCmd().length() == OTHR_CONFLICT){
				int y = StringCommandParser.getMap().get(cmd.getCmd().charAt(1));
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.King.getValue()) && p.getPoint().getY() == y){
						return p;
					}
				}
			}
			break;
		case "Queen":
			//all possible moves in the down positive diagonal
			for (int j = y2 + 1, i = x2 + 1; j < 8 && i < 8; j++, i++) {
				temp_list.add(board.getSquare(i, j));
			}
			//all possible moves in the up positive diagonal
			for (int j = y2 - 1, i = x2 + 1; j > -1 && i < 8; j--, i++) {
				temp_list.add(board.getSquare(i, j));
			}
			for (int j = y2 - 1, i = x2 - 1; j > -1 && i > -1; j--, i--) {
				temp_list.add(board.getSquare(i, j));
			}
			//all possible moves in the down negative diagonal
			for (int j = y2 + 1, i = x2 - 1; j < 8 && i > -1; j++, i--) {
				temp_list.add(board.getSquare(i, j));
			}

			for(int x = 0; x<8; x++){
				temp_list.add(board.getSquare(x, y2));
			}
			for(int y = 0; y<8; y++){
				temp_list.add(board.getSquare(x2, y));
			}
			if(cmd.getCmd().length() == PAWN_OTHR){
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Queen.getValue()) && p.getColor().getValue() == color.getValue() ){
						return p;
					}
				}
			}else if(cmd.getCmd().length() == OTHR_CONFLICT){
				int y = StringCommandParser.getMap().get(cmd.getCmd().charAt(1));
				for (Piece p : temp_list){
					if(p!= null && p.getType().equalsIgnoreCase(Pieces.Queen.getValue()) && p.getPoint().getY() == y){
						return p;
					}
				}
			}
			break;

		default:
			break;
		}


		return piece;
	}


}
