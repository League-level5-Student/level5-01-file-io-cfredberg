package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
	public static void main(String[] args) {
		int key = Integer.parseInt(JOptionPane.showInputDialog("What is your key?"));
		key = Math.abs(key);
		key = key % 26;
		String message = JOptionPane.showInputDialog("What is the message you wish to encode?");
		char[] chars = message.toCharArray();
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encrypted.txt");
			for (char oldChar : chars) {
				int newCharI = (int)oldChar + key;
				if (Character.isLowerCase(oldChar)) {
					newCharI = newCharI > 122 ? newCharI - 26 : newCharI;
				}else if (Character.isUpperCase(oldChar)) {
					newCharI = newCharI > 90 ? newCharI - 26 : newCharI;
				}else {
					newCharI = (int)oldChar;
				}
				char newChar = (char)newCharI;
				fw.append(newChar);
			}
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
