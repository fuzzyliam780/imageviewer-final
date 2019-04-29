import java.awt.Color;
/**
 * Write a description of class RedFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreenFilter extends Filter
{

    /**
     * Constructor for objects of class RedFilter
     */
    public GreenFilter(String name)
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
                int green = pix.getGreen();
                image.setPixel(x, y, new Color(green, green, green));
            }
        }
    }
}
