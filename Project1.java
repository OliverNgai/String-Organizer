import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * In this project we will read a file that contains a paragraph of words.
 * We put all the words into an array, then all the valid words (only letters) in a second, and invalid in a 3rd
 * We sort the valid array using selection sort
 * Then create a GUI with a GridLayout (1,3) to display it
 * @author Oliver
 *
 */

public class Project1 {
	
	public static void main(String[] args) {
		
		String[] Word = new String[800];
		int wordCount = 0;
		String[] validWords = new String[800];
		int validWordsCount = 0;
		String[] invalidWords = new String[800];
		int invalidWordsCount = 0;
	
		try {
			//takes the input named Project1Input.txt
			File file = new File("Project1Input.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			
			// while the line isn't null, it will create a new Tokenizer
			while(line != null) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				//While they're more words it'll add it into the array
				while (tokenizer.hasMoreTokens()) {
					Word[wordCount] = tokenizer.nextToken();
					wordCount++;
				}
				line = br.readLine();
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Filling in the valid array and the invalid array
		// Starts to go through the first array
		for (int i = 0; i < wordCount; i++) {
			// Begins the validity check of every word to check every character inside the string
			Boolean isvalid = true;
			for (int j = 0; j < Word[i].length(); j++) {
				// If the character isn't a string isn't a letter, it adds it into the invalid array 
				if (!Character.isLetter(Word[i].charAt(j))) {
					isvalid = false;
					break;
				}
			} // If the String is indeed filled with all characters, it will put it into the valid array
			if (isvalid) {
				validWords[validWordsCount++] = Word[i];
			}
			else {
				invalidWords[invalidWordsCount++] = Word[i];
			}
		}
		
		// Selection Sort
		int lowestCount = 0;
		// for every word in the array, it looks for other words behind it that are alphabetically smaller (ASCII)
		// then swap the two places so that the smallest one becomes the lowest index
		for (int i = 0; i < validWordsCount - 1 ; i++) {
			//starting
			lowestCount = i;
			for (int j = i; j < validWordsCount; j++) {
			// current word
				if(validWords[j].compareToIgnoreCase(validWords[lowestCount]) < 0) {
					lowestCount = j;
				}
			}
			
		String temp = validWords[i];
		validWords[i] = validWords[lowestCount];
		validWords[lowestCount] = temp;
		
		}
		WordGUI gui = new WordGUI();
		
		//appending each text area
		for (int i=0; i < wordCount; i++) {
			gui.addtoMasterArea(Word[i] + "\n");
		}
		for (int i=0; i < validWordsCount; i++) {
			gui.addtoValidArea(validWords[i] + "\n");
		}
		for (int i=0; i < invalidWordsCount; i++) {
			gui.addtoInvalidArea(invalidWords[i] + "\n");
		}
	}
}