package com.target.chess.imp.game;

public enum Pieces {
	
	
	Bishop("B"),
	King("K"),
	Knight("N"),
	Pawn("P"),
	Rook("R"),
	Queen("Q");

	private String value;
	
	private Pieces(String value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	
	
}
