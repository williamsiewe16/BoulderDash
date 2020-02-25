package Element;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import model.Model;

 
/**
 * The Class Hero.
 *
 * @author Group7
 */
public class Hero extends mobileElement{
	
	/** The freeze boolean*/
	private boolean freeze;
	
	/** The death boolean*/
	private boolean dead;
	
	/** The winning boolean*/
	private boolean win;
	
	/** The death counter*/
	public int death_counter;
	
	
	
	
	/**	
	 * Instantiates a new Hero
	 * 
	 */
	public Hero() {
		this.x=6*32;
		this.y=6*32;
		this.setMoveup(true);
		this.setMoveright(true);
		this.setMovedown(true);
		this.setMoveleft(true);
	    this.freeze=false;
	    this.dead=false;
	    this.win=false;
	    death_counter=0;
		this.setImage(new ImageIcon("sprites/hero.png").getImage());
	}
	
	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	/**	
	 * Instantiates a new Hero
	 * 
	 * @param
	 *      the int x
	 * @param
	 *      the int y
	 */
	public Hero(int x,int y) {
		this.x=x;
		this.y=y;
		this.setMoveup(true);
		this.setMoveright(true);
		this.setMovedown(true);
		this.setMoveleft(true);
	    this.freeze=false;
		this.setImage(new ImageIcon("sprites/hero.png").getImage());
	}

	/**
	 *  Digs the ground
	 */
	public void dig (){
		for(int i=0;i<25;i++) {
			for(int j=0; j<37; j++) {
				    if(Model.scene[i][j].getClass().toString().equals(new Ground().getClass().toString())) {
					//System.out.println(Model.scene[i][j].toString());
					    if(this.getX()==Model.scene[i][j].getX() && this.getY()==Model.scene[i][j].getY()) {
					    	int a = Model.scene[i][j].getX();
					    	int b= Model.scene[i][j].getY();
					    	Model.scene[i][j]= new Darkground();
					    	Model.scene[i][j].setX(a);
					    	Model.scene[i][j].setY(b);
					    	
					      break;
				      }
			}
				    else if(Model.scene[i][j].getClass().toString().equals(new Diamond().getClass().toString())) {
						//System.out.println(Model.scene[i][j].toString());  
				    	if(this.getX()==Model.scene[i][j].getX() && this.getY()==Model.scene[i][j].getY()) {
						    	int a = Model.scene[i][j].getX();
						    	int b= Model.scene[i][j].getY();
						    	Model.allDiamonds.remove(Model.scene[i][j]);
						    	Model.scene[i][j]= new Darkground();
						    	Model.scene[i][j].setX(a);
						    	Model.scene[i][j].setY(b);
						    	Model.score+=20;
						    	
						    	Timer t = new Timer();
						    	t.schedule(new TimerTask() {
						    		public void run() {
						    			Music.Play("music/coin.wav");
						    			t.cancel();
						    		}
						    	}, 0,100);
						    	
						      break;
					      }
				    	
				}
		}		
}
}
	
	/**
	 * 
	 * @param x
	 *       The new x.
	 */
     public void setX(int x) {
		
			if(this.isMoveleft()==true) {
			
				if(
					(x < 16*32-4*32 && x > 3*32) || 
					((x >= 16*32-4*32 || x <= 3*32) && (Model.scene[0][0].getX() == 0) && (this.x < 8*32)) ||
					((x >= 16*32-4*32 || x <= 3*32) && (Model.scene[0][36].getX() == 15*32) && (this.x > 8*32))
			            
				) {
					
				freeze=false;
				this.x = x;		
				//System.out.println("oui");
				}
		
		else {
				freeze=true;
			}
		}
    	 
			else if(this.isMoveright()==true) {
				if(
						(x < 16*32-4*32 && x > 3*32) || 
						((x >= 16*32-4*32 || x <= 3*32) && (Model.scene[0][0].getX() == 0) && (this.x < 8*32)) ||
						((x >= 16*32-4*32 || x <= 3*32) && (Model.scene[0][36].getX() == 15*32) && (this.x > 8*32))
			     ) {
				freeze=false;
				this.x = x;		
				//System.out.println("oui");
				}
		
		else {
				freeze=true;
			}
		}
		
		
		
	}
    
     /**
  	 * Gets the freeze value
  	 * 
  	 * @return the freeze boolean
  	 */
 	public boolean isFreeze() {
		return freeze;
	}

 	
	/**
	 * 
	 * @param freeze
	 *          the new freeze value
	 */
	public void setFreeze(boolean freeze) {
		this.freeze = freeze;
	}

	/**
 	 * 
 	 * @param y
 	 *       The new y.
 	 */
 	public void setY(int y) {
 		if(this.dead==false) {
 		if(this.isMoveup()==true) {
			
			if(
				(y < 16*32-4*32 && y > 3*32) || 
				((y >= 16*32-4*32 || y <= 3*32) && (Model.scene[0][0].getY() == 0) && (this.y < 8*32)) ||
				((y >= 16*32-4*32 || y <= 3*32) && (Model.scene[24][0].getY() == 15*32) && (this.y > 8*32))
		            
			) {
				
			freeze=false;
			this.y = y;		
			//System.out.println("oui");
			}
	
	else {
			freeze=true;
		}
	}
	 
		else if(this.isMovedown()==true) {
			if(
					(y < 16*32-4*32 && y > 3*32) || 
					((y >= 16*32-4*32 || y <= 3*32) && (Model.scene[0][0].getY() == 0) && (this.y < 8*32)) ||
					((y >= 16*32-4*32 || y <= 3*32) && (Model.scene[24][0].getY() == 15*32) && (this.y > 8*32))
		     ) {
			freeze=false;
			this.y = y;		
			//System.out.println("oui");
			}
	
	else {
			freeze=true;
		}
	}
 }
 		else
 			this.y=y;

 	}
 	
 	
 	public void push(String direction) {
 
 			if(direction == "left") {
 				int a=0;
 				int i=this.getIndex_i();
 				int j=this.getIndex_j()-2;
 			    
 				int x1=this.getX()-32;
 				int x2=this.getX()-64;
 				
 				if(Model.scene[i][j].getClass().toString().equals(new Darkground().getClass().toString())) {
 			    
 				for(a=0;a<Model.allRocks.size();a++) {
 					if(Model.allRocks.get(a).getIndex_i()==i && Model.allRocks.get(a).getIndex_j()==j+1) {
 						break;
 					};
 				}
 				
 				Model.scene[i][j] = new Rock();
 				Model.scene[i][j+1] = new Darkground();
 				
 Model.scene[i][j+1].setX(x1);  Model.scene[i][j+1].setY(this.getY());				
 Model.scene[i][j].setX(x2);  Model.scene[i][j].setY(this.getY());
 this.setX(x1);  this.setY(this.getY());
 				
 				Model.allRocks.set(a, (Rock) Model.scene[i][j]);
 				
 			}
 		 }
 			
 			else if(direction == "right") {
 			
 				int a=0;
 				int i=this.getIndex_i();
 				int j=this.getIndex_j()+2;
 			    
 				int x1=this.getX()+32;
 				int x2=this.getX()+64;
 				
 				if(Model.scene[i][j].getClass().toString().equals(new Darkground().getClass().toString())) {
 			    
 				for(a=0;a<Model.allRocks.size();a++) {
 					if(Model.allRocks.get(a).getIndex_i()==i && Model.allRocks.get(a).getIndex_j()==j-1) {
 						break;
 					};
 				}
 				
 				Model.scene[i][j] = new Rock();
 				Model.scene[i][j-1] = new Darkground();
 				
 Model.scene[i][j-1].setX(x1);  Model.scene[i][j-1].setY(this.getY());				
 Model.scene[i][j].setX(x2);  Model.scene[i][j].setY(this.getY());
 this.setX(x1);  this.setY(this.getY());
 
 				Model.allRocks.set(a, (Rock) Model.scene[i][j]);
 				
 			}
 				
 		}
 
 		
 	}

	@Override
	public void fixBooleans(int pos, Hero hero) {
		// TODO Auto-generated method stub
		
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
		this.setImage(new ImageIcon("sprites/persoface3.png").getImage());
	}

	
}