import java.awt.Color;
/**
 * Singles out the blue channel.
 *
 * @author Liam Marquis
 * @version 4/29/19
 */
public class BlueFilter extends Filter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class BlueFilter
     */
    public BlueFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int blue = pix.getBlue();
                image.setPixel(x, y, new Color(blue, blue, blue));
            }
        }
    }
}
