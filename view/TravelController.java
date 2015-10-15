package project.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class TravelController {
	/**
	 * data field of this TravelController
	 */
	private Stage travelStage;
	
	/**
     * Setter for rootStage
     * @param rootStage 
     */
	public void setTravelStage(Stage travelStage) {
		this.travelStage = travelStage;
	}
	
	/**
     * Close the travel stage
     */
	@FXML
	public void buttonHandler() {
		travelStage.close();
	}
}