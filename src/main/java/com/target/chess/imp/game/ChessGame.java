package com.target.chess.imp.game;

import com.target.chess.imp.fen.FenMarsheller;
import com.target.chess.imp.parser.StringCommandParser;
import com.target.chess.imp.piece.Board;
import com.target.chess.imp.piece.Piece;

public class ChessGame {

	private Board board;
	int full_move = 0;
	int half_move = 0;


	public ChessGame(final Board board) {
		this.board = board;
	}

	public String run(final String command,final Color color) {
		String fen = null;
		Piece piece = null;
		Command chess_cmd = new StringCommandParser(command).toCommands();
		piece = Source.find_source(this.board,chess_cmd,color);
		if(piece == null){
			System.out.println("NO SOURCE FOR MOVE");
		}

		board.setPlayer(color.getValue());
		if(piece.isValid(board, chess_cmd.getTo())){
			Point temp = piece.getPoint();
			piece.setPoint(chess_cmd.getTo());
			board.setSquare(chess_cmd.getTo().getX(), chess_cmd.getTo().getY(), piece);
			board.clearSquare(temp.getX(), temp.getY());
			half_move += 1;
			if(piece.getColor().getValue() == Color.BLACK.getValue())
				full_move += 1;
			if(piece.getType().equals(Pieces.Pawn.getValue())){
				board.setPawn(true);
				board.setPawn_sorce(temp);
				half_move = 0;
			}else{
				board.setPawn(false);
			}
			board.setFull_move(full_move);
			board.setHalf_move(half_move);
			fen = FenMarsheller.Fen(board);
			System.out.println(fen);
		}else{
			System.out.println("INVALID MOVE");
		}
		
		return fen;

	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
}
