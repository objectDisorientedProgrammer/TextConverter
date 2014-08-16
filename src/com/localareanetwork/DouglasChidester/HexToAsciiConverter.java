/*
 * Created: August 25, 2013 around 10:40PM
 * Author: Douglas Chidester
 * 
 * Description: Converts hexadecimal to ascii text (strings).
 *  Copyright (C) 2013  Douglas Chidester
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.localareanetwork.DouglasChidester;

import java.util.HashMap;
import java.util.Map;

public class HexToAsciiConverter
{
	Map<String, String> hexToAscii = new HashMap<String, String>();

	public HexToAsciiConverter()
	{
		super();
		initializeMap();
	}
	
	/**
	 * Convert a single character from hexadecimal to ascii.
	 * @param letter - string to be converted
	 * @return ascii of the letter
	 */
	public String convertLetterAsAString(String letter)
	{
		return hexToAscii.get(letter);
	}
	
	/**
	 * Convert a string to from hexadecimal to ascii.
	 * @param sentence - string to be converted
	 * @return ascii of the sentence
	 */
	public String convertString(String sentence)
	{
		StringBuilder newStr = new StringBuilder();
		int end = sentence.length();
		for(int i = 0; i < end; i+=2)
			newStr.append(hexToAscii.get(sentence.substring(i, i+2).toUpperCase()));
		return newStr.toString();
	}
	
	private void initializeMap()
	{
		// add upper case letters
		hexToAscii.put("41", "A");
		hexToAscii.put("42", "B");
		hexToAscii.put("43", "C");
		hexToAscii.put("44", "D");
		hexToAscii.put("45", "E");
		hexToAscii.put("46", "F");
		hexToAscii.put("47", "G");
		hexToAscii.put("48", "H");
		hexToAscii.put("49", "I");
		hexToAscii.put("4A", "J");
		hexToAscii.put("4B", "K");
		hexToAscii.put("4C", "L");
		hexToAscii.put("4D", "M");
		hexToAscii.put("4E", "N");
		hexToAscii.put("4F", "O");
		hexToAscii.put("50", "P");
		hexToAscii.put("51", "Q");
		hexToAscii.put("52", "R");
		hexToAscii.put("53", "S");
		hexToAscii.put("54", "T");
		hexToAscii.put("55", "U");
		hexToAscii.put("56", "V");
		hexToAscii.put("57", "W");
		hexToAscii.put("58", "X");
		hexToAscii.put("59", "Y");
		hexToAscii.put("5A", "Z");
		// add lower case letters
		hexToAscii.put("61", "a");
		hexToAscii.put("62", "b");
		hexToAscii.put("63", "c");
		hexToAscii.put("64", "d");
		hexToAscii.put("65", "e");
		hexToAscii.put("66", "f");
		hexToAscii.put("67", "g");
		hexToAscii.put("68", "h");
		hexToAscii.put("69", "i");
		hexToAscii.put("6A", "j");
		hexToAscii.put("6B", "k");
		hexToAscii.put("6C", "l");
		hexToAscii.put("6D", "m");
		hexToAscii.put("6E", "n");
		hexToAscii.put("6F", "o");
		hexToAscii.put("70", "p");
		hexToAscii.put("71", "q");
		hexToAscii.put("72", "r");
		hexToAscii.put("73", "s");
		hexToAscii.put("74", "t");
		hexToAscii.put("75", "u");
		hexToAscii.put("76", "v");
		hexToAscii.put("77", "w");
		hexToAscii.put("78", "x");
		hexToAscii.put("79", "y");
		hexToAscii.put("7A", "z");
		// whitespace
		hexToAscii.put("20", " ");		// space
		hexToAscii.put("0A", "\n");	// line feed
		hexToAscii.put("0D", "\r");	// carriage return
		// punctuation
		hexToAscii.put("2E", ".");
		hexToAscii.put("21", "!");
		hexToAscii.put("3F", "?");
		hexToAscii.put("27", "'");
		hexToAscii.put("2C", ",");
		hexToAscii.put("2D", "-");
		hexToAscii.put("22", "\"");
		// numbers 0-9
		hexToAscii.put("30", "0");
		hexToAscii.put("31", "1");
		hexToAscii.put("32", "2");
		hexToAscii.put("33", "3");
		hexToAscii.put("34", "4");
		hexToAscii.put("35", "5");
		hexToAscii.put("36", "6");
		hexToAscii.put("37", "7");
		hexToAscii.put("38", "8");
		hexToAscii.put("39", "9");
		// misc
		hexToAscii.put("7B", "{");
		hexToAscii.put("7D", "}");
		hexToAscii.put("5B", "[");
		hexToAscii.put("5D", "]");
		hexToAscii.put("3A", ":");
		hexToAscii.put("3B", ";");
		hexToAscii.put("2F", "/");
		hexToAscii.put("5C", "\\");
		hexToAscii.put("5F", "_");
		hexToAscii.put("3C", "<");
		hexToAscii.put("3E", ">");
		hexToAscii.put("24", "$");
		hexToAscii.put("26", "&");
		hexToAscii.put("28", "(");
		hexToAscii.put("29", ")");
		hexToAscii.put("2A", "*");
		hexToAscii.put("23", "#");
		hexToAscii.put("25", "%");
		hexToAscii.put("40", "@");
		hexToAscii.put("3D", "=");
		hexToAscii.put("2B", "+");
		hexToAscii.put("60", "`");
		hexToAscii.put("7E", "~");
		hexToAscii.put("5E", "^");
	}
}
