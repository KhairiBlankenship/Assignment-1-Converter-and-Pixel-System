import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;

public class PrintPix {

    public static String convert(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        
        if (red == 0 && green == 0 && blue == 0) { return "B";
        } else if (red == 111 && green == 49 && blue == 152) { return "P";
        } else if (red == 0 && green == 183 && blue == 239) { return "S";
        } else { return "(" + red + ", " + green + ", " + blue + ")"; }
}
public static void main(String[] args) throws IOException {
    PrintWriter outputFile = new PrintWriter("output.txt");
    BufferedImage imageFile = ImageIO.read(new File("./frown.png"));
    int width = imageFile.getWidth();
    int height = imageFile.getHeight();
    for (int y = 0; y < height; y++) {
    for (int x = 0; x < width; x++) {
    Color color = new Color(imageFile.getRGB(x, y));
    String convertedColor = convert(color);
    outputFile.print(convertedColor);
    outputFile.print(" ");
}
outputFile.println();
}
outputFile.close();
}
}