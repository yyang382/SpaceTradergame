package project.view;

import org.controlsfx.dialog.Dialogs;

import project.MainApp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
/**
 * Controller the fuel station display.
 * @author Jiateng Xie
 */
public class FuelStationController {
    
    /**
     * attributes of this controller
     */
    private Stage fuelStationStage;
    /**
     * attributes of this controller
     */
    private MainApp mainApp;
    /**
     * attributes of this controller
     */
    @FXML
    private Slider slider;
    /**
     * attributes of this controller
     */
    @FXML
    private Label label;
    /**
     * show the fuel station on the screen with basic settings.
     */
    public void show() {
        slider.setMin(0);
        slider.setMax(mainApp.getShip().getFuel() - mainApp.getShip().getFuelLeft());
        slider.setValue(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        label.setText("Buy fuel at cost: " + mainApp.getShip().getFuelCost() + " * 0 = 0");
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                    Number oldval, Number newval) {
                label.setText("Buy fuel at cost: " + mainApp.getShip().getFuelCost() + " * "
                              + newval.intValue() + " = "
                              + (mainApp.getShip().getFuelCost() * newval.intValue()));
            }
        });
    }
    /**
     * Setter for fuelStationStage
     * @param data the stage value
     */
    public void setFuelStationStage(Stage data) {
        fuelStationStage = data;
    }
    /**
     * Setter for mainApp
     * @param data the mainApp
     */
    public void setMainApp(MainApp data) {
        mainApp = data;
    }
    
    /**
     * Handel the button input
     */
    @FXML
    public void buttonHandler() {
        if (mainApp.getShip().purchaseFuel((int) slider.getValue())) {
            Dialogs.create()
                    .title("Complete transaction!")
                    .message("You bought " + (int) slider.getValue() + " fuel at fuel cost "
                            + mainApp.getShip().getFuelCost() + ". Your money left is "
                            + mainApp.getShip().getMoney() + " and your fuel left is "
                            + mainApp.getShip().getFuelLeft() + ".")
                    .showInformation();
            fuelStationStage.close();
        }
    }
    
    /**
     * Handel the cancel input
     */
    @FXML
    public void buttonHandler1() {
        fuelStationStage.close();
    }
}