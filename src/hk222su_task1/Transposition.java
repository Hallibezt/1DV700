package hk222su_task1;

import java.util.ArrayList;

public class Transposition {
	private int key;
	private int keyBits;
	char [][] column;
	ArrayList<String> ofKey = new ArrayList<String>();
	
	public Transposition(int i) {
		setKey(i);
	}
	
	public void encrypt(char[] s) {
		
		if(s.length%keyBits != 0) {
			char[] temp = new char[s.length + (keyBits * (s.length%keyBits))]; 	
			for(int i = 0; i<s.length; i++) {
				temp[i] = s[i];
			}
					
			
			for(int i =0; i<temp.length-s.length; i++ ) {
				temp[s.length + i] = ' ';
			}	
			
			
			column = new char [keyBits][keyBits];
			int count = 0;	
			 while(count<temp.length) {
					for(int g = 0; g< keyBits; g++) {
						for(int h = 0; h< keyBits; h++) {
							if(count<temp.length) {	
								if(count < (s.length-(s.length%keyBits))) {
							column [g][h]=temp[count];}
								else {column [h][g]=temp[count];}
							count++;}
						}
					}
					
					for(int i = 0; i<keyBits; i++) {
						for(int j = 0; i<keyBits;i++) {
							System.out.print(column[i][j]);
						}
						System.out.println();
						
					}
						
					
			  int count2=0;      
					for(int g = 0; g< keyBits; g++) {
						String first ="";
						for(int h = 0; h< keyBits; h++) {
							if(count2 < (s.length-(s.length%keyBits))){
							first += column[h][g];	}
							else {
								first += column[g][h];
							}
							count2++;
							}
						
						ofKey.add(first);
						 first="";
						}
					
			  }
			 
			}
		else {
				column = new char [keyBits][keyBits];
			int count = 0;	
			 while(count<s.length) {
					for(int g = 0; g< keyBits; g++) {
						for(int h = 0; h< keyBits; h++) {
							if(count<s.length) {
							column [g][h]=s[count];
							count++;}
						}
					}
		
			        
					for(int g = 0; g< keyBits; g++) {
						String first ="";
						for(int h = 0; h< keyBits; h++) {						 
							first += column[h][g];						
							}
						
						ofKey.add(first);
						 first="";
						}	
			       }
		    }
		}
	
	public void decrypt(char[] s) {
			
			if(s.length%keyBits != 0) {
				char[] temp = new char[s.length + (keyBits * (s.length%keyBits))]; 	
				for(int i = 0; i<s.length; i++) {
					temp[i] = s[i];
				}
						
				
				for(int i =0; i<temp.length-s.length; i++ ) {
					temp[s.length + i] = ' ';
				}	
				
				
				column = new char [keyBits][keyBits];
				int count = 0;	
				 while(count<temp.length) {
						for(int g = 0; g< keyBits; g++) {
							for(int h = 0; h< keyBits; h++) {
								if(count<temp.length) {
									if(temp[count]!=' ') {
										column [g][h]=temp[count];}
								count++;}
							}
						}
							
						
				        
						for(int g = 0; g< keyBits; g++) {
							String first ="";
							for(int h = 0; h< keyBits; h++) {
								
								first += column[h][g];						
								}
							
							ofKey.add(first);
							 first="";
							}
						
				  }
				 
				}
			else {
					column = new char [keyBits][keyBits];
				int count = 0;	
				 while(count<s.length) {
						for(int g = 0; g< keyBits; g++) {
							for(int h = 0; h< keyBits; h++) {
								if(count<s.length) {
								column [g][h]=s[count];
								count++;}
							}
						}
			
				        
						for(int g = 0; g< keyBits; g++) {
							String first ="";
							for(int h = 0; h< keyBits; h++) {						 
								first += column[h][g];						
								}
							
							ofKey.add(first);
							 first="";
							}	
				       }
			    }
			}
		
	public String encryptedToString() {
		StringBuffer rugl = new StringBuffer();
		for(int i= 0; i<this.ofKey.size(); i++) {
			rugl.append(ofKey.get(i));
		}
		String loksins = rugl.toString();
		return loksins;
	}	
	
	public String decryptedToString() {
		StringBuffer rugl = new StringBuffer();
		for(int i= 0; i<this.ofKey.size(); i++) {			
			rugl.append(ofKey.get(i));
		}
		String loksins = rugl.toString();
		return loksins;
	}	
	
	
	private void setKey(int i) {
		this.key=i;
		this.keyBits = countBits(i);
	}		
	
	private int countBits(int n) 
    { 
        int count = 0; 
        while (n != 0) 
        { 
            count++; 
            n >>= 1; 
        } 
          
        return count; 
    } 
}
