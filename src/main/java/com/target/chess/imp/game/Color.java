package com.target.chess.imp.game;

public enum Color {
	
	
	WHITE(1),
	BLACK(0);

	private int value;
	
	private Color(int value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	
	
}
