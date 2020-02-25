package view;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Element.Music;
import contract.IView;
import controller.KeyBoard;


/**
 * The Class ViewFrame.
 *
 * @author Group7
 */

@SuppressWarnings("serial")
public class ViewFrame extends JFrame {

	
	/** The Control panel. */
	private ControlPanel controlPanel;

/** The View panel. */
	private ViewPanel viewPanel;
	
	/** The first counter. */
	private int counter1;


	
	
/**
	 * Instantiates a new view frame.
	 */
	public ViewFrame() {
		this.buildViewFrame();
	}


	/**
	 * Builds the view frame.
	 *
	 */
	private void buildViewFrame() {
        this.choosePan();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BoulderDash");
		//this.setContentPane(new ViewPanel());
		this.setResizable(false);
	   // this.addKeyListener(new KeyBoard());
		this.setSize(IView.WIDTH,IView.HEIGHT);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	/**
	 * 
	 * @param pan
	 *       The new Panel
	 */
	public void setContentPanel(JPanel pan) {
		this.setContentPane(pan);
		//System.out.println("a");
		repaint();
		revalidate();
		counter1=0;
	}
	
	public void choosePan() {
	Timer timer=new Timer();	
	timer.schedule(new TimerTask(){ 
		public void run(){
		if(IView.counter%2==0) {
	         
			controlPanel = new ControlPanel();
			setContentPanel(controlPanel);
			/* Music */
			Music.FirstPlay("music/game.wav");
		}
		
		else if(IView.counter%2==1) {
			if(counter1==0) {
			viewPanel = new ViewPanel();
			setContentPanel(viewPanel);
			viewPanel.addKeyListener(new KeyBoard());
			viewPanel.setFocusable(true);
			viewPanel.requestFocusInWindow();
			revalidate();
			repaint();
			counter1++;
			}
		}			
      }
	},0, 500);
  }
}
