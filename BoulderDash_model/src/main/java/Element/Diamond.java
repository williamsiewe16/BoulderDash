package Element;

import contract.IModel;
import model.Model;

/**
 * The Class Diamond.
 *
 * @author Group7
 */
public class Diamond extends mobileElement{
	
	/** The blocking left boolean*/
	public boolean blocking_L=true;
	
	/** The blocking right boolean*/
	public boolean blocking_R=true;
	
	/** The blocking down boolean*/
	public boolean blocking_D=true;
	
	/** The blocking left down boolean*/
	public boolean blocking_LD=true;
	
	/** The blocking right down boolean*/
	public boolean blocking_RD=true;
	
	/** The carried boolean*/
	public boolean carried=false;
	
	/** The speed */
	public int speed=0;
	

	/** The state*/
	private diamondState state;
	
	public Diamond() {
		this.setState(diamondState.diam1);
		//this.setImage(new ImageIcon("sprites/diam1.png").getImage());
	}
	
	public Diamond(int x,int y) {
		this.x=x;
		this.y=y;
		
	}
	
	
	public diamondState getState() {
		return state;
	}

	public void setState(diamondState state) {
		this.state = state;
		this.image = state.getImage();
	}

	/**
	 * fix the booleans' values
	 * @param pos 
	 *         the position
	 * @param hero
	 *        the hero
	 */
	public void fixBooleans(int pos, Hero hero) {
		
		 if(
				 (this.speed!=0 && this.getIndex_i()+1==hero.getIndex_i() && this.getIndex_j()==hero.getIndex_j()) ||
				 IModel.time==0
		   ) {
			 hero.setDead(true);
		 }
		 
		 /* Blocking_D && carried*/
		if(
				Model.scene[this.getIndex_i()+1][this.getIndex_j()].getClass().toString().equals(new Wall().getClass().toString()) ||
				Model.scene[this.getIndex_i()+1][this.getIndex_j()].getClass().toString().equals(new Ground().getClass().toString())  ||
				Model.scene[this.getIndex_i()+1][this.getIndex_j()].getClass().toString().equals(new Monster().getClass().toString())
		  ) {
			this.blocking_D=true;
			this.carried=false;
			this.speed=0;
		}else {
			if(Model.scene[this.getIndex_i()+1][this.getIndex_j()].getClass().toString().equals(new Darkground().getClass().toString())) {
			this.blocking_D=false; this.carried=false;
			}else {
				this.blocking_D=false;	this.carried=true; this.speed=0;
			}
		}
		
		/* carried */
		if(this.getX()==hero.getX() && this.getY()+32==hero.getY()) {
			this.carried=false; this.blocking_D=true; this.speed=0;
		}
		
		/* Blocking_L */
		if(
				this.getX()-32==hero.getX() && this.getY()==hero.getY() || 
				!Model.scene[this.getIndex_i()][this.getIndex_j()-1].getClass().toString().equals(new Darkground().getClass().toString())				
		  ) {
			this.blocking_L=true;
		}else {
			this.blocking_L=false;
		}
		
		
		/* Blocking_R */
		if(
				this.getX()+32==hero.getX() && this.getY()==hero.getY() || 
				!Model.scene[this.getIndex_i()][this.getIndex_j()+1].getClass().toString().equals(new Darkground().getClass().toString())				
		  ) {
			this.blocking_R=true;
		}else {
			this.blocking_R=false;
		}
		
		/* Blocking_LD */
		if(
				this.getX()-32==hero.getX() && this.getY()+32==hero.getY() || 
				!Model.scene[this.getIndex_i()+1][this.getIndex_j()-1].getClass().toString().equals(new Darkground().getClass().toString())				
		  ) {
			this.blocking_LD=true;
		}else {
			this.blocking_LD=false;
		}
		
		/* Blocking_RD */
		if(
				this.getX()+32==hero.getX() && this.getY()+32==hero.getY() ||
				!Model.scene[this.getIndex_i()+1][this.getIndex_j()+1].getClass().toString().equals(new Darkground().getClass().toString())				
		  ) {
			this.blocking_RD=true;
		}else {
			this.blocking_RD=false;
		}

		
        if(carried==true && blocking_LD==false && blocking_L==false) {
        	this.move("left",pos);
        }else if(carried==true && blocking_RD==false && blocking_R==false) {
        	this.move("right",pos);
        }
		
		 if(blocking_D==false && carried==false)
		 this.fall(pos);
	}

	 
		 public void fall(int pos) {
				
				//System.out.println(Model.allRocks.get(0).getX()/32+" "+Model.allRocks.get(0).getY()/32);
				  // System.out.println("oui");
				
				int y = this.getY();
				int x = this.getX();
				
				int i = this.getIndex_i();
				int j = this.getIndex_j();
			
				//System.out.println(x+" "+y+" "+i+" "+j);
				Model.scene[i][j]= new Darkground();
				Model.scene[i+1][j] = new Diamond();
				
				Model.scene[i][j].setX(x); Model.scene[i][j].setY(y);
			    Model.scene[i+1][j].setX(x);  Model.scene[i+1][j].setY(y+32);
			    Model.allDiamonds.set(pos, (Diamond) Model.scene[i+1][j]);
			    Model.allDiamonds.get(pos).speed++;
			    
				//System.out.println(i+" "+j+": "+Model.scene[i][j].getX()/32+" "+Model.scene[i][j].getY()/32);
				//System.out.println((i+1)+" "+j+": "+Model.allRocks.get(pos).getX()/32+" "+Model.allRocks.get(pos).getY()/32);
			}

		 
		 /**
		  * 
		  * @param direction
		  *          the direction.
		  * @param pos
		  *          the position.
		  */
			public void move(String direction, int pos) {
				
				if(direction == "left") {
					int y = this.getY();
					int x = this.getX();
					
					int i = this.getIndex_i();
					int j = this.getIndex_j();
				
					Model.scene[i][j]= new Darkground();
					Model.scene[i][j-1] = new Diamond();
			
					Model.scene[i][j].setX(x); Model.scene[i][j].setY(y);
				    Model.scene[i][j-1].setX(x-32);  Model.scene[i][j-1].setY(y);
				    Model.allDiamonds.set(pos, (Diamond) Model.scene[i][j-1]);
				}
				
				else if(direction == "right") {
					int y = this.getY();
					int x = this.getX();
					
					int i = this.getIndex_i();
					int j = this.getIndex_j();
				
					//System.out.println(x+" "+y+" "+i+" "+j);
					Model.scene[i][j]= new Darkground();
					Model.scene[i][j+1] = new Diamond();
					
					Model.scene[i][j].setX(x); Model.scene[i][j].setY(y);
				    Model.scene[i][j+1].setX(x+32);  Model.scene[i][j+1].setY(y);
				    Model.allDiamonds.set(pos, (Diamond) Model.scene[i][j+1]);
				}
	}
}
