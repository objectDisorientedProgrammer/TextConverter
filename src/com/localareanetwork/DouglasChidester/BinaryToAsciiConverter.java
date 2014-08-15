/*
 * Created: August 25, 2013 around 10:00PM
 * Author: Douglas Chidester
 * 
 * Description: Converts binary to ascii text (strings).
 */

package com.localareanetwork.DouglasChidester;

import java.util.HashMap;
import java.util.Map;

public class BinaryToAsciiConverter
{
	Map<String, String> binaryToAscii = new HashMap<String, String>();

	public BinaryToAsciiConverter()
	{
		super();
		initializeMap();
	}
	
	/**
	 * Convert a single character from binary to ascii.
	 * @param letter - string to be converted
	 * @return ascii of the letter
	 */
	public String convertLetterAsAString(String letter)
	{
		return binaryToAscii.get(letter);
	}
	
	/**
	 * Convert a string to from binary to ascii.
	 * @param sentence - string to be converted
	 * @return ascii of the sentence
	 */
	public String convertString(String sentence)
	{
		String toDo;
		StringBuilder newStr = new StringBuilder();
		int end = sentence.length();
		for(int i = 0; i < end; i+=8)
		{
			toDo = sentence.substring(i, i+8);
			newStr.append(binaryToAscii.get(toDo));
		}
		return newStr.toString();
	}

	private void initializeMap()
	{
		// add upper case letters
		binaryToAscii.put("01000001", "A");
		binaryToAscii.put("01000010", "B");
		binaryToAscii.put("01000011", "C");
		binaryToAscii.put("01000100", "D");
		binaryToAscii.put("01000101", "E");
		binaryToAscii.put("01000110", "F");
		binaryToAscii.put("01000111", "G");
		binaryToAscii.put("01001000", "H");
		binaryToAscii.put("01001001", "I");
		binaryToAscii.put("01001010", "J");
		binaryToAscii.put("01001011", "K");
		binaryToAscii.put("01001100", "L");
		binaryToAscii.put("01001101", "M");
		binaryToAscii.put("01001110", "N");
		binaryToAscii.put("01001111", "O");
		binaryToAscii.put("01010000", "P");
		binaryToAscii.put("01010001", "Q");
		binaryToAscii.put("01010010", "R");
		binaryToAscii.put("01010011", "S");
		binaryToAscii.put("01010100", "T");
		binaryToAscii.put("01010101", "U");
		binaryToAscii.put("01010110", "V");
		binaryToAscii.put("01010111", "W");
		binaryToAscii.put("01011000", "X");
		binaryToAscii.put("01011001", "Y");
		binaryToAscii.put("01011010", "Z");
		// add lower case letters
		binaryToAscii.put("01100001", "a");
		binaryToAscii.put("01100010", "b");
		binaryToAscii.put("01100011", "c");
		binaryToAscii.put("01100100", "d");
		binaryToAscii.put("01100101", "e");
		binaryToAscii.put("01100110", "f");
		binaryToAscii.put("01100111", "g");
		binaryToAscii.put("01101000", "h");
		binaryToAscii.put("01101001", "i");
		binaryToAscii.put("01101010", "j");
		binaryToAscii.put("01101011", "k");
		binaryToAscii.put("01101100", "l");
		binaryToAscii.put("01101101", "m");
		binaryToAscii.put("01101110", "n");
		binaryToAscii.put("01101111", "o");
		binaryToAscii.put("01110000", "p");
		binaryToAscii.put("01110001", "q");
		binaryToAscii.put("01110010", "r");
		binaryToAscii.put("01110011", "s");
		binaryToAscii.put("01110100", "t");
		binaryToAscii.put("01110101", "u");
		binaryToAscii.put("01110110", "v");
		binaryToAscii.put("01110111", "w");
		binaryToAscii.put("01111000", "x");
		binaryToAscii.put("01111001", "y");
		binaryToAscii.put("01111010", "z");
		// whitespace
		binaryToAscii.put("00100000", " ");		// space
		binaryToAscii.put("00001010", "\n");	// line feed
		binaryToAscii.put("00001101", "\r");	// carriage return
		// punctuation
		binaryToAscii.put("00101110", ".");
		binaryToAscii.put("00100001", "!");
		binaryToAscii.put("00111111", "?");
		binaryToAscii.put("00100111", "'");
		binaryToAscii.put("00101100", ",");
		binaryToAscii.put("00101101", "-");
		binaryToAscii.put("00100010", "\"");
		// numbers 0-9
		binaryToAscii.put("00110000", "0");
		binaryToAscii.put("00110001", "1");
		binaryToAscii.put("00110010", "2");
		binaryToAscii.put("00110011", "3");
		binaryToAscii.put("00110100", "4");
		binaryToAscii.put("00110101", "5");
		binaryToAscii.put("00110110", "6");
		binaryToAscii.put("00110111", "7");
		binaryToAscii.put("00111000", "8");
		binaryToAscii.put("00111001", "9");
		// misc
		binaryToAscii.put("01111011", "{");
		binaryToAscii.put("01111101", "}");
		binaryToAscii.put("01011011", "[");
		binaryToAscii.put("01011101", "]");
		binaryToAscii.put("00111010", ":");
		binaryToAscii.put("00111011", ";");
		binaryToAscii.put("00101111", "/");
		binaryToAscii.put("01011100", "\\");
		binaryToAscii.put("01011111", "_");
		binaryToAscii.put("00111100", "<");
		binaryToAscii.put("00111110", ">");
		binaryToAscii.put("00100100", "$");
		binaryToAscii.put("00100110", "&");
		binaryToAscii.put("00101000", "(");
		binaryToAscii.put("00101001", ")");
		binaryToAscii.put("00101010", "*");
		binaryToAscii.put("00100011", "#");
		binaryToAscii.put("00100101", "%");
		binaryToAscii.put("01000000", "@");
		binaryToAscii.put("00111101", "=");
		binaryToAscii.put("00101011", "+");
		binaryToAscii.put("01100000", "`");
		binaryToAscii.put("01111110", "~");
		binaryToAscii.put("01011110", "^");
		
		/* `	01100000	60
		 * ~	01111110	7E
		 * ^	01011110	5E
		 */
	}
}
