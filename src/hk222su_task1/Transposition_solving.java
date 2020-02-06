package hk222su_task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transposition_solving {
	 public static void main(String[] args) throws FileNotFoundException 
	    { 
		 File test = new File ("/home/haraldur/Desktop/Skolinn/1DV700/halli");
		 Scanner read = new Scanner(test);	   
		 String theString = "";
		 
		 theString = read.nextLine();
		 while (read.hasNextLine()) {
		        theString = theString + "\n" + read.nextLine();
		 }
		 
		 char[] charArray = theString.toCharArray();
		 File outfile = new File ("/home/haraldur/Desktop/Skolinn/1DV700/Rong_trans_solved.txt");
		 PrintWriter printer = new PrintWriter(outfile);
		 
		 String ofFive = "";
		 StringBuffer loksins = new StringBuffer();
		 
		 int count = 0;
		 for(int i = 0; i<charArray.length; i++) {			  
				 for(int j = 0; j<5; j++) {	
					 if(count<1009) {
					 ofFive += charArray[count];
					 count++;}
			 }
			
		   if(ofFive.length()==5) {
		   System.out.println(ofFive);
		   StringBuffer testing = new StringBuffer();
		   testing.append(ofFive.charAt(1));
		   testing.append(ofFive.charAt(2));
		   testing.append(ofFive.charAt(4));
		   testing.append(ofFive.charAt(0));
		   testing.append(ofFive.charAt(3));
		   String loka = testing.toString();		   
		   testing.delete(0, testing.length()-1);
		   loksins.append(loka);
		   loka = "";}
		   
		   ofFive="";
		 }
		 System.out.print(loksins);
	       
			
			
	    } 
	 
}