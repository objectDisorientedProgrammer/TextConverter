/*
 * Created: August 22, 2013 around 11:00PM
 * Author: Douglas Chidester
 * 
 * Description: Converts ascii text (strings) to binary.
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

public class AsciiToBinaryConverter
{
	Map<String, String> asciiToBinary = new HashMap<String, String>();
	
	public AsciiToBinaryConverter()
	{
		super();
		initializeMap();
	}
	
	/**
	 * Convert a single character from ascii to binary.
	 * @param letter - string to be converted
	 * @return binary of the letter
	 */
	public String convertLetterAsAString(String letter)
	{
		return asciiToBinary.get(letter);
	}
	
	/**
	 * Convert a string to from ascii to binary.
	 * @param sentence - string to be converted
	 * @return binary of the sentence
	 */
	public String convertString(String sentence)
	{
		String toDo;
		StringBuilder newStr = new StringBuilder();
		int end = sentence.length();
		for(int i = 0; i < end; i++)
		{
			toDo = sentence.substring(i, i+1);
			newStr.append(asciiToBinary.get(toDo));
		}
		return newStr.toString();
	}
	
	private void initializeMap()
	{
		// add upper case letters
		asciiToBinary.put("A", "01000001");
		asciiToBinary.put("B", "01000010");
		asciiToBinary.put("C", "01000011");
		asciiToBinary.put("D", "01000100");
		asciiToBinary.put("E", "01000101");
		asciiToBinary.put("F", "01000110");
		asciiToBinary.put("G", "01000111");
		asciiToBinary.put("H", "01001000");
		asciiToBinary.put("I", "01001001");
		asciiToBinary.put("J", "01001010");
		asciiToBinary.put("K", "01001011");
		asciiToBinary.put("L", "01001100");
		asciiToBinary.put("M", "01001101");
		asciiToBinary.put("N", "01001110");
		asciiToBinary.put("O", "01001111");
		asciiToBinary.put("P", "01010000");
		asciiToBinary.put("Q", "01010001");
		asciiToBinary.put("R", "01010010");
		asciiToBinary.put("S", "01010011");
		asciiToBinary.put("T", "01010100");
		asciiToBinary.put("U", "01010101");
		asciiToBinary.put("V", "01010110");
		asciiToBinary.put("W", "01010111");
		asciiToBinary.put("X", "01011000");
		asciiToBinary.put("Y", "01011001");
		asciiToBinary.put("Z", "01011010");
		// add lower case letters
		asciiToBinary.put("a", "01100001");
		asciiToBinary.put("b", "01100010");
		asciiToBinary.put("c", "01100011");
		asciiToBinary.put("d", "01100100");
		asciiToBinary.put("e", "01100101");
		asciiToBinary.put("f", "01100110");
		asciiToBinary.put("g", "01100111");
		asciiToBinary.put("h", "01101000");
		asciiToBinary.put("i", "01101001");
		asciiToBinary.put("j", "01101010");
		asciiToBinary.put("k", "01101011");
		asciiToBinary.put("l", "01101100");
		asciiToBinary.put("m", "01101101");
		asciiToBinary.put("n", "01101110");
		asciiToBinary.put("o", "01101111");
		asciiToBinary.put("p", "01110000");
		asciiToBinary.put("q", "01110001");
		asciiToBinary.put("r", "01110010");
		asciiToBinary.put("s", "01110011");
		asciiToBinary.put("t", "01110100");
		asciiToBinary.put("u", "01110101");
		asciiToBinary.put("v", "01110110");
		asciiToBinary.put("w", "01110111");
		asciiToBinary.put("x", "01111000");
		asciiToBinary.put("y", "01111001");
		asciiToBinary.put("z", "01111010");
		// whitespace
		asciiToBinary.put(" ", "00100000 ");		// space
		asciiToBinary.put("\n", "00001010\n");	// line feed
		asciiToBinary.put("\r", "00001101\r");	// carriage return
		// punctuation
		asciiToBinary.put(".", "00101110");
		asciiToBinary.put("!", "00100001");
		asciiToBinary.put("?", "00111111");
		asciiToBinary.put("'", "00100111");
		asciiToBinary.put(",", "00101100");
		asciiToBinary.put("-", "00101101");
		asciiToBinary.put("\"", "00100010");
		// numbers 0-9
		asciiToBinary.put("0", "00110000");
		asciiToBinary.put("1", "00110001");
		asciiToBinary.put("2", "00110010");
		asciiToBinary.put("3", "00110011");
		asciiToBinary.put("4", "00110100");
		asciiToBinary.put("5", "00110101");
		asciiToBinary.put("6", "00110110");
		asciiToBinary.put("7", "00110111");
		asciiToBinary.put("8", "00111000");
		asciiToBinary.put("9", "00111001");
		// misc
		asciiToBinary.put("{", "01111011");
		asciiToBinary.put("}", "01111101");
		asciiToBinary.put("[", "01011011");
		asciiToBinary.put("]", "01011101");
		asciiToBinary.put(":", "00111010");
		asciiToBinary.put(";", "00111011");
		asciiToBinary.put("/", "00101111");
		asciiToBinary.put("\\", "01011100");
		asciiToBinary.put("_", "01011111");
		asciiToBinary.put("<", "00111100");
		asciiToBinary.put(">", "00111110");
		asciiToBinary.put("$", "00100100");
		asciiToBinary.put("&", "00100110");
		asciiToBinary.put("(", "00101000");
		asciiToBinary.put(")", "00101001");
		asciiToBinary.put("*", "00101010");
		asciiToBinary.put("#", "00100011");
		asciiToBinary.put("%", "00100101");
		asciiToBinary.put("@", "01000000");
		asciiToBinary.put("=", "00111101");
		asciiToBinary.put("+", "00101011");
		asciiToBinary.put("`", "01100000");
		asciiToBinary.put("~", "01111110");
		asciiToBinary.put("^", "01011110");
	}
}
