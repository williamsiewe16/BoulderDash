package Element;


import java.awt.Image;

import javax.swing.ImageIcon;

public enum diamondState {
	
	diam1 (new ImageIcon("sprites/diam1.png").getImage()),
	diam2 (new ImageIcon("sprites/diam2.png").getImage()),
	diam3 (new ImageIcon("sprites/diam3.png").getImage()),
    diam4 (new ImageIcon("sprites/diam4.png").getImage());
	
	private Image image=null;
	
   diamondState(Image image){  
		this.image=image; 
		}
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}   
	
    


}
