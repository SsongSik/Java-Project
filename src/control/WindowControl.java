package control;

import dataAccessObject.WindowDAO;

public class WindowControl {
	
	private WindowDAO windowDAO;
	
	public WindowControl() {
		this.windowDAO = new WindowDAO();
	}

	public void WindowCMSave(String filename, String text) {
		windowDAO.windowDMSave(filename, text);
		
	}

	public void WindowCMDelete(String filename, String text) {
		windowDAO.windowDMDelete(filename, text);
		
	}


}
