package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import DAO.DBConnection;
import DAO.Option;
import Element.diamondState;
import contract.IController;
import contract.IModel;
import contract.IView;
import model.Model;

	/**
	 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
	 *
	 * @author Group7
	 * @version 1.0
	 */
	
public class Controller implements IController {

		/** The view. */
	    private final IView  view; 
	    
	    /** The model. */
	    private final IModel model;
	    
	    /** position of diamond */
	    private int pos_diamond;
	    
	    /** The Database connector*/
	    private DBConnection DAO;
	    
	    /** The Database connector*/
	    public static char [][] sceneCharacters;

	    /**
	     * Instantiates a new controller facade.
	     *
	     * @param view
	     *            the view
	     * @param model
	     *            the model
	     */
	    
	    public Controller(final IView view, final IModel model) {
	        this.view = view;
	        this.model = model;
	        this.DAO = new DBConnection();
	        Controller.sceneCharacters = new char [25][37];
	     }

	    /**
	     * Start.
	     *
	     */
	    public void start() {
         
	    	/* Timer for Diamonds movements*/
	    	
	    Timer timer = new Timer();
           
       	timer.schedule(new TimerTask() {
    		public void run() {
    			if(IView.counter%2 != 0 && IView.diamondCounter !=0) {
    			for(int i=0;i<Model.allDiamonds.size();i++) {
    				if(Model.allDiamonds.get(i) != null) {
    			setPos_diamond(Model.allDiamonds.get(i).getState().ordinal()+1);

    			Model.allDiamonds.get(i).setState(diamondState.values()[pos_diamond]);
    				}
    			}
    		}
    	}
    },0,150);
       	
       	/* Timer for the time remaining to play */ 
       	
       	Timer timer2 = new Timer();
        
       	timer2.schedule(new TimerTask() {
    		public void run() {
    			if(KeyBoard.hero != null) {
    			if(IView.counter%2 == 1 && KeyBoard.hero.isWin()==false) {
    	          IModel.time--;
    				}
    			else if(KeyBoard.hero != null) {
    				if(KeyBoard.hero.isWin()==true && IView.counter%2 == 1) {
                     Timer t = new Timer();
                     t.schedule(new TimerTask() {
                    	public void run() {
                    		IView.counter=0;
                    		t.cancel();
                    	}                	
                     },3000,100);
    				}
    			}
    			else {
      	          IModel.time = 120;
      				}
    			}
    		}
    	},0,1200);
       	
	/* Timer for monsters movements */ 
       	
       	Timer timer3 = new Timer();
        
       	timer3.schedule(new TimerTask() {
    		public void run() {
    			if(IView.counter%2 == 1 && IView.diamondCounter!=0) {
    				 if(!Model.allMonsters.isEmpty()) {
    		    		  for(int a=0;a<Model.allMonsters.size();a++) {
    		    			    if(KeyBoard.hero != null) {	
    		    	            Model.allMonsters.get(a).fixBooleans(a,KeyBoard.hero);
    		    			    }
    		    			   }
    		    		  }
    				}
    			}
    	},0,250);
       	
     /* The timer for the gate */

Timer timer4 = new Timer();
        
       	timer4.schedule(new TimerTask() {
    	   public void run() {
    		if(Model.placeGateCounter!=0) {
    			
    		 if(IView.gateCounter%4==0) {
    		 Model.scene[Model.i_gate][Model.j_gate].setImage(new ImageIcon("sprites/gate1.png").getImage());
    		     }
    		 else if(IView.gateCounter%4==1) {
    			 Model.scene[Model.i_gate][Model.j_gate].setImage(new ImageIcon("sprites/gate2.png").getImage());
    		 }
    		 else if(IView.gateCounter%4==2) {
    			 Model.scene[Model.i_gate][Model.j_gate].setImage(new ImageIcon("sprites/gate3.png").getImage());
    		 }
    		 else if(IView.gateCounter%4==3) {
    			 Model.scene[Model.i_gate][Model.j_gate].setImage(new ImageIcon("sprites/gate4.png").getImage());
    		 }
    		 
    		 IView.gateCounter++;
    		}
    	}
    	},0,150);
       	
       	/* Choose the level */
           DAO.open();
     	
       	Option.jop=new Option();
		String choice = (String)JOptionPane.showInputDialog(null, 
			      "Choose your level",
			      "BoulderDash",
			      JOptionPane.QUESTION_MESSAGE,
			      null,
			      Option.levels,
			      Option.levels[0]);
		
		
		this.fillsceneCharacters(choice);
		DAO.close();
	
  }
	    
	    public void fillsceneCharacters(String choice) {
	    	
	    	try {
	    		if(choice=="level1")
	    		DAO.setStatement(DAO.getConnection().prepareCall("{call getLevel(1)}"));
	    		else if(choice=="level2")
	    			DAO.setStatement(DAO.getConnection().prepareCall("{call getLevel(2)}"));
	    		else if(choice=="level3")
		    		DAO.setStatement(DAO.getConnection().prepareCall("{call getLevel(3)}"));
	    		else if(choice=="level4")
		    		DAO.setStatement(DAO.getConnection().prepareCall("{call getLevel(4)}"));
	    		else if(choice=="level5")
		    		DAO.setStatement(DAO.getConnection().prepareCall("{call getLevel(5)}"));
	    		else if(choice==null)
		    		DAO.setStatement(DAO.getConnection().prepareCall("{call getLevel(1)}"));
	    		
	    		DAO.getStatement().execute();
	    		ResultSet result = DAO.getStatement().getResultSet();
	    		int i=0, j=0;
	    		while(result.next()) {
	    			String line=result.getString("line");
	    	        for(j = 0;j<line.length();j++) {
	    	        	sceneCharacters[i][j]=line.charAt(j);
	    	        }
	    	        //System.out.println(line.length());
	    	        	i++;
	    		}
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		}
	   
	    }
	    
	    
	    
 
public void setPos_diamond(int pos_diamond) {
    if(pos_diamond > 3) {
    	this.pos_diamond=0;
    }
    else 
    	this.pos_diamond=pos_diamond;
    }

	    /**
	     * Gets the view.
	     *
	     * @return the view
	     */
	    public IView getView() {
	        return this.view;
	    }

	    /**
	     * Gets the model.
	     *
	     * @return the model
	     */
	    public IModel getModel() {
	        return this.model;
	    }


}
