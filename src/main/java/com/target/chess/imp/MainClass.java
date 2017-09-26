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


			if(i%2 == 1){
				System.out.println("Enter a WHITE Move OR E for Exit ");
				color = Color.WHITE;
			}
			else{
				System.out.println("Enter a BLACK Move or  E for Exit  ");
				color = Color.BLACK;
			}
			move = reader .next();
			if (!move.equalsIgnoreCase("E"))
				game.run(move,color);
			i++;
		}


	}

}
