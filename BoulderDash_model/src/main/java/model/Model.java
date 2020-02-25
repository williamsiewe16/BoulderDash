package model;

import java.util.ArrayList;
import Element.Darkground;
import Element.Diamond;
import Element.Element;
import Element.Gate;
import Element.Hero;
import Element.Monster;
import Element.Rock;
import contract.IModel;

/**
 * The Class Model.
 *
 * @author Group7
 */
public final class Model extends IModel {

	/** The scene. */
	public static Element [][] scene;
	
	/** The list of all rocks on the scene  */
	public static ArrayList<Rock> allRocks;
    
	/** The list of all monsters on the scene  */
    public static ArrayList<Monster> allMonsters;
    
    /** The list of all Diamonds on the scene  */
    public static ArrayList<Diamond> allDiamonds;
    
    /** The list of all Diamonds on the scene  */
    public static ArrayList<Darkground> allDarkGrounds;
    
    /** The lag from left */
    private static int lag_L=0;
    
    /** The lag from the top */
    private static int lag_T=0;
    
    /** The score */
	public static int score = 0;
	
	/** The random number */
	public static int rand = 0;
	
	/** The place gate counter */
	public static int placeGateCounter = 0;
	
	/** The index i of the gate */
	public static int i_gate = 0;
	
	/** The index j of the gate */
	public static int j_gate = 0;
	
	 
	
	public static void placeGate() {

		if(placeGateCounter==0) {
			for(int i=0;i<25;i++) {
				for(int j=0;j<37;j++) {
					if(Model.scene[i][j].getClass().toString().equals(new Darkground().getClass().toString())) {
						Model.allDarkGrounds.add((Darkground) Model.scene[i][j]);
					}
				}
			}
			Model.rand = (int)(Math.random()*Model.allDarkGrounds.size());
			System.out.println(rand);
		i_gate = Model.allDarkGrounds.get(rand).getIndex_i();
		j_gate = Model.allDarkGrounds.get(rand).getIndex_j();
		
		int x = Model.allDarkGrounds.get(rand).getX();
	    int y = Model.allDarkGrounds.get(rand).getY();
		
		 Model.allDarkGrounds.remove(rand);
		Model.scene[i_gate][j_gate] = new Gate();
		
		Model.scene[i_gate][j_gate].setX(x);
		Model.scene[i_gate][j_gate].setY(y);
		placeGateCounter++;
		}
	}
	
    /**
     * moves the scene
     * 
     * @param hero
     *         the hero
     * @param direction
     *              the direction
     */
	public static void move(Hero hero,String direction) {
	
		if(direction == "left") {
		if(hero.isFreeze()==true) {
			for(int i=0;i<25;i++) {
				for(int j=0;j<37;j++) {
				  Model.scene[i][j].setX(Model.scene[i][j].getX()+32);
				}
			}
			lag_L-=32;
     	  }
		}
		
		else if(direction == "right") {
			if(hero.isFreeze()==true) {
				for(int i=0;i<25;i++) {
					for(int j=0;j<37;j++) {
					  Model.scene[i][j].setX(Model.scene[i][j].getX()-32);
					}
				}
		      lag_L+=32;
			}
		}
	
	   else if(direction == "up") {
			if(hero.isFreeze()==true) {
			for(int i=0;i<25;i++) {
				for(int j=0;j<37;j++) {
				  Model.scene[i][j].setY(Model.scene[i][j].getY()+32);
				}
			}
			lag_T-=32;
		} 
	   }
		
	   else if(direction == "down") {
		   if(hero.isFreeze()==true) {
				for(int i=0;i<25;i++) {
					for(int j=0;j<37;j++) {
						
						Model.scene[i][j].setY(Model.scene[i][j].getY()-32);
					}
				}
				lag_T+=32;
			}
	   }

}


	public static int getLag_L() {
		return lag_L;
	}


	public static void setLag_L(int lag_L) {
		Model.lag_L = lag_L;
	}


	public static int getLag_T() {
		return lag_T;
	}


	public static void setLag_T(int lag_T) {
		Model.lag_T = lag_T;
	}
	
	

	
}
