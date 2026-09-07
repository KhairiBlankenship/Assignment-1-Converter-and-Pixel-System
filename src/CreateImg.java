import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class CreateImg {

    public static Color convert(String pixel) {
     
        if (pixel.equals("B")) { return new Color(0, 0, 0);
        } else if (pixel.equals("P")) { return new Color(111, 49, 152);
        } else if (pixel.equals("S")) { return new Color(0, 183, 239);
        } else { return null; }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new FileReader("input.txt"));

        String line;
        int height = 0;
        int width = 0;

         while ((line = input.readLine()) != null) {

            if (!line.trim().isEmpty()) {
                height++;

                String[] pixels = line.trim().split("\\s+");

                if (pixels.length > width) {
                    width = pixels.length;
                }
            }
        }

        input.close();

        BufferedImage image = new BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_RGB
        );

        input = new BufferedReader(
            new FileReader("input.txt")
        );

        int y = 0;

        while ((line = input.readLine()) != null) {

            if (line.trim().isEmpty()) {
                continue;
            }

            String[] pixels = line.trim().split("\\s+");

            for (int x = 0; x < pixels.length; x++) {

                Color color = convert(pixels[x]);

                image.setRGB(x, y, color.getRGB());
            }

            y++;
        }

        input.close();

        ImageIO.write(
            image,
            "png",
            new File("newimage.png")
        );
    }
}
    
