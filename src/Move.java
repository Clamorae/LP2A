import java.awt.*;
import java.awt.image.BufferedImage;


class Move extends Component {

    public static BufferedImage toBufferedImage(Image img, int X, int Y)
    {
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, X, Y, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}