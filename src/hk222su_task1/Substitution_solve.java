package hk222su_task1;

public class Substitution_solve {
	public static void main(String[] args) {
		
		String test = "﻿////////////////////////////////////////////////////////////////////////////////////////////////////%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%Xjhwjy%rjxxflj%2%Ytu%Xjhwjy%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//%%%%%%%%%%%%%%%%%%%%%%Rf~%tsq~%gj%wjfi%g~%xjhzwny~%ufxxji%ujwxtssjq%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%////////////////////////////////////////////////////////////////////////////////////////////////////%%%%%%Ymnx%fxxnlsrjsy%nx%inkknhzqy%ktw%f%sts2htruzyjw%xhnjshj%xj}hmfslj%xyzijsy%%%%%%%%%%%%MFN%Ynsl%\\fn%%%%%%///////////////////////////////////////////////////////////////////////////////////////////////////";
		char lala = ' ';
		
		for(int i = 0 ; i<256; i++) {
			char ble = (char) (lala+i);
			char blee = (char) (lala^i);
			System.out.print(i + " " + ble + " " + blee);
			System.out.println();		}
		
		for(int i = 0; i<test.length() ; i++) {
			char hmm = (char) (test.charAt(i)-5);
			
			
			
			System.out.print(hmm);
					}
		
		
	}

}
