package project.view;

import java.io.File;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import project.MainApp;

/**
 * Controller for universe display
 * @author Jiateng Xie
 */
public class UniverseController {
	
	/**
	 * data of this UniverseController
	 */
	private MainApp mainApp;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label moneyLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label cargoSpaceLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label hullStrengthLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label fuelLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label solarLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label starLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label techLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private Label resourceLabel;
	/**
	 * data of this UniverseController
	 */
	@FXML
	private ProgressBar progressBar;
	/**
     * Setter for mainApp
     * @param mainApp the mainApp to set
     */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		moneyLabel.textProperty().bind(mainApp.getShip().getMoneyLabelProperty());
		cargoSpaceLabel.textProperty().bind(mainApp.getShip().getCargoSpaceLabelProperty());
		hullStrengthLabel.textProperty().bind(mainApp.getShip().getHullStrengthLabelProperty());
		fuelLabel.textProperty().bind(mainApp.getShip().getFuelLabelProperty());
		solarLabel.textProperty().bind(mainApp.getSolloc());
		starLabel.textProperty().bind(mainApp.getStarloc());
		techLabel.textProperty().bind(mainApp.getTechLevel());
		resourceLabel.textProperty().bind(mainApp.getResource());
		progressBar.progressProperty().bind(mainApp.getShip().getFuelPercentageProperty());
	}
	/**
     * Handle the button input to go back to welcome screen
     */
	@FXML
	private void buttonHandler() {
		Action response = Dialogs.create()
								  .owner(mainApp.getPrimaryStage())
								  .title("Warning")
								  .message("This will take you back to the home screen, and the"
								  		   + " current game will be discarded. Do you want to"
								  		   + " save the game before you leave?")
								  .showConfirm();
		if (response == Dialog.Actions.YES) {
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
			mainApp.showWelcomeScreen();
		} else if (response == Dialog.Actions.NO) {
			mainApp.showWelcomeScreen();
		}
	}
	/**
     * Handle the button input for show Market
     */
	@FXML
	private void buttonHandler1() {
		mainApp.showMarket();
	}
	
	/**
     * Handle the button input for show GalacticChart
     */
	@FXML
	private void buttonHandler2() {
		mainApp.showShipYard();	
	}
	
	/**
     * Handle the button input for show ShortRangeChart
     */
	@FXML
	private void buttonHandler3() {
		mainApp.showGalacticChart();
	}
	
	/**
     * Handle the button input for show ShipYard
     */
	@FXML
	private void buttonHandler4() {
		mainApp.showTravel();
		mainApp.showShortRangeChart();
	}
	
	@FXML
	private void buttonHandler5() {
		mainApp.getShip().shipInfo();
	}
}