import java.awt.Color;
/**
 * Creates the worhol effect.
 *
 * @author Liam Marquis
 * @version 4/29/19
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
        OFImage currentImage = new OFImage(image);
        if(currentImage != null) {
            // create new image with double size
            int width = currentImage.getWidth() / 2;
            int height = currentImage.getHeight() / 2;
            OFImage newImage = new OFImage(width, height);

            // copy pixel data into new image
            for(int y = 0; y < height; y++) {
                for(int x = 0; x < width; x++) {
                    newImage.setPixel(x, y, currentImage.getPixel(x * 2, y * 2));
                }
            }
            
            currentImage = newImage;
        }
        
        /*  
        OFImage normalImage = new OFImage(image);
        int height = image.getHeight();
        int width = image.getWidth();
        int half_height = normalImage.getHeight()/2;
        int half_width = normalImage.getWidth()/2;
        
        OFImage newImage = new OFImage(half_width,half_height);
        
        
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                if (x == width){
                    System.out.println("Hio");
                }
                
                Color pix = normalImage.getPixel(x, y);
                int red = pix.getRed();
                int green = pix.getGreen();
                int blue = pix.getBlue();
                newImage.setPixel(x, y, normalImage.getPixel(x*2, y*2));
                
            }
            if (y == 1){
                    System.out.println("Hio");
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
        image = newImage;*/
    }
}
