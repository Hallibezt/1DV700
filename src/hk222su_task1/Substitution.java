package hk222su_task1;

import java.util.ArrayList;

public class Substitution {
	private int key;
	private Integer[] encrypted ;
	private char[] decrypted ;
		
	public Substitution(int i) {
			setKey(i);
			
		}
		
		private void setKey(int i) {
			this.key=i;
		}	
		
		public void encrypt(char[] s) {	
			encrypted = new Integer[s.length];
			for(int i = 0; i<s.length; i++) {
				if(s[i]!= '\n') 
				encrypted[i]= (int) (s[i]^key);				
			}
		}
		
		public void decrypted(ArrayList<Integer> s) {	
			decrypted = new char[s.size()];
			for(int i = 0; i<s.size(); i++) {
				if(s.get(i)== -1) 
					decrypted[i]= '\n';				
				else
					decrypted[i]= (char) (s.get(i)^key);
			}
		}
		
		public String toDecrypted() {
			StringBuffer test = new StringBuffer();
			for(int i=0; i<decrypted.length;i++) {				
				test.append(decrypted[i]);
			}
			String a = test.toString();
			return a;
		}
		
		
		public String toEncrypted() {
			StringBuffer test = new StringBuffer();
			for(int i=0; i<encrypted.length;i++) {
				if(encrypted[i]== null)
					test.append("\n");
				else
				test.append(encrypted[i]+" ");
			}
			String a = test.toString();
			return a;
		}	
		 
		
		
		
}
