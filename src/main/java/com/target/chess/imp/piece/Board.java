package com.target.chess.imp.piece;

import com.target.chess.imp.game.Color;
import com.target.chess.imp.game.Point;

public class Board {
	
	private Piece[][] board;
	private int player;
	private boolean isWhiteCastled;
	private boolean isBlackCastled;
	private int full_move;
	private int half_move;
	private boolean isPawn;
	private Point pawn_sorce;
	
	
	public Board(){
		
		board = new Piece[8][8]; 
		for(int i = 0; i<8; i++){
			for(int j = 0; j<8; j++){
				board[i][j] = null;
			}
		}
		//black pieces
		board[0][0] = new Rook(Color.WHITE,new Point(0,0));
		board[0][7] = new Rook(Color.WHITE,new Point(0,7));
		board[0][1] = new Knight(Color.WHITE,new Point(0,1));
		board[0][6] = new Knight(Color.WHITE,new Point(0,6));
		board[0][2] = new Bishop(Color.WHITE,new Point(0,2));
		board[0][5] = new Bishop(Color.WHITE,new Point(0,5));
		board[0][3] = new Queen(Color.WHITE,new Point(0,3));
		board[0][4] = new King(Color.WHITE,new Point(0,4));
		
		for(int i = 0; i<8; i++){
			board[1][i] = new Pawn(Color.WHITE,new Point(1,i));
		}
		//Black pieces
		board[7][0] = new Rook(Color.BLACK,new Point(0,7));
		board[7][7] = new Rook(Color.BLACK,new Point(7,7));
		board[7][1] = new Knight(Color.BLACK,new Point(7,1));
		board[7][6] = new Knight(Color.BLACK,new Point(7,6));
		board[7][2] = new Bishop(Color.BLACK,new Point(7,2));
		board[7][5] = new Bishop(Color.BLACK,new Point(7,5));
		board[7][3] = new Queen(Color.BLACK,new Point(7,3));
		board[7][4] = new King(Color.BLACK,new Point(7,4));
		
		for(int i=0;i<8;i++){
			board[6][i] = new Pawn(Color.BLACK,new Point(6,i));
		}
		
	}

	public Piece getSquare(int row, int col){
		return board[row][col];
	}
	public void setSquare(int row, int col, Piece piece){
		board[row][col] = piece;
	}
	
	
	public void clearSquare(int row, int col){
		board[row][col] = null;
	}
	
	
	public boolean hasPiece(int row, int col){
		if(getSquare(row,col) != null){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @return the player
	 */
	public int getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(int player) {
		this.player = player;
	}

	/**
	 * @return the isWhiteCastled
	 */
	public boolean isWhiteCastled() {
		return isWhiteCastled;
	}

	/**
	 * @param isWhiteCastled the isWhiteCastled to set
	 */
	public void setWhiteCastled(boolean isWhiteCastled) {
		this.isWhiteCastled = isWhiteCastled;
	}

	/**
	 * @return the isBlackCastled
	 */
	public boolean isBlackCastled() {
		return isBlackCastled;
	}

	/**
	 * @param isBlackCastled the isBlackCastled to set
	 */
	public void setBlackCastled(boolean isBlackCastled) {
		this.isBlackCastled = isBlackCastled;
	}

	/**
	 * @return the full_move
	 */
	public int getFull_move() {
		return full_move;
	}

	/**
	 * @param full_move the full_move to set
	 */
	public void setFull_move(int full_move) {
		this.full_move = full_move;
	}

	/**
	 * @return the half_move
	 */
	public int getHalf_move() {
		return half_move;
	}

	/**
	 * @param half_move the half_move to set
	 */
	public void setHalf_move(int half_move) {
		this.half_move = half_move;
	}

	/**
	 * @return the isPawn
	 */
	public boolean isPawn() {
		return isPawn;
	}

	/**
	 * @param isPawn the isPawn to set
	 */
	public void setPawn(boolean isPawn) {
		this.isPawn = isPawn;
	}

	/**
	 * @return the pawn_sorce
	 */
	public Point getPawn_sorce() {
		return pawn_sorce;
	}

	/**
	 * @param pawn_sorce the pawn_sorce to set
	 */
	public void setPawn_sorce(Point pawn_sorce) {
		this.pawn_sorce = pawn_sorce;
	}
	
	
	
}