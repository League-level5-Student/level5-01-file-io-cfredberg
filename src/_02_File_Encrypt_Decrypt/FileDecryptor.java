package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public static void main(String[] args) {
		int key = Integer.parseInt(JOptionPane.showInputDialog("What is your key?"));
		key = Math.abs(key);
		key = key % 26;
		String text = "";
		try {
			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/encrypted.txt");
			int c = fr.read();
			while (c != -1) {
				if (Character.isLowerCase((char)c)) {
					c = c - key;
					if (c < 97) {
						c = c + 26;
					}
					
				}else if (Character.isUpperCase((char)c)) {
					c = c - key;
					if (c < 65) {
						c = c + 26;
					}
				}
				text = text + (char)c;
				c = fr.read();
			}
			fr.close();
			JOptionPane.showMessageDialog(null, text);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//Copyright © 2022 Charlie Fredberg