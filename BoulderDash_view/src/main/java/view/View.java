package view;

import contract.IView;

/**
 * The Class View.
 *
 * @author Group7
 */
public final class View extends IView{

	/** The frame. */
	private ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 */
	public View() {
		this.viewFrame = new ViewFrame();
	}

	/**
	 * Gets the view frame
	 *
	 * @return the view frame
	 */
	public ViewFrame getViewFrame() {
		return viewFrame;
	}

	/**
	 * Sets the view frame
	 *
	 * @param viewFrame 
	 *        The new view frame
	 */
	public void setViewFrame(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}



}
