package project.view;

import java.io.File;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import project.MainApp;
/**
 * Controller for the first display
 * @author Jiateng Xie
 */
public class WelcomeScreenController {
	
	/**
	 * the mainApp to be linked back to
	 */
	private MainApp mainApp;
	
	/**
     * Setter for mainApp
     * @param mainApp the mainApp to set
     */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
     * Handle button input
     */
	@FXML
	private void buttonHandler() {
		mainApp.showConfigurationPane();
	}
	
	/**
     * handle general button input
     */
	@FXML
	private void buttonHandler1() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		if (file != null) {
			mainApp.loadGame(file);
			mainApp.showUniverse();
		}
	}
}