import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Decode {
	// return the last bit of the binary string
	public static String getLastBit(String binary){
		return binary.substring(binary.length()-1);
	}
	
	// obtain the hidden message within the image
	public static void decode(String imgPath, String fileName) throws IOException{
		// error checking
		if(imgPath == null || fileName == null){
			JOptionPane.showMessageDialog(null, "Invalid file. Try again.");
			return;
		}
		
		try{
			// variable initialization and reading in image 
			BufferedImage encImg = ImageIO.read(new File(imgPath));
			int height = encImg.getHeight();
			int width = encImg.getWidth();
			int bitCount = 0;
			int rgb = 0;
			String outputText = "";
			String curChar = "";
			String srgb = "";
			char c;
			
			// access last bit of each pixel to form characters of the hidden message
			for(int h = 0; h < height; h++){
				for(int w = 0; w < width; w++){
					rgb = encImg.getRGB(w, h);
					srgb = Integer.toBinaryString(rgb);
					curChar += getLastBit(srgb);
					bitCount++;
					
					// 1 char is done
					if(bitCount == 7){
						// special char indicating end of message
						if(Integer.parseUnsignedInt(curChar, 2) == 127){
							// save decoded string to outputFile
							File outputFile = new File(fileName);
							FileWriter fw = new FileWriter(outputFile);
							fw.write(outputText);
							fw.flush();
							fw.close();
							return;
						}
						
						// concat char to message
						c = (char)Integer.parseInt(curChar, 2);
						outputText += c;
						curChar = "";
						bitCount = 0;
					}
				}
			}
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
