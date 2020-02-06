package hk222su_task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class SimpleHash {
	public static void main (String[] args) throws FileNotFoundException {
		System.out.print("Enter 1 for collisions of 1000 related word hashes \n"+
							"Enter 2 for collisions of 3400 unrelated sentences hashes \n");
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		
		if ( choose == 1) {
		Set<String> api = realatedStrings();
		Integer[] checked1000Numbers = new Integer[10000];
		int x = 0;
		
		for(String j: api) {			
			checked1000Numbers[x]=hash(j);
			x++;
		}
		 System.out.println(getIntArray(checked1000Numbers).length);
		 for (Integer b : getIntArray(checked1000Numbers)) {
		     System.out.print(b +" ");
		 }
	
		 checkCollisions(getIntArray(checked1000Numbers));	} 
		 
		
		
		
		if ( choose == 2) {
		//This is for testing 3400+ random sentences strings
		Integer[] checkedNumbers = new Integer[10000];		
		File test = new File ("/home/haraldur/Desktop/Skolinn/1DV700/Haraldur_trans");
		 Scanner read = new Scanner(test);	   
		 String theString = "";
		 int i = 0;		
		 while (read.hasNextLine()) {
		        theString = read.nextLine();
		        checkedNumbers[i]=hash(theString);
		        theString = "";
		        i++;
		 }		 	
		 checkCollisions(getIntArray(checkedNumbers));		 
		 System.out.println("number of hashes " + i);}

		 
		
		        	
		        	
		        	
		        	}
	
	
	public static void checkCollisions(Integer[] illa){
		
	 Map<Integer, Integer> nameAndCount = new HashMap<>();
			 
			 for (Integer e : getIntArray(illa)) {
		            Integer count = nameAndCount.get(e);
		            if (count == null) {
		                nameAndCount.put(e, 1);
		            } else {
		                nameAndCount.put(e, ++count);
		            }
		        }
			 	int totalCollisions = 0;
			 	int totalBuckets = 0;
		        // Print duplicate elements from array in Java
		        Set<Entry<Integer, Integer>> entrySet = nameAndCount.entrySet();
		        for (Entry<Integer, Integer> entry : entrySet) {
		        	
		            if (entry.getValue() > 1) {
		                System.out.printf("duplicate element '%s' and count '%d' :", entry.getKey(), entry.getValue());
		                totalCollisions += entry.getValue();
		                System.out.println();
		                totalBuckets++;
		            }
		        }	
		        System.out.println(totalBuckets);
		        System.out.println(totalCollisions);	       
		        System.out.println();     
			
		
	}
	
	public static Set<String> realatedStrings() {
		String original =  "He bent one strip of metal down to touch another and, with a\n" + 
				"rush of wind, the door sliost into the inner prison chamber.\n" + 
				"The terminal was where it had been, in the center of the room.\n" + 
				"     And the outer door was sealed. Like the inner chamber, there\n" + 
				"was no switch on the inside.\n" + 
				"     There wasn't even a plate where the switch should have been.\n" + 
				"     He was still trapped.\n" + 
				"     At least what remained of the atmosphere wasn't leaking away.\n" + 
				"That would buy some time, until he could think of something else,\n" + 
				"or until they came to get him. Still, there was no recirculation\n" + 
				"vent. Ultimately, there would be a limit to the air supply. Escape";
		String original1 = original.replaceAll("\\s", "");
		
		 Set<String> api = new HashSet<String>();
		
		 while(api.size()<1000) {
			 StringBuilder sko = new StringBuilder();			
			 sko.append(strToBinary(original1));
			 int charAt = (int) (Math.random()*(3000));
			 if(sko.charAt(charAt) == '0') {
				 sko.setCharAt(charAt, '1'); 
			 }
			 if(sko.charAt(charAt) == '1') {
				 sko.setCharAt(charAt, '0'); 
			 }
			 String jon = getString(sko.toString());			 

			 api.add(jon);
			 
		 }
		return api;
		
		
	}
	
	
	public static Integer[] getIntArray(Integer[] e) {
		int counts = 0;
		 for (Integer b : e) {
		     if (b != null) {
		         counts++;
		     }
		 }

		 
		 Integer[] checkedNumbers1 = new Integer[counts];

		 
		 int index = 0;
		 for (Integer b : e) {
		     if (b != null) {
		    	 checkedNumbers1[index++] = b;
		     }
		 }
		 
		 return checkedNumbers1;
	}
	
	
	
	
	
	public static String getString(String s) {
		
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder loka = new StringBuilder();
		for(String str : s.split("(?<=\\G.{8})")) {
		    list.add(Integer.parseInt(str, 2));
		   }
		
		for(Integer l: list) {
			int i=l;    
			char ch=(char)i;
			loka.append(ch);	
		}
		
		
		return loka.toString();
		
	}
	
	
	public static String strToBinary(String s) 
    { 
        int n = s.length(); 
        StringBuilder collect = new StringBuilder();
        for (int i = 0; i < n; i++)  
        { 
            // convert each char to 
            // ASCII value 
            int val = Integer.valueOf(s.charAt(i)); 
  
            // Convert ASCII value to binary 
            String bin = ""; 
            while (val > 0)  
            { 
                if (val % 2 == 1) 
                { 
                    bin += '1'; 
                } 
                else
                    bin += '0'; 
                val /= 2; 
            } 
            bin = reverse(bin); 
            collect.append(bin);
             
        }
		return collect.toString(); 
    } 
  
    static String reverse(String input)  
    { 
        char[] a = input.toCharArray(); 
        int l, r = 0; 
        r = a.length - 1; 
  
        for (l = 0; l < r; l++, r--) 
        { 
            // Swap values of l and r  
            char temp = a[l]; 
            a[l] = a[r]; 
            a[r] = temp; 
        } 
        return String.valueOf(a); 
    } 
	
	public static int hash(String nammi) {
	long odd = 0;
	long even = 0;
	for(int i = 0; i<nammi.length(); i++) {
	     if(nammi.indexOf(nammi.charAt(i))%2==0) {
	    	 long b = (int) Math.pow(nammi.charAt(i)/5,3 );
	    	 
	    	 odd = odd^b;
	     }
	     else {
	    	 long c = (int) Math.pow(nammi.charAt(i)/5,3 );
	    	 
	    	 even = even^c;
	     }
	     
	 }
	

	String b = (even+""+odd);
	long a = Long.parseLong(b);
	if(a>65535) {		
		StringBuffer ble = new StringBuffer();
		String jamm = new StringBuilder(Long.toBinaryString(a)).reverse().toString();
		for(int i =  0; i<16; i++) {
			ble.append(jamm.charAt(i));
		}
		String jammm = ble.toString();
		
		a=Integer.parseInt(jammm,2);  		
		

	}
	
	return (int) a;
	
	}
	
	
	
	
	

}
