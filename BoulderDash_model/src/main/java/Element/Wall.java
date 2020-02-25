package Element;

import javax.swing.ImageIcon;

/**
 * The Class Wall.
 *
 * @author Group7
 */
public class Wall extends motionlessElement{

	/**
	 * Instantiates a new Wall
	 */
	public Wall() {
		this.setImage(new ImageIcon("sprites/wall.png").getImage());
	}
	
	public Wall(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

