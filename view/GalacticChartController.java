package project.view;

import project.MainApp;
import project.model.*;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Controller for Glaxy display
 * @author Xie Jiateng
 */
public class GalacticChartController {

    @FXML
    /**
     * attributes of galacticcontroller
     */
    private Canvas canvas;
    /**
     * attributes of galacticcontroller
     */
    private Stage galacticStage;
    /**
     * attributes of galacticcontroller
     */
    private MainApp mainApp;
    /**
     * Setter for marketStage
     * @param marketStage the marketStage
     */
    public void show() {
        GraphicsContext gcc = canvas.getGraphicsContext2D();
        gcc.setFill(Color.BLACK);
        gcc.fillRect(0, 0, 220, 220);
        gcc.setFill(Color.GREEN);
        gcc.fillOval((double) (
                mainApp.getStar().getX() - 26), 
                        (double) mainApp.getStar().getY() - 26, 52, 52);
        gcc.setFill(Color.BLACK);
        gcc.fillOval(
                (double) mainApp.getStar().getX() - 25, 
                        (double) mainApp.getStar().getY() - 25, 50, 50);
        for (SolarSystem a : mainApp.getUniv().getSolarSystems()) {
            for (Star b : a.getStars()) {
                gcc.setFill(b.getPaint());
                gcc.fillOval(((double) b.getX()) - 3, (double) b.getY() - 3, 6, 6);
            }
        }
        gcc.setFill(Color.GREEN);
        gcc.fillOval(((double) mainApp.getStar().getX()) - 3,
                ((double) mainApp.getStar().getY()) - 3, 6, 6);
    }
    
    /**
     * Setter for galacticStage
     * @param galacticStage the galactic stage to be set
     */
    public void setGalacticStage(Stage galacticStage) {
        this.galacticStage = galacticStage;
    }
    
    /**
     * Setter for mainApp
     * @param mainApp the mainApp to be set
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Handle the button to close galactic stage
     */
    @FXML
    private void buttonHandler() {
        galacticStage.close();
    }
}
