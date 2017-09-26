package com.target.chess.imp.game;

import org.junit.Assert;
import org.junit.Test;

import com.target.chess.imp.piece.Board;

public class ChessGameTest {


	@Test
	public void canRunCommand() {
		Board board = new Board();
		ChessGame game = new ChessGame(board);
		Assert.assertEquals("rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1", game.run("e4",Color.WHITE));

	}
	
	



	

}
