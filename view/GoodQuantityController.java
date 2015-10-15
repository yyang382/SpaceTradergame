package project.view;

import project.MainApp;
import project.model.Good;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * Controller for Good quantity
 * @author Xie Jiateng
 */
public class GoodQuantityController {

    /**
     * attributes of GoodQuantityController
     */
    private Stage goodQuantityStage;
    /**
     * attributes of GoodQuantityController
     */
    private MainApp mainApp;
    /**
     * attributes of GoodQuantityController
     */
    private Good good;
    /**
     * attributes of GoodQuantityController
     */
    private boolean buy;
    /**
     * attributes of GoodQuantityController
     */
    private TableView<Good> view;
    /**
     * attributes of GoodQuantityController
     */
    @FXML
    private Slider slider;
    /**
     * attributes of GoodQuantityController
     */
    @FXML
    private Label label;
    
    /**
     * The method to show the quantity bar
     * @param maximum the maximum of the quantity bar
     * @param data the string to be displayed
     */
    public void show(int maximum, String data) {
        slider.setMin(1);
        slider.setMax(maximum);
        slider.setValue(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setSnapToTicks(true);
        label.setText(data + " at 1 * " + good.getPrice() + " = " + good.getPrice());
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number oldval, Number newval) {
                label.setText(data + " at " + newval.intValue() + " * " + good.getPrice() + " = "
                              + (newval.intValue() * good.getPrice()));
            }
        });
    }
    
    /**
     * setter of setQuantityStage
     * @param data the stage to be set
     */
    public void setGoodQuantityStage(Stage data) {
        goodQuantityStage = data;
    }
    
    /**
     * setter of mainApp
     * @param data the mainApp to be set
     */
    public void setMainApp(MainApp data) {
        mainApp = data;
    }
    
    /**
     * setter of Good
     * @param data the Good to be set
     */
    public void setGood(Good data) {
        good = data;
    }
    
    /**
     * setter of buy
     * @param data the buy to be set
     */
    public void setBuy(boolean data) {
        buy = data;
    }
    
    /**
     * setter of view
     * @param data the view to be set
     */
    public void setView(TableView<Good> data) {
        view = data;
    }
    
    /**
     * The button handler of the quantity bar
     */
    @FXML
    public void buttonHandler() {
        good.setQuantity((int) slider.getValue());
        if (buy) {
                boolean gdata = !mainApp.getShip().getCargoList().contains(good);
                if (mainApp.getShip().buy(good)) {
                    if (gdata) {
                        view.getItems().add(good);
                    }
                    goodQuantityStage.close();
                }
        } else {
            mainApp.getShip().sell(good);
            if (!mainApp.getShip().getCargoList().contains(good)) {
                view.getItems().remove(good);
            }
            goodQuantityStage.close();
        }
    }
    
    /**
     * The button handler to close the quantity stage
     */
    @FXML
    public void buttonHandler1() {
        goodQuantityStage.close();
    }
}