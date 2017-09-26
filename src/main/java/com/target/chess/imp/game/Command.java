package com.target.chess.imp.game;

public class Command {

	private String piece;
	private String cmd;
	private Point to;

	public Command(String piece, String cmd,Point to) {
		this.piece = piece;
		this.cmd = cmd;
		this.to = to;

	}

	/**
	 * @return the piece
	 */
	public String getPiece() {
		return piece;
	}

	/**
	 * @param piece the piece to set
	 */
	public void setPiece(String piece) {
		this.piece = piece;
	}

	/**
	 * @return the cmd
	 */
	public String getCmd() {
		return cmd;
	}

	/**
	 * @param cmd the cmd to set
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	/**
	 * @return the to
	 */
	public Point getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Point to) {
		this.to = to;
	}

	

}
