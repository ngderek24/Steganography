public class ASCII {
	// given a binary string, return bool array representation with true = 1 and false = 0
	public static boolean[] encode(String msg){
		// error checking
		if(msg == null)
			return null;
		
		int size = msg.length();
		boolean[] res = new boolean[7*(size+1)];
		int resIndex = 0;
		for(int i = 0; i < size; i++){
			// get each char and get its binary representation
			char c = msg.charAt(i);
			String binary = Integer.toBinaryString((int)c);
			
			// length of binary of each char must be 7
			while(binary.length() < 7)
				binary = "0" + binary;
			
			// set array according to bit of char
			for(int j = 0; j < binary.length(); j++){
				if(binary.charAt(j) == '1')
					res[resIndex] = true;
				else
					res[resIndex] = false;
				resIndex++;
			}
		}
		
		// add special char at the end of document
		for(int k = 0; k < 7; k++){
			res[resIndex] = true;
			resIndex++;
		}
		return res;
	}
	
}
