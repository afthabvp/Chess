package com.target.chess.imp.fen;

import org.junit.Assert;
import org.junit.Test;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Point;
import com.target.chess.imp.piece.Board;
import com.target.chess.imp.piece.Piece;

public class FenMarshellerTest {

	@Test
	public void InitialFenTest(){
		Board board = new Board();
		String fen = FenMarsheller.Fen(board);
		Assert.assertEquals("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1", fen);
	}
	
	@Test
	public void whitePawnFenTest(){
		Board board = new Board();
		Piece pawn = board.getSquare(1, 4);
		board.setPlayer(Color.WHITE.getValue());
		board.setPawn(true);;
		
		board.setPawn_sorce(pawn.getPoint());
		pawn.setPoint(new Point(3, 4));
		board.setSquare(3, 4, pawn);
		board.clearSquare(1, 4);
		
		String fen = FenMarsheller.Fen(board);
		Assert.assertEquals("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1", fen);
	}
	
	@Test
	public void blackPawnFenTest(){
		Board board = new Board();
		Piece pawn = board.getSquare(6, 2);
		board.setPlayer(Color.BLACK.getValue());
		board.setPawn(true);;
		
		board.setPawn_sorce(pawn.getPoint());
		pawn.setPoint(new Point(5, 2));
		board.setSquare(5, 2, pawn);
		board.clearSquare(6, 2);
		
		String fen = FenMarsheller.Fen(board);
		Assert.assertEquals("rnbqkbnr/pp1ppppp/2p5/8/8/8/PPPPPPPP/RNBQKBNR w KQkq c6 0 1", fen);
	}
	

}
