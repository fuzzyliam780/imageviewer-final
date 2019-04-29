import java.awt.Color;
/**
 * Write a description of class ColoredCorners here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ColoredCorners extends Filter
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class ColoredCorners
     */
    public ColoredCorners(String name)
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
        
        OFImage normalImage = new OFImage(image);
        int height = image.getHeight();
        int width = image.getWidth();
        int heightx2 = normalImage.getHeight()*2;
        int widthx2 = normalImage.getWidth()*2;
        
        OFImage newImage = new OFImage(widthx2,heightx2);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = normalImage.getPixel(x, y);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                newImage.setPixel(x, y, new Color(red, 0, 0));
                
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = normalImage.getPixel(x, y);
                int red = pix.getRed();
                newImage.setPixel(x+width, y, new Color(red, 0, 0));
                
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = normalImage.getPixel(x, y);
                int green = pix.getGreen();
                newImage.setPixel(x+width, y, new Color(0, green, 0));
                
            }
        }
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = normalImage.getPixel(x, y);
                int blue = pix.getBlue();
                newImage.setPixel(x+width, y+height, new Color(0, 0, blue));
                
            }
        }
        image = newImage;
    }
}
