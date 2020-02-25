package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import contract.IView;


public class ControlPanel extends JPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public Image fond = new ImageIcon("sprites/fond.jpg").getImage();


	public ControlPanel() {
		 this.setLayout(new BorderLayout());
			JButton bouton = new JButton("Play");
		
		  bouton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			IView.counter++;
		}
		
	
});	

		  this.add(bouton,BorderLayout.SOUTH);
		  
		  revalidate();
		 repaint();
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(fond,0,0,this.getWidth(),this.getHeight(),this);
	 g.fillRect(15, 14, 30, 30);
		 
	}
}
