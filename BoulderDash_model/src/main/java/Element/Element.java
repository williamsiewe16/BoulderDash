package Element;

import java.awt.Image;
import model.Model;

/**
 * The Class Element.
 *
 * @author Group7
 */
public abstract class Element {

	/**The x coordinate*/
	protected int x;
	
	/**The y coordinate*/
    protected int y;
    
    /**The image*/
    protected Image image;


   
    
    /**
     * Gets the x coordinate.
     * 
     * @return the integer x
     */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 *       The new x.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
     * Gets the y coordinate.
     * 
     * @return the integer y
     */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 *       The new y.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
     * Gets the image.
     * 
     * @return the image
     */
	public Image getImage() {
		return image;
	}

	/**
	 * 
	 * @param image
	 *       The new image.
	 */
	public void setImage(Image image) {
		this.image = image;
	}
    
	public int getIndex_i(){
 		return (this.getY()+Model.getLag_T())/32; 
 	}
 	
	public int getIndex_j(){
 		return (this.getX()+Model.getLag_L())/32; 
 	}
	
	
}
