package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import Element.Darkground;
import Element.Diamond;
import Element.Element;
import Element.Ground;
import Element.Monster;
import Element.Rock;
import Element.Star;
import Element.Wall;
import contract.IModel;
import contract.IView;
import controller.Controller;
import controller.KeyBoard;
import model.Model;

/**
 * The Class ViewPanel.
 *
 * @author Group7
 */
public class ViewPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2089277706951212544L;

	/** The counter to die one time */
	public int dieOneTime = 0;
	
	/** The score */
	public int score = 0;
	
	/**
	 * Instantiates a new view panel.
	 *
	 */
	public ViewPanel() {
		Model.scene = new Element[25][37];
		Model.allRocks=new ArrayList<Rock>();
		Model.allMonsters=new ArrayList<Monster>();
        Model.allDiamonds=new ArrayList<Diamond>();
        Model.allDarkGrounds=new ArrayList<Darkground>();
        for( int i=0;i<25;i++) {
        	 System.out.print(i+"   ");	
		    for(int j=0;j<37;j++) {
		    System.out.print(j+" "+Model.scene[i][j]);	
		    }
		    System.out.println();	
    }
		fillScene();
	}
	
	/**
	 *  fill the table scene
	 */
	public void fillScene() {
          int i=0, j=0;  
          
		for(i=0;i<25;i++) {
			    for(j=0;j<37;j++) {
			    	//System.out.print(Controller.sceneCharacters[i][j]);
			    	if(Controller.sceneCharacters[i][j] == 'G') {
			    	Model.scene[i][j]=new Ground(); 
			    	}
			    	
			    	else if(Controller.sceneCharacters[i][j] == 'W') {
			    		Model.scene[i][j]=new Wall();   
				    	}
			    	
			    	else if(Controller.sceneCharacters[i][j] == 'O') {
			    		Model.scene[i][j]=new Rock(); 
			    		Model.allRocks.add((Rock) Model.scene[i][j]);
				    	}
			    	
			    	else if(Controller.sceneCharacters[i][j] == 'M') {
			    		Model.scene[i][j]=new Monster(); 
			    	    Model.allMonsters.add((Monster) Model.scene[i][j]);
				    	}
			    	
			    	else if(Controller.sceneCharacters[i][j] == '*') {
			    		Model.scene[i][j]=new Diamond(); 
			    		Model.allDiamonds.add((Diamond) Model.scene[i][j]);
				    	}
			    	else if(Controller.sceneCharacters[i][j] == ' ') {
			    		Model.scene[i][j]=new Darkground(); 
				    	}
			    	
			    	else {
			    		Model.scene[i][j] = new Ground();
			    	}
			    	
			    	Model.scene[i][j].setX(32*j);
			    	Model.scene[i][j].setY(32*i);
			}
			IView.diamondCounter++;
        }
	}
	
	

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics g) {
		
if(KeyBoard.hero != null) {

	/* draw the scene */
		for(int i=0;i<25;i++) {
			for(int j=0;j<37;j++) {
				g.drawImage(Model.scene[i][j].getImage(),Model.scene[i][j].getX(),Model.scene[i][j].getY(),this);
			}
		}
	/* draw the hero */	
		g.drawImage(KeyBoard.hero.getImage(),KeyBoard.hero.getX(),KeyBoard.hero.getY(),this);
		
		
     	  if(KeyBoard.hero.isDead()==false) {  
			   
     	    /* fix rocks booleans */
    		  for(int a=0;a<Model.allRocks.size();a++) {
    			    if(KeyBoard.hero != null)
    	            Model.allRocks.get(a).fixBooleans(a,KeyBoard.hero);
    			   }
    		  
    		  //System.out.println(Model.allRocks.get(2).getX()+" "+Model.allRocks.get(2).getY());


    	   /* fix diamonds booleans */	  
    		  for(int b=0;b<Model.allDiamonds.size();b++) {
    			  if(KeyBoard.hero != null)
    	            Model.allDiamonds.get(b).fixBooleans(b,KeyBoard.hero);
    		  }
    		  
	          if(Model.allMonsters.isEmpty()==false) {
       		  for(int b=0;b<Model.allMonsters.size();b++) {
       			  if(KeyBoard.hero != null)
       	            Model.allMonsters.get(b).collision(b);
       		  }
	          }
       		  
       		// System.out.println(Model.allDiamonds.size());
       		 
       		 if(14-Model.score/20<=0) {
       			Font font = new Font("Courier", Font.BOLD, 20); 
				g.setFont(font); 
				g.setColor(Color.GRAY); 
				g.drawString("EXIT",100, 30);
				Model.placeGate();
				
				if(Model.i_gate==KeyBoard.hero.getIndex_i() && Model.j_gate==KeyBoard.hero.getIndex_j()) {
					KeyBoard.hero.setWin(true);
					Font font1 = new Font("Courier", Font.BOLD, 40); 
					g.setFont(font1); 
					g.setColor(Color.GREEN); 
					g.drawString("YOU WIN",this.getWidth()/2-100,this.getHeight()/2);
				}
				
       		 }
       		 
       		 
    		  InfoLayout(g);
			 
		  try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		  }
	
		  else if(KeyBoard.hero.isDead()==true) {
			  Font font = new Font("Courier", Font.BOLD, 40); 
				g.setFont(font); 
				g.setColor(Color.red); 
				g.drawString("YOU LOSE", IView.WIDTH/2-100, IView.HEIGHT/2);
				
			if(dieOneTime == 0) { 
			Die(g,this);
			}
			dieOneTime++;
	      }
     	  
  }	
		repaint();
}
	
	/**
	 *  Sets the layout of the score, the remaining diamonds and time
	 *  
	 *  @param g
	 *      The graphics object
	 */
	public void InfoLayout(Graphics g) {
		
		Font font = new Font("Courier", Font.BOLD, 20); 
			g.setFont(font); 
			g.setColor(Color.BLACK);
		    g.fillRoundRect(IView.WIDTH/2-20, 8, 48, 28, 20, 20);
		    g.fillRoundRect(IView.WIDTH-110, 5, 58, 28, 20, 20);
		    g.fillRoundRect(IView.WIDTH-115, 40, 63, 28, 20, 20);
		    g.setColor(Color.BLUE);
		    g.drawRoundRect(IView.WIDTH/2-20, 8, 48, 28, 20, 20);
		    g.drawRoundRect(IView.WIDTH-110, 5, 58, 28, 20, 20);
		    g.drawRoundRect(IView.WIDTH-115, 40, 63, 28, 20, 20);
			g.setColor(Color.WHITE); 
			g.drawString(Integer.toString(Model.score), IView.WIDTH-280, 29);
			
			if(14-Model.score/20>=0)
			   g.drawString(Integer.toString(14-Model.score/20), 3*IView.WIDTH/2-343, 27);
			else
				g.drawString(Integer.toString(0), 3*IView.WIDTH/2-343, 27);
			g.drawString(Integer.toString(IModel.time), 3*IView.WIDTH/2-350, 61);
			
			g.drawImage(new ImageIcon("sprites/diam_icon.png").getImage(),3*IView.WIDTH/2-368, 12, this);
			g.drawImage(new ImageIcon("sprites/horloge_icon.png").getImage(),3*IView.WIDTH/2-374, 45, this);
	}
	
	/**
	 * The hero dies
	 * 
	 * @param g
	 *       the graphics g
	 * @param panel 
	 *       the panel 
	 */
public static void Die(Graphics g, JPanel panel) {
		
	int a=0, b=0;
	final int x=KeyBoard.hero.getIndex_i()-1, y=KeyBoard.hero.getIndex_j()-1;
	
	for(int i=x;i<x+3;i++) {
		for(int j=y;j<y+3;j++) {
			if(!Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString())) {
			    a=Model.scene[i][j].getX();
		        b=Model.scene[i][j].getY();
		        
	          	     Model.scene[i][j] = new Star();
	          	     
	          	Model.scene[i][j].setX(a);
	        	Model.scene[i][j].setY(b);
			} 	
		}
	}
	       
		final Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			public void run() {
				
				if(KeyBoard.hero.death_counter%2==0) {
					KeyBoard.hero.setImage(new ImageIcon("sprites/persomort.png").getImage());
					
					
					int a=0, b=0;	
					for(int i=x;i<x+3;i++) {
						for(int j=y;j<y+3;j++) {
							if(!Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString())) {
								if(KeyBoard.hero.death_counter<5) {
								Model.scene[i][j].setImage(new ImageIcon("sprites/upstar.png").getImage());
								}
								else {
									a=Model.scene[i][j].getX();
							        b=Model.scene[i][j].getY();
							        
						          	     Model.scene[i][j] = new Darkground();
						          	     
						          	Model.scene[i][j].setX(a);
						        	Model.scene[i][j].setY(b);
								}
							}
						}				
				}
					if(KeyBoard.hero.death_counter<2) {
				    KeyBoard.hero.setY(KeyBoard.hero.getY()-32);
					}
					else if(KeyBoard.hero.death_counter>=2) {
						 KeyBoard.hero.move('D');
					}
				}
				else if(KeyBoard.hero.death_counter%2==1) {
					KeyBoard.hero.setImage(new ImageIcon("sprites/persomort2.png").getImage());
					
					int a=0, b=0;	
					for(int i=x;i<x+3;i++) {
						for(int j=y;j<y+3;j++) {
							if(!Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString())) {
								if(KeyBoard.hero.death_counter<5) {
								Model.scene[i][j].setImage(new ImageIcon("sprites/downstar.png").getImage());
								}
								else {
									a=Model.scene[i][j].getX();
							        b=Model.scene[i][j].getY();
							        
						          	     Model.scene[i][j] = new Darkground();
						          	     
						          	Model.scene[i][j].setX(a);
						        	Model.scene[i][j].setY(b);
								}
							}
						}
				}

					if(KeyBoard.hero.death_counter>=2) {
			          KeyBoard.hero.setY(KeyBoard.hero.getY()+32);
					}
					else if(KeyBoard.hero.death_counter<2) {
					    KeyBoard.hero.move('U');
						}
				}
				
				KeyBoard.hero.death_counter++;
				
					if(KeyBoard.hero.getY()/32 > 25) {
						IView.counter=0;
						Model.placeGateCounter=0;
						t.cancel();
					}
			}
		},0,120);
		
 }

}