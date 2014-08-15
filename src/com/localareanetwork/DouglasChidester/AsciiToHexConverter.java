/*
 * Created: August 25, 2013 around 10:50PM
 * Author: Douglas Chidester
 * 
 * Description: Converts ascii text (strings) to hexadecimal.
 */

package com.localareanetwork.DouglasChidester;

import java.util.HashMap;
import java.util.Map;

public class AsciiToHexConverter
{
	Map<String, String> asciiToHex = new HashMap<String, String>();

	public AsciiToHexConverter()
	{
		super();
		initializeMap();
	}
	
	/**
	 * Convert a single character from ascii to hexadecimal.
	 * @param letter - string to be converted
	 * @return hex of the letter
	 */
	public String convertLetterAsAString(String letter)
	{
		return asciiToHex.get(letter);
	}
	
	/**
	 * Convert a string to from ascii to hexadecimal.
	 * @param sentence - string to be converted
	 * @return hex of the sentence
	 */
	public String convertString(String sentence)
	{
		String toDo;
		StringBuilder newStr = new StringBuilder();
		int end = sentence.length();
		for(int i = 0; i < end; i++)
		{
			toDo = sentence.substring(i, i+1);
			newStr.append(asciiToHex.get(toDo));
		}
		return newStr.toString();
	}
	
	private void initializeMap()
	{
		// add upper case letters
		asciiToHex.put("A", "41");
		asciiToHex.put("B", "42");
		asciiToHex.put("C", "43");
		asciiToHex.put("D", "44");
		asciiToHex.put("E", "45");
		asciiToHex.put("F", "46");
		asciiToHex.put("G", "47");
		asciiToHex.put("H", "48");
		asciiToHex.put("I", "49");
		asciiToHex.put("J", "4A");
		asciiToHex.put("K", "4B");
		asciiToHex.put("L", "4C");
		asciiToHex.put("M", "4D");
		asciiToHex.put("N", "4E");
		asciiToHex.put("O", "4F");
		asciiToHex.put("P", "50");
		asciiToHex.put("Q", "51");
		asciiToHex.put("R", "52");
		asciiToHex.put("S", "53");
		asciiToHex.put("T", "54");
		asciiToHex.put("U", "55");
		asciiToHex.put("V", "56");
		asciiToHex.put("W", "57");
		asciiToHex.put("X", "58");
		asciiToHex.put("Y", "59");
		asciiToHex.put("Z", "5A");
		// add lower case letters
		asciiToHex.put("a", "61");
		asciiToHex.put("b", "62");
		asciiToHex.put("c", "63");
		asciiToHex.put("d", "64");
		asciiToHex.put("e", "65");
		asciiToHex.put("f", "66");
		asciiToHex.put("g", "67");
		asciiToHex.put("h", "68");
		asciiToHex.put("i", "69");
		asciiToHex.put("j", "6A");
		asciiToHex.put("k", "6B");
		asciiToHex.put("l", "6C");
		asciiToHex.put("m", "6D");
		asciiToHex.put("n", "6E");
		asciiToHex.put("o", "6F");
		asciiToHex.put("p", "70");
		asciiToHex.put("q", "71");
		asciiToHex.put("r", "72");
		asciiToHex.put("s", "73");
		asciiToHex.put("t", "74");
		asciiToHex.put("u", "75");
		asciiToHex.put("v", "76");
		asciiToHex.put("w", "77");
		asciiToHex.put("x", "78");
		asciiToHex.put("y", "79");
		asciiToHex.put("z", "7A");
		// whitespace
		asciiToHex.put(" ", "20 ");		// space
		asciiToHex.put("\n", "0A\n");	// line feed
		asciiToHex.put("\r", "0D\r");	// carriage return
		// punctuation
		asciiToHex.put(".", "2E");
		asciiToHex.put("!", "21");
		asciiToHex.put("?", "3F");
		asciiToHex.put("'", "27");
		asciiToHex.put(",", "2C");
		asciiToHex.put("-", "2D");
		asciiToHex.put("\"", "22");
		// numbers 0-9
		asciiToHex.put("0", "30");
		asciiToHex.put("1", "31");
		asciiToHex.put("2", "32");
		asciiToHex.put("3", "33");
		asciiToHex.put("4", "34");
		asciiToHex.put("5", "35");
		asciiToHex.put("6", "36");
		asciiToHex.put("7", "37");
		asciiToHex.put("8", "38");
		asciiToHex.put("9", "39");
		// misc
		asciiToHex.put("{", "7B");
		asciiToHex.put("}", "7D");
		asciiToHex.put("[", "5B");
		asciiToHex.put("]", "5D");
		asciiToHex.put(":", "3A");
		asciiToHex.put(";", "3B");
		asciiToHex.put("/", "2F");
		asciiToHex.put("\\", "5C");
		asciiToHex.put("_", "5F");
		asciiToHex.put("<", "3C");
		asciiToHex.put(">", "3E");
		asciiToHex.put("$", "24");
		asciiToHex.put("&", "26");
		asciiToHex.put("(", "28");
		asciiToHex.put(")", "29");
		asciiToHex.put("*", "2A");
		asciiToHex.put("#", "23");
		asciiToHex.put("%", "25");
		asciiToHex.put("@", "40");
		asciiToHex.put("=", "3D");
		asciiToHex.put("+", "2B");
		asciiToHex.put("`", "60");
		asciiToHex.put("~", "7E");
		asciiToHex.put("^", "5E");
		
		/*
		 * to do
		 * 
		 * `	01100000	60
		 * ~	01111110	7E
		 * ^	01011110	5E
		 * 
		 * {	01111011	7B
		 * }	01111101	7D
		 * [	01011011	5B
		 * ]	01011101	5D
		 * :	00111010	3A
		 * ;	00111011	3B
		 * /	00101111	2F
		 * \	01011100	5C
		 * _	01011111	5F
		 * <	00111100	3C
		 * >	00111110	3E
		 * $	00100100	24
		 * &	00100110	26
		 * (	00101000	28
		 * )	00101001	29
		 * *	00101010	2A
		 * #	00100011	23
		 * %	00100101 	25
		 * @	01000000	40
		 * 
		 * =	00111101	3D
		 * +	00101011	2B
		 * 0-9	30h -> 39h
		 */
	}
}
