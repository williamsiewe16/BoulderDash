package Element;


/**
 * The Class mobileElement.
 *
 * @author Group7
 */
public abstract class mobileElement extends Element{

	/** The moveup boolean*/
	protected boolean moveup;
	
	/** The movedown boolean*/
	protected boolean movedown;
	
	/** The moveleft boolean*/
	protected boolean moveleft;
	
	/** The moveright boolean*/
	protected boolean moveright;
	
	/**
	 *  moves the element.
	 *   
	 * @param direction
	 *          the direction
	 */
	public void move(char direction) {
	    	
		 if(direction=='U') {
					this.setMoveup(true);
			    	   this.setMovedown(false);
		    		this.setY(this.getY()-32);
	    	}
	    	
	    	else if(direction=='D') {
						this.setMoveup(false);
				    	   this.setMovedown(true);
			    		this.setY(this.getY()+32);
	    	}
	    	
	    	else if(direction=='L') {
	 
						this.setMoveleft(true);
			    	   this.setMoveright(false);
		    		this.setX(this.getX()-32);
	    	}
	    	
	    	else if(direction=='R') {
					this.setMoveright(true);
			    	   this.setMoveleft(false);
		    		this.setX(this.getX()+32);
		 	}

	    }
	
 	/**
 	 * Gets the moveup value
 	 * 
 	 * @return the moveup boolean
 	 */
	public boolean isMoveup() {
		return moveup;
	}

	/**
	 * 
	 * @param moveup
	 *          the new moveup value
	 */
	public void setMoveup(boolean moveup) {
		this.moveup = moveup;
	}

	/**
 	 * Gets the movedown value
 	 * 
 	 * @return the movedown boolean
 	 */
	public boolean isMovedown() {
		return movedown;
	}

	/**
	 * 
	 * @param movedown
	 *          the new movedown value
	 */
	public void setMovedown(boolean movedown) {
		this.movedown = movedown;
	}

	
	/**
 	 * Gets the moveleft value
 	 * 
 	 * @return the moveleft boolean
 	 */
	public boolean isMoveleft() {
		return moveleft;
	}

	
	/**
	 * 
	 * @param moveleft
	 *          the new moveleft value
	 */
	public void setMoveleft(boolean moveleft) {
		this.moveleft = moveleft;
	}

	/**
 	 * Gets the moveright value
 	 * 
 	 * @return the moveright boolean
 	 */
	public boolean isMoveright() {
		return moveright;
	}

	
	/**
	 * 
	 * @param moveright
	 *          the new moveright value
	 */
	public void setMoveright(boolean moveright) {
		this.moveright = moveright;
	}

	
	public abstract void fixBooleans(int pos, Hero hero);
}
