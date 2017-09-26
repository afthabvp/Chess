package com.target.chess.imp.fen;

import java.util.Map;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Pieces;
import com.target.chess.imp.parser.StringCommandParser;
import com.target.chess.imp.piece.Board;

public class FenMarsheller {

	public static String Fen( Board board)
	{

		String output = makeBoardFen(board);

		if (board.getPlayer() == Color.WHITE.getValue()){
			output += " b ";
		}else{
			output += " w ";
		}

		output = makeCastledFen(board,output);
		output = buildEnPassantTarget(board,output);
		output += board.getHalf_move() + " ";
		output += board.getFull_move() + 1;
		return output.trim();
	}

	private static String makeCastledFen(Board board, String output) {

		if (board.isWhiteCastled() == false){
			if (board.getSquare(0, 4) != null){
				if (board.getSquare(0, 4).getType().equals(Pieces.King.getValue()) && board.getSquare(0, 7).getType().equals(Pieces.Rook.getValue())){
					output += Pieces.King.getValue();
				}
				if (board.getSquare(0, 4).getType().equals(Pieces.King.getValue()) && board.getSquare(0, 0).getType().equals(Pieces.Rook.getValue())){
					output += Pieces.Queen.getValue();
				}
			}
		}

		if (board.isBlackCastled() == false){
			if (board.getSquare(7,4).getType().equals(Pieces.King.getValue()) && board.getSquare(7, 7).getType().equals(Pieces.Rook.getValue())){
				output += Pieces.King.getValue().toLowerCase();
			}
			if (board.getSquare(7,4).getType().equals(Pieces.King.getValue()) && board.getSquare(7, 0).getType().equals(Pieces.Rook.getValue())){
				output += Pieces.Queen.getValue().toLowerCase();
			}

		}
		return output;
	}

	private static String makeBoardFen(Board board) {
		String output = "";
		int blank = 0;
		for (int i = 0; i < 8; i++){
			for(int j =0 ;j<8;j++){
				if (board.getSquare(i, j) != null){
					if (blank > 0){
						output += blank;
						blank = 0;
					}if (board.getSquare(i,j).getColor() == Color.BLACK){
						output += board.getSquare(i,j).getType().toLowerCase();
					}
					else{
						output += board.getSquare(i,j).getType().toUpperCase();
					}
				}else{
					blank++;
				}

				if (j == 7){
					if (blank > 0){
						output += blank;
						output += "/";
						blank = 0;
					}else{
						output += "/";
					}
				}
			}
		}
		StringBuilder input1 = new StringBuilder();
		String words[] = output.split("/");
		for(String w:words){  
			input1.insert(0,w+"/");
		}

		output = input1.toString();
		output =  output.substring(0, output.length() - 1);
		return output;

	}

	public static void main(String[] args) {

		Board b = new Board();
		Fen(b);
	}

	private static String buildEnPassantTarget(Board board,String output) {
		String spacer = " ";
		if (board.isPawn())
		{
			String sourceY = null;
			Map<Character, Integer> map = StringCommandParser.getMap();
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				Character key = entry.getKey();
				if( entry.getValue() == board.getPawn_sorce().getY()){
					sourceY = key.toString().toLowerCase();
					break;
				}
			}
			if(board.getPlayer() == Color.WHITE.getValue())
				output += spacer + sourceY + (board.getPawn_sorce().getX()+2)+" ";
			else
				output += spacer + sourceY + (board.getPawn_sorce().getX())+" ";
		}	

		else
		{
			output += spacer + "- ";
		}



		return output;
	}
}
