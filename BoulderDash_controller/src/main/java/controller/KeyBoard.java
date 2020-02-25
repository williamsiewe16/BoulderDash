package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import javax.swing.ImageIcon;
import Element.Hero;
import Element.*;
import model.Model;

/**
 * The Class KeyBoard.
 *
 * @author Group7
 */
public class KeyBoard implements KeyListener{

	/** The hero */
	public static Hero hero;
	
	/** The t_left timer */
	public static Timer t_Left;
	
	/** The t_right timer */
	public static Timer t_Right;
	
	/** The timer t_up timer */
	public static Timer t_up;
	
	/** The timer t_down timer */
	public static Timer t_down;
	
	/** The left_counter */
	public static int left_counter;
	
	/** 
	 * Instantiates a new KeyBoard
	 */
	public KeyBoard() {
	hero = new Hero();
	t_Left=new Timer();
	left_counter=0;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(hero.isDead()==false && hero.isWin()==false) {
		
		hero.dig();
		int a=0;
		
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT) {
	
			for(int i=0;i<25;i++) {
				for(int j=0;j<37;j++) {
					if(Model.scene[i][j].getX()==hero.getX()-32 && Model.scene[i][j].getY()==hero.getY() && 
							(Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString()))
							) {
					a++;
					}
					else if(Model.scene[i][j].getX()==hero.getX()-32 && Model.scene[i][j].getY()==hero.getY() &&
							Model.scene[i][j].getClass().toString().equals(new Rock().getClass().toString())
						) {
					a+=2;	
					}
			}
		}
			hero.setImage(new ImageIcon("sprites/persogauche.png").getImage());
		    if(a==2) {
				hero.push("left");
			}
			else if(a==0) {
				 
			/*	 t_Left.schedule(new TimerTask() {
                   public void run() {
						if(left_counter%2==0) {
							hero.setImage(new ImageIcon("sprites/marchegauchemain.png").getImage());
						}
						else if(left_counter%2==1){
							hero.setImage(new ImageIcon("sprites/marchegauchepied.png").getImage());
						}
						setLeft_counter(left_counter+1);
						System.out.println(left_counter);
                   }
				 },0,400);*/
				hero.move('L');
				hero.dig();
				Model.move(hero, "left");
			}
		}
		
		else if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) {

			for(int i=0;i<25;i++) {
				for(int j=0;j<37;j++) {
					if(Model.scene[i][j].getX()==hero.getX()+32 && Model.scene[i][j].getY()==hero.getY() && 
							(Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString()))
							) {
					a++;
					}
					else if(Model.scene[i][j].getX()==hero.getX()+32 && Model.scene[i][j].getY()==hero.getY() &&
							Model.scene[i][j].getClass().toString().equals(new Rock().getClass().toString())
						) {
					a+=2;	
					}
			}
		}
			hero.setImage(new ImageIcon("sprites/persodroite.png").getImage());
			if(a==2) {
				hero.push("right");
			}
			else if(a==0) {
			hero.move('R');
			hero.dig();
			Model.move(hero, "right");
			}
	}
		
		else if(arg0.getKeyCode()==KeyEvent.VK_UP) {
			
			for(int i=0;i<25;i++) {
				for(int j=0;j<37;j++) {
					if(
							Model.scene[i][j].getX()==hero.getX() && Model.scene[i][j].getY()==hero.getY()-32 && (
									Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString()) || Model.scene[i][j].getClass().toString().equals(new Rock().getClass().toString()))
									) {
					a++;
					}
				}
			}
			hero.setImage(new ImageIcon("sprites/persohaut.png").getImage());
			if(a==0) {
			hero.move('U');
			hero.dig();
			Model.move(hero, "up");
			}
		
	}

		else if(arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			
			for(int i=0;i<25;i++) {
				for(int j=0;j<37;j++) {
					if(
							Model.scene[i][j].getX()==hero.getX() && Model.scene[i][j].getY()==hero.getY()+32 && 
							(Model.scene[i][j].getClass().toString().equals(new Wall().getClass().toString()) || Model.scene[i][j].getClass().toString().equals(new Rock().getClass().toString()))
							) {
					a++;
					}
				}
			}
			hero.setImage(new ImageIcon("sprites/persohaut1.png").getImage());
			if(a==0) {
			hero.move('D');
			hero.dig();
			Model.move(hero, "down");
			}
		}
				
		hero.setMoveup(true);
		hero.setMovedown(true);
		hero.setMoveleft(true);
		hero.setMoveright(true);
		hero.dig();
		
		}
}		
		

	public static void setLeft_counter(int left_counter) {
		if(left_counter >100)
			KeyBoard.left_counter=0	;
		else
		KeyBoard.left_counter = left_counter;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//t_Left.cancel();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

