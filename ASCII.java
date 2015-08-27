import java.util.Scanner;

public class ASCII {

	// print an array of booleans as 1s and 0s
	private static void printBooleanArray(boolean[] bits) {
	    for (int i = 0; i < bits.length; i++) {
	        // print a 1 for true or 0 for false
	        if (bits[i]) System.out.print("1");
	        else         System.out.print("0");
	    }

	    System.out.println(); // add a newline
	}
	
	public static void main(String[] args) {
		// testing encode
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
	    boolean[] bits = encode(input);
	    printBooleanArray(bits);

	    // testing decode
	    String s = decode(bits);
	    System.out.println(s);
	    reader.close();
	}

	public static boolean[] encode(String msg){
		if(msg == null)
			return null;
		
		int size = msg.length();
		boolean[] res = new boolean[7*size];
		int resIndex = 0;
		for(int i = 0; i < size; i++){
			char c = msg.charAt(i);
			int t = (int)c;
			String binary = Integer.toBinaryString(t);
			if(binary.length() < 7)
				binary = "0" + binary;
			for(int j = 0; j < binary.length(); j++){
				if(binary.charAt(j) == '1')
					res[resIndex] = true;
				else
					res[resIndex] = false;
				resIndex++;
			}
		}
		return res;
	}
	
	public static String decode(boolean[] bits){
		if(bits == null)
			return null;
		
		int numChars = bits.length/7;
		String res = "";
		for(int i = 0; i < numChars; i++){
			int binNum = 0;
			for(int j = 0; j < 7; j++){
				if(bits[i*7 + j] == true)
					binNum += 1;
				if(j != 6)
					binNum <<= 1;
			}
			res += (char)binNum;
		}	
		return res;
	}
}
