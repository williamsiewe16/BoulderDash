package Element;

import javax.swing.ImageIcon;
import model.Model;

/**
 * The Class Monster.
 *
 * @author Group7
 */
public class Monster extends mobileElement{
	
	/** The blocking left boolean*/
	public boolean blocking_L=true;
	
	/** The blocking right boolean*/
	public boolean blocking_R=true;
	
	/** The blocking down boolean*/
	public boolean blocking_D=true;
	
	/** The blocking up boolean*/
	public boolean blocking_U=true;
	
	/** The direction */
	public String direction=null;
	
	
	
	/**
	 * Instantiates a new Monster
	 */
	public Monster() {
		this.setImage(new ImageIcon("sprites/monster.png").getImage());
	}
	
	public Monster(int x,int y) {
		this.x=x;
		this.y=y;
		this.setMoveup(false);
		this.setMovedown(false);
		this.setMoveleft(false);
		this.setMoveright(false);
	}

	@Override
	public void fixBooleans(int pos, Hero hero) {
	
		if(
				 (this.getIndex_i()==hero.getIndex_i() && this.getIndex_j()==hero.getIndex_j())
		   ) {
			 hero.setDead(true);
		 }
		
		if(
				!Model.scene[this.getIndex_i()-1][this.getIndex_j()].getClass().toString().equals(new Darkground().getClass().toString()) &&
				!Model.scene[this.getIndex_i()-1][this.getIndex_j()].getClass().toString().equals(new Rock().getClass().toString())
				){
		//System.out.println(Model.scene[this.getIndex_i()-1][this.getIndex_j()].getClass().toString());
			this.blocking_U=true;			
		}else{this.blocking_U=false;}
		
		if(
				!Model.scene[this.getIndex_i()+1][this.getIndex_j()].getClass().toString().equals(new Darkground().getClass().toString()) &&
				!Model.scene[this.getIndex_i()-1][this.getIndex_j()].getClass().toString().equals(new Rock().getClass().toString())
				){
			this.blocking_D=true;
		}else{this.blocking_D=false;}
		
		if(
				!Model.scene[this.getIndex_i()][this.getIndex_j()-1].getClass().toString().equals(new Darkground().getClass().toString()) &&
				!Model.scene[this.getIndex_i()-1][this.getIndex_j()].getClass().toString().equals(new Rock().getClass().toString())
				){
			this.blocking_L=true;
		}else{this.blocking_L=false;}
		
		if(
				!Model.scene[this.getIndex_i()][this.getIndex_j()+1].getClass().toString().equals(new Darkground().getClass().toString()) &&
				!Model.scene[this.getIndex_i()-1][this.getIndex_j()].getClass().toString().equals(new Rock().getClass().toString())
				){
			this.blocking_R=true;
		}else{this.blocking_R=false;}
		

		if(direction=="up") {
		  if(this.blocking_U==false) {this.move("up",pos);}
		  else if(this.blocking_R==false) {this.move("right",pos);}	
		  else if(this.blocking_L==false) {this.move("left",pos);}
		  else if(this.blocking_D==false) {this.move("down",pos);}
		}

		else if(direction=="down") {
			if(this.blocking_D==false) {this.move("down",pos);}
			else if(this.blocking_L==false) {this.move("left",pos);}
			else if(this.blocking_R==false) {this.move("right",pos);}
			 else if(this.blocking_U==false) {this.move("up",pos);}
		}
		
		else if(direction=="left") {
			if(this.blocking_L==false) {this.move("left",pos);}
			else if(this.blocking_U==false) {this.move("up",pos);}
			else if(this.blocking_D==false) {this.move("down",pos);}	
			 else if(this.blocking_R==false) {this.move("right",pos);}
		}
		
		else if(direction=="right") {
			if(this.blocking_R==false) {this.move("right",pos);}
			else if(this.blocking_D==false) {this.move("down",pos);}
			else if(this.blocking_U==false) {this.move("up",pos);}	
			 else if(this.blocking_L==false) {this.move("left",pos);}
		}
		
		if(direction==null && this.blocking_U==false && this.blocking_D==false && this.blocking_L==false && this.blocking_R==false) {
			this.move("up",pos);
		}
	}
	
	
public void move(String direction, int pos) {
		
		if(direction == "left") {
			int y = this.getY();
			int x = this.getX();
			
			int i = this.getIndex_i();
			int j = this.getIndex_j();

			Model.scene[i][j]= new Darkground();
			Model.scene[i][j-1] = new Monster();
	
			Model.scene[i][j].setX(x); Model.scene[i][j].setY(y);
		    Model.scene[i][j-1].setX(x-32);  Model.scene[i][j-1].setY(y);
		    Model.allMonsters.set(pos, (Monster) Model.scene[i][j-1]);
		    Model.allMonsters.get(pos).direction="left";
		}
		
		else if(direction == "right") {
			int y = this.getY();
			int x = this.getX();
			
			int i = this.getIndex_i();
			int j = this.getIndex_j();
			
			Model.scene[i][j]= new Darkground();
			Model.scene[i][j+1] = new Monster();
			
			Model.scene[i][j].setX(x); Model.scene[i][j].setY(y);
		    Model.scene[i][j+1].setX(x+32);  Model.scene[i][j+1].setY(y);
		    Model.allMonsters.set(pos, (Monster) Model.scene[i][j+1]);
		    Model.allMonsters.get(pos).direction="right";
		}
		
		else if(direction == "up") {
			int y = this.getY();
			int x = this.getX();
			
			int i = this.getIndex_i();
			int j = this.getIndex_j();
		
			Model.scene[i][j]= new Darkground();
			Model.scene[i-1][j] = new Monster();
			
			Model.scene[i][j].setX(x); Model.scene[i][j].setY(y);
		    Model.scene[i-1][j].setX(x);  Model.scene[i-1][j].setY(y-32);
		    Model.allMonsters.set(pos, (Monster) Model.scene[i-1][j]);
		    Model.allMonsters.get(pos).direction="up";
		}
		
		else if(direction == "down") {
			int y = this.getY();
			int x = this.getX();
			
			int i = this.getIndex_i();
			int j = this.getIndex_j();
		
			Model.scene[i][j]= new Darkground();
			Model.scene[i+1][j] = new Monster();
			
			Model.scene[i][j].setX(x); Model.scene[i][j].setY(y);
		    Model.scene[i+1][j].setX(x);  Model.scene[i+1][j].setY(y+32);
		    Model.allMonsters.set(pos, (Monster) Model.scene[i+1][j]);
		    Model.allMonsters.get(pos).direction="down";
		}
    }

public void die(int pos) {
	int a=0, b=0;
	final int x=this.getIndex_i()-1, y=this.getIndex_j()-1;
	
	for(int i=x;i<x+3;i++) {
		for(int j=y;j<y+3;j++) {
			if(
					!Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString()) &&
					!Model.scene[i][j].getClass().toString().equals(new Rock().getClass().toString()) &&
					!Model.scene[i][j].getClass().toString().equals(new Diamond().getClass().toString()) 
			  ) {
			    a=Model.scene[i][j].getX();
		        b=Model.scene[i][j].getY();

	          	     Model.scene[i][j] = new Diamond();
	          	     
	          	Model.scene[i][j].setX(a);
	        	Model.scene[i][j].setY(b);
	        	
	        	Model.allDiamonds.add((Diamond)Model.scene[i][j]); 
		}
	}
   }
	Model.allMonsters.remove(pos);
	
}

public void collision(int pos) {
	
	for(int i=0;i<Model.allRocks.size();i++) {
		//System.out.println(i+": "+Model.allRocks.get(i).getX()/32+" "+Model.allRocks.get(i).getY()/32);
		//System.out.println(this.getX()/32+" "+this.getY()/32);
	if(
			(Model.allRocks.get(i).getX()==this.getX() && Model.allRocks.get(i).getY()==this.getY()) ||
			((Model.allRocks.get(i).getX()==this.getX()+32 && Model.allRocks.get(i).getY()==this.getY()) && this.direction=="right") ||
			((Model.allRocks.get(i).getX()==this.getX()-32 && Model.allRocks.get(i).getY()==this.getY()) && this.direction=="left") ||
			((Model.allRocks.get(i).getX()==this.getX() && Model.allRocks.get(i).getY()==this.getY()+32) && this.direction=="up") ||
			((Model.allRocks.get(i).getX()==this.getX() && Model.allRocks.get(i).getY()==this.getY()-32) && this.direction=="down") 
	  ){
		    this.die(pos);
	}
  }
	
}

}