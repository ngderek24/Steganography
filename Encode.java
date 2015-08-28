import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Encode {
	// read in the text of file line by line
	public static String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	    	// read each line of input text file
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	// encode message into the image
	public static void encode(String imgName, String imgPath, String fileName) throws IOException {
		try{
			// error checking
			if(imgName == null || imgPath == null || fileName == null){
				JOptionPane.showMessageDialog(null, "Invalid file. Try again.");
				return;
			}
			
			// parse input text
			String text = readFile(fileName);
			boolean[] textBits = ASCII.encode(text);
			
			// set up images
			BufferedImage inImg = ImageIO.read(new File(imgPath));
			int height = inImg.getHeight();
			int width = inImg.getWidth();
			BufferedImage outImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			
			// change each pixel
			int rgb = 0;
			int newRGB = 0;
			int index = 0;
			for(int h = 0; h < height; h++){
				for(int w = 0; w < width; w++){
					// get rgb value of each pixel
					rgb = inImg.getRGB(w, h);
					String srgb = Integer.toBinaryString(rgb);
					
					// change pixel bit
					if(index < textBits.length){
						if(textBits[index])
							srgb = srgb.substring(0, srgb.length()-1) + "1";
						else
							srgb = srgb.substring(0, srgb.length()-1) + "0";
						index++;
					}
					
					// set rgb value of outImg
					newRGB = Integer.parseUnsignedInt(srgb, 2);
					outImg.setRGB(w, h, newRGB);
				}
			}
			
			// save encoded image 
			File outputFile = new File(imgName);
			ImageIO.write(outImg, "png", outputFile);
			
		} catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
