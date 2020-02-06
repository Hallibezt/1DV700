package hk222su_task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AlgorithmMain {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		while(true) {
		System.out.print("Please, choose encryption/decryption algorithm: \n"+
						 "1. Substitution \n"+
						 "2. Transposition \n"+
						 "3. Exit \n"+
						 "===> ");
		try {
		int cipher = input.nextInt();
			if(cipher<1 || cipher>3) {System.out.println("Please choose number from the list");}
			if(cipher == 3) {break;}
			if(cipher == 1) {
				while(true) {
					System.out.println("===============================");
					System.out.print("Please, choose encryption or decryption \n"+
							 "1. Encryption \n"+
							 "2. Decryption \n"+
							 "3. Exit \n"+
							 "===> ");
					int a = input.nextInt();
					if(cipher<1 || cipher>3) {System.out.println("Please choose number from the list");}
					if(a == 3) {break;}	
					if (a == 1) {
						System.out.println("Please, enter the location of the plain text file:");
						String plain = input.next();
						System.out.println("Please, enter the location and name of a file to write encrypted text to");
						String encrypt = input.next();
						File text = new File(plain);
						Scanner read = new Scanner(text);
						
						System.out.print("Please, enter size of key to decrypt with (0-255): ");
						int key = input.nextInt();
						Substitution demo = new Substitution(key);
						
						String theString = "";
						
						 theString = read.nextLine();
						 while (read.hasNextLine()) {
						        theString = theString + "\n" + read.nextLine();
						 }
						 
						char[] testing = new char[theString.length()];		
						for(int i = 0; i<theString.length(); i++) {
							testing[i] = theString.charAt(i);			
						}
						
						demo.encrypt(testing);						
						File outfile = new File (encrypt);
						PrintWriter printer = new PrintWriter(outfile);
						printer.print(demo.toEncrypted());
						printer.close();
					 	read.close();
					 	
						
						
					}
					if (a == 2) {
						System.out.println("Please, enter the location of the encrypted file:");
						String encrypt = input.next();
						System.out.println("Please, enter the location and name of a file to write decryted text to");
						String decrypt = input.next();
						File text = new File(encrypt);
						Scanner read = new Scanner(text);	
						
						System.out.print("Please, enter size of key to decrypt with (0-255): ");
						int key = input.nextInt();
						Substitution demo = new Substitution(key);
						
						String theString = "";
						
						 theString = read.nextLine();
						 while (read.hasNextLine()) {
						        theString = theString + "\n" + read.nextLine();
						 }
						 Scanner read2 = new Scanner(theString); 
						 ArrayList<Integer> ble = new ArrayList<Integer>();
							while(read2.hasNextLine()) {
								String hmm = read2.nextLine();
								Scanner read3 = new Scanner(hmm);	
								while(read3.hasNext()) {
									String haha = read3.next();
								if (haha != " ") {			
									ble.add(Integer.parseInt(haha));		
								}
								haha="";
								}
								ble.add(-1);
								hmm = "";
								read3.close();
							}
							demo.decrypted(ble);
							File outfile = new File (decrypt);
							PrintWriter printer = new PrintWriter(outfile);
							printer.print(demo.toDecrypted());
							printer.close();
						 	read.close();
						 	read2.close();
						 	
							}	
						
							
					}
				}
			
			if(cipher == 2) {
				while(true) {
					System.out.println("===============================");
					System.out.print("Please, choose encryption or decryption \n"+
							 "1. Encryption \n"+
							 "2. Decryption \n"+
							 "3. Exit \n"+
							 "===> ");
					int a = input.nextInt();
						if(a<1 || a>3) {System.out.println("Please choose number from the list");}
						if(a == 3) {break;}	
						if (a == 1) {
							System.out.println("Please, enter the location of the plain text file:");
							String plain = input.next();
							System.out.println("Please, enter the location and name of a file to write encrypted text to");
							String encrypt = input.next();						
							File text = new File(plain);
							Scanner read = new Scanner(text);
							
							System.out.print("Please, enter size of key to decrypt with (0-255): ");
							int key = input.nextInt();
							
							
							String theString = "";
							
							 theString = read.nextLine();
							 while (read.hasNextLine()) {
							        theString = theString + "\n" + read.nextLine();
							 }
							 
							char[] testing = new char[theString.length()];		
							for(int i = 0; i<theString.length(); i++) {
								testing[i] = theString.charAt(i);			
							}
							
							
							Transposition demo = new Transposition(key);
							demo.encrypt(testing);						
							File outfile = new File (encrypt);
							PrintWriter printer = new PrintWriter(outfile);
							printer.print(demo.encryptedToString());
							printer.close();
						 	read.close();
							
						}
						if (a == 2) {
							System.out.println("Please, enter the location of the enncrypted text file:");
							String encrypted = input.next();
							System.out.println("Please, enter the location and name of a file to write the plain text to");
							String plain = input.next();						
							File text = new File(encrypted);
							Scanner read = new Scanner(text);
							
							System.out.print("Please, enter size of key to decrypt with (0-255): ");
							int key = input.nextInt();
							
							
							String theString = "";
							
							 theString = read.nextLine();
							 while (read.hasNextLine()) {
							        theString = theString + "\n" + read.nextLine();
							 }
							 
							char[] testing = new char[theString.length()];		
							for(int i = 0; i<theString.length(); i++) {
								testing[i] = theString.charAt(i);			
							}
							
							
							Transposition demo = new Transposition(key);
							demo.decrypt(testing);
							System.out.print(demo.encryptedToString());
							File outfile = new File (plain);
							PrintWriter printer = new PrintWriter(outfile);
							printer.print(demo.encryptedToString());
							printer.close();
						 	read.close();
							
						}
					
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input");
			input.next();}
		
		catch(FileNotFoundException e) {System.out.println("File not found - check if all filepaths are correct");}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		input.close();
		
	}
	
	
	
}
