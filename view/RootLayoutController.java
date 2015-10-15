package project.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.MainApp;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
/**
 * Controller to be used by javaFX
 * to show rootLayout
 * @author Jiateng Xie
 *
 */
public class RootLayoutController {
	
	/**
	 * data of RootLayoutController
	 */
	private Stage rootStage;
	/**
	 * data of RootLayoutController
	 */
	private MainApp mainApp;
	
	/**
     * Setter for rootStage
     * @param rootStage 
     */
	public void setRootStage(Stage rootStage) {
		this.rootStage = rootStage;
	}
	
	/**
     * Setter for mainApp
     * @param mainApp
     */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
     * Handle the button to create a new game
     */
	@FXML
	private void handleNew() {
		String univString = "Universe";
		if (mainApp.getCurrentSceneName().equals(univString)) {
			Action response = Dialogs.create()
						.owner(mainApp.getPrimaryStage())
									.title("Warning")
									.message(
								    "Are you sure "
									+ "that you want"
									+ " to create "
									+ "a new game?"
									+ " The "
									+ "current game"
									+ " will "
								    + "be "
									+ "discarded.")
									.showConfirm();
			if (response == Dialog.Actions.YES) {
				mainApp.showConfigurationPane();
			}
		} else {
			mainApp.showConfigurationPane();
		}
	}
	
	/**
     * Handle the button to open the universe
     */
	@FXML
	private void handleOpen() {
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
	
	/**
     * Handle the button to save the game
     */
	@FXML
	private void handleSave() {
		String univString = "Universe";
		if (mainApp.getCurrentSceneName().equals(univString)) {
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
					"XML files (*.xml)", "*.xml");
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());
			if (file != null) {
				if (!file.getPath().endsWith(".xml")) {
					file = new File(file.getPath() + ".xml");
				}
				mainApp.saveGame(file);
			}
        } else {
        	Dialogs.create()
			  		.owner(mainApp.getPrimaryStage())
			  		.title("Warning")
			  		.message("Sorry, but you have to "
			  				+ "create a new "
			  				+ "game before you can save a game")
					.showInformation();
        }
	}
	
	/**
     * Handle the button to close the root stage
     */
	@FXML
	private void handleExit() {
		rootStage.close();
	}
}