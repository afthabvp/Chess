package com.target.chess.imp.parser;

import java.util.HashMap;
import java.util.Map;

import com.target.chess.imp.game.Command;
import com.target.chess.imp.game.Point;

public class StringCommandParser {

	public static Map<Character, Integer> map = null;
	private static Map<Character,String> main_piece;

	 static{

		map = new HashMap<Character, Integer>();
		map.put('A', 0);
		map.put('B', 1);
		map.put('C', 2);
		map.put('D', 3);
		map.put('E', 4);
		map.put('F', 5);
		map.put('G', 6);
		map.put('H', 7);

		main_piece = new HashMap<Character, String>();
		main_piece.put('R', "Rook");
		main_piece.put('N', "Knight");
		main_piece.put('B', "Bishop");
		main_piece.put('K', "King");
		main_piece.put('Q', "Queen");
	}

	private String commandString;

	public StringCommandParser(final String commandString) {
		this.commandString = commandString;
	}

	public Command toCommands() {
		if(isNullOrEmpty(commandString)) return null;
		return buildCommand(commandString);
	}

	private Command buildCommand(final String commandString) {
		return lookupEquivalentCommand(commandString.toUpperCase());
	}

	private boolean isNullOrEmpty(final String commandString) {
		return (null == commandString || commandString.trim().length() == 0);
	}


	private Command lookupEquivalentCommand(final String commandString) {

		Point to = null;
		int length = commandString.trim().length();
		to = new Point((Integer.parseInt(""+commandString.charAt(length-1))-1),
				map.get(Character.toUpperCase(commandString.charAt(length-2)))
				);
		
		if(main_piece.containsKey(Character.toUpperCase(commandString.charAt(0)))) {
			return new Command(main_piece.get(Character.toUpperCase(commandString.charAt(0))),
					commandString,to);
		}else{
			return new Command("Pawn",commandString,to);
		}


	}

	/**
	 * @return the map
	 */
	public static Map<Character, Integer> getMap() {
		return map;
	}


}
