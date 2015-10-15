package project.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.controlsfx.dialog.Dialogs;

import project.MainApp;
/**
 * Configure the basic player information at the beginning of the game.
 * @author Xie Jiateng
 */
public class ConfigurationController {
    /**
     * mainApp using this controller
     */
    private MainApp mainApp;

    /**
     * attributes required
     */
    @FXML
    private TextField userName;
    /**
     * attributes required
     */
    @FXML
    private TextField combatPoints;
    /**
     * attributes required
     */
    @FXML
    private TextField negotiatePoints;
    /**
     * attributes required
     */
    @FXML
    private TextField escapePoints;
    
    /**
     * link this controller back to mainApp
     * @param mainApp the mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Handle the button input.
     * changed
     */
    @FXML
    private void buttonHandler() {
        if (isInputValid()) {
            int combat = Integer.parseInt(combatPoints.getText());
            int negotiate = Integer.parseInt(negotiatePoints.getText());
            int escape = Integer.parseInt(escapePoints.getText());
            boolean able = combat + negotiate + escape != 15;
            if (able) { 
                Dialogs.create()
                        .title("Error!")
                        .message("The sum of skill points should be 15.")
                        .showError();
            } else {
                mainApp.initializeUser(userName.getText(), combat, negotiate, escape);
                Dialogs.create()
                        .title("Your user information!")
                        .message(mainApp.getPlayer().toString())
                        .showInformation();
                Dialogs.create()
                    .title("Your universe!!!")
                    .message("atemp new universe is created!\n" + mainApp.getUniv().toString()
                             + mainApp.location())
                    .showInformation();
                mainApp.showUniverse();
            }
        }
    }
    
    /**
     * Handle the cancel input.
     */
	@FXML
	private void buttonHandler1() {
		mainApp.showWelcomeScreen();
	}
	
    /**
     * Check whether the input is valid. 
     * @return true if input is valid, false otherwise.
     */
    private boolean isInputValid() {
        String errorMessage = "";
        if (userName.getText() == null || userName.getText().length() == 0) {
            errorMessage += "No valid user name!\n"; 
        }
        if (combatPoints.getText() == null || combatPoints.getText().length() == 0) {
            errorMessage += "No valid combat points!\n"; 
        } else {
            try {
                int atemp = Integer.parseInt(combatPoints.getText());
                if (atemp < 0) {
                	errorMessage += "No valid combat points (must be positive)!\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid combat points (must be an integer)!\n"; 
            }
        }
        if (negotiatePoints.getText() == null || negotiatePoints.getText().length() == 0) {
            errorMessage += "No valid negotiate points!\n"; 
        } else {
            try {
                int tempb = Integer.parseInt(negotiatePoints.getText());
                if (tempb < 0) {
                	errorMessage += "No valid negotiate points (must be positive)!\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid negotiate points (must be an integer)!\n"; 
            }
        }
        if (escapePoints.getText() == null || escapePoints.getText().length() == 0) {
            errorMessage += "No valid negotiate points!\n"; 
        } else {
            try {
                int temp = Integer.parseInt(escapePoints.getText());
                if (temp < 0) {
                	errorMessage += "No valid escape points (must be positive)!\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid negotiate points (must be an integer)!\n"; 
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Dialogs.create()
                	.title("Invalid Fields")
                	.masthead("Please correct invalid fields")
                	.message(errorMessage)
                	.showError();
            return false;
        }
	}
}