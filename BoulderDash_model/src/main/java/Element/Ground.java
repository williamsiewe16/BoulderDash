package Element;

import javax.swing.ImageIcon;

/**
 * The Class Ground.
 *
 * @author Group7
 */
public class Ground extends motionlessElement{

	public Ground() {
		this.setImage(new ImageIcon("sprites/ground.png").getImage());
	}
	
	public Ground(int x,int y) {
		this.x=x;
		this.y=y;
	}
}
