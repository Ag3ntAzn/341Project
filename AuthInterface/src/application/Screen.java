package application;

import application.ScreenController;

public interface Screen {
	public void initializeScreen();
	
	public void setScreenParent(ScreenController controller);
}
