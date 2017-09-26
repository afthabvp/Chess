package com.target.chess.imp;

import java.util.Scanner;

import com.target.chess.imp.game.ChessGame;
import com.target.chess.imp.game.Color;
import com.target.chess.imp.piece.Board;

public class MainClass {

	private static Scanner reader = null;
	

	public static void main(String[] args) {
		Board b = new Board();
		System.out.println("Welcome to Chess   Enjoy!");

		ChessGame game = new ChessGame(b);
		String move = "";
		int i = 1;
		Color color = null;
		while(!move.equals("E")){
			reader  = new Scanner(System.in);
			System.out.println("Enter a Move: ");
			move = reader .next();
			if(i%2 == 1)
				color = Color.WHITE;
			else
				color = Color.BLACK;
			
			game.run(move,color);
			i++;
		}


	}

}
