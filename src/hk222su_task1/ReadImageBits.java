package hk222su_task1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ReadImageBits {
		File img;
		ArrayList<String> red = new ArrayList<String>();	
		ArrayList<String> green = new ArrayList<String>();
		ArrayList<String> blue = new ArrayList<String>();	
		ArrayList<Integer> lsb = new  ArrayList<Integer>();	
		public ReadImageBits (String img) {
			 this.img = new File(img);
		}
		
	 

	  private  void marchThroughImage() {		  
		  try {		    	
		    	BufferedImage image = ImageIO.read(this.img);      
		     
		int w = image.getWidth();
	    int h = image.getHeight();
	    System.out.println("width, height: " + w + ", " + h);

	    for (int i = 0; i < h; i++) {
	      for (int j = 0; j < w; j++) {	        
	        int pixel = image.getRGB(j, i);	        
		    int red = (pixel >> 16) & 0xff;
		    int green = (pixel >> 8) & 0xff;
		    int blue = (pixel) & 0xff;
		    System.out.print(blue + " " + green + " " + red + " " );
		    this.red.add(Integer.toBinaryString(red));
		    System.out.print(Integer.toBinaryString(blue));
		    this.green.add(Integer.toBinaryString(green));
		    System.out.print(Integer.toBinaryString(green));
		    this.blue.add(Integer.toBinaryString(blue));
		    System.out.print(Integer.toBinaryString(red));
		    System.out.println();
	      }
	    }
	  }
	    catch (IOException e) {
		      System.err.println(e.getMessage());
		    }
	  }
	  
	  public void lsb(){
		  marchThroughImage();
		 
		  for(int i = 0; i< red.size();i++) {			  			  		  
			  lsb.add(Integer.parseInt(String.valueOf(this.blue.get(i).charAt(this.blue.get(i).length()-1))));
			  lsb.add(Integer.parseInt(String.valueOf(this.green.get(i).charAt(this.green.get(i).length()-1))));
			  lsb.add(Integer.parseInt(String.valueOf(this.red.get(i).charAt(this.red.get(i).length()-1))));		 
			 		  }		  
		  
		  
	  }
 
	  public ArrayList<String> eightBit(){
		  ArrayList<String> eightBit = new ArrayList<String>();
		  int counting=0;
		  for(int i = 0; i<lsb.size(); i++) {
				String eightBits = "";				
				for(int j = 0; j<8;j++) {
					if(counting<lsb.size()-1) {
					eightBits += lsb.get(counting);}
					counting++;
				}
				if(eightBits.contains("1")) {
				eightBit.add(eightBits);}
				eightBits = "";
			}
		  return eightBit;
	  }
	  

}
