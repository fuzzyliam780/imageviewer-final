import java.awt.Color;
/**
 * Creates the worhol effect.
 * 
 * @author Liam Marquis
 * @version 5/5/19
 */
public class Warhol extends Filter
{

    /**
     * Constructor for objects of class Warhol
     */
    public Warhol(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        OFImage currentImage = new OFImage(image);
        int full_width = currentImage.getWidth();
        int full_height = currentImage.getHeight();
        int half_width = currentImage.getWidth() / 2;
        int half_height = currentImage.getHeight() / 2;
        OFImage quarterImage = new OFImage(half_width, half_height);
        OFImage newImage = new OFImage(full_width, full_height);
        // size down currentImage to 1/4 size
        for(int y = 0; y < half_height; y++) {
            for(int x = 0; x < half_width; x++) {
                quarterImage.setPixel(x, y, currentImage.getPixel(x / 2, y / 2));
            }
        }
        //add current picture at 1/4 size to top left
        for(int y = 0; y < half_height; y++) {
            for(int x = 0; x < half_width; x++) {
                newImage.setPixel(x, y, quarterImage.getPixel(x, y));
            }
        }
        //add current picture at 1/4 size to top right in red
        for(int y = 0; y < half_height; y++) {
            for(int x = 0; x < half_width; x++) {
                Color pix = quarterImage.getPixel(x, y);
                int red = pix.getRed();
                newImage.setPixel(x+half_width, y, new Color(red, red, red));
            }
        }
        //add current picture at 1/4 size to bottom left in green
        for(int y = 0; y < half_height; y++) {
            for(int x = 0; x < half_width; x++) {
                Color pix = quarterImage.getPixel(x, y);
                int green = pix.getGreen();
                newImage.setPixel(x, y+half_height, new Color(green, green, green));
            }
        }
        //add current picture at 1/4 size to bottom right in blue
        for(int y = 0; y < half_height; y++) {
            for(int x = 0; x < half_width; x++) {
                Color pix = quarterImage.getPixel(x, y);
                int blue = pix.getBlue();
                newImage.setPixel(x+half_width, y+half_height, new Color(blue, blue, blue));
            }
        }
        currentImage = newImage;
    }
}
