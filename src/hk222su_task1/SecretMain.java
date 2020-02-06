package hk222su_task1;
public class SecretMain {
	public static void main(String[] args) {
	ReadImageBits secret = new ReadImageBits("/home/haraldur/Desktop/Skolinn/1DV700/Secret.bmp");
	secret.lsb();
	System.out.print(secret.eightBit());

	char h = 'K';
	int hb = 45;
	
	System.out.println((char)(h^hb));
	
	}
}
