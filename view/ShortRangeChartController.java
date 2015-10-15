package project.view;

import org.controlsfx.dialog.Dialogs;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;

import project.MainApp;
import project.model.*;

/**
 * Controller that controls the shortrange chart
 * @author Jiateng Xie
 *
 */
public class ShortRangeChartController {

	/**
	 * data of thie ShortRangeChartController
	 */
	@FXML
	private Canvas canvas;
	/**
	 * data of thie ShortRangeChartController
	 */
	private MainApp mainApp;

	/**
	 * link this controller back to mainApp
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
	 * show this shortRangeChart to user
	 */
	public void show() {
		GraphicsContext gcc = canvas.getGraphicsContext2D();
		gcc.setFill(Color.BLACK);
		gcc.fillRect(0, 0, 280, 280);
		gcc.setFill(Color.GREEN);
		gcc.fillOval(140 - 8 * mainApp.getShip().getFuel(),
					140 - 8 * mainApp.getShip().getFuel(),
					16 * mainApp.getShip().getFuel(),
					16 * mainApp.getShip().getFuel());
		gcc.setFill(Color.BLACK);
		gcc.fillOval(140 - (8 * mainApp.getShip().getFuel() - 3),
					140 - (8 * mainApp.getShip().getFuel() - 3),
					16 * mainApp.getShip().getFuel()
					- 6, 16 * mainApp.getShip().getFuel() - 6);
		for (SolarSystem a : mainApp.getUniv().getSolarSystems()) {
			for (Star b : a.getStars()) {
				if (b.getX() > (mainApp.getStar().getX() - 35) 
					&& b.getX() < (mainApp.getStar().getX() + 35)
					&& b.getY() > (mainApp.getStar().getY() - 35)
					&& b.getY() < (mainApp.getStar().getY() + 35)) {
					int xloc = 4 * (b.getX() - mainApp.getStar().getX());
					int yloc = 4 * (b.getY() - mainApp.getStar().getY());
					gcc.setFill(b.getPaint());
					gcc.fillOval(140 + xloc - 12, 140 + yloc - 12, 24, 24);
				}
			}
		}
		gcc.setFill(Color.GREEN);
		gcc.fillOval(128, 128, 24, 24);
	}
	
	@FXML
	private void handleMouseClick(MouseEvent event) {
		int xloc = (((int) event.getX()) - 140) / 4 + mainApp.getStar().getX();
		int yloc = (((int) event.getY()) - 140) / 4 + mainApp.getStar().getY();
		for (SolarSystem a : mainApp.getUniv().getSolarSystems()) {
			for (Star b : a.getStars()) {
				if (b.isHit(xloc, yloc, 3)) {
					int cost = (int) Math.sqrt(
							((b.getX() - mainApp.getStar().getX())
							* (b.getX() - mainApp.getStar().getX()))
							+ ((b.getY() - mainApp.getStar().getY())
							* (b.getY() - mainApp.getStar().getY())));
					cost = cost / 2;
					if (cost > mainApp.getShip().getFuel()) {
						Dialogs.create()
						  		.owner(mainApp.getTravelStage())
						  		.title("Error")
						  		.message("That planet is a "
						  				+ "bit too far.")
								.showInformation();
					} else {
						for (SolarSystem ss : mainApp.getUniv(
								).getSolarSystems()) {
							if (b.getX() >= (ss.getX() - 30)
								&& b.getX() <= (ss.getX() + 30)
								&& b.getY() >= (ss.getY() - 30)
								&& b.getY() <= (ss.getY() + 30)) {
								mainApp.showPlanetInformation(
										b, ss, cost);
							}
						}
					}
				}
			}
		}
	}
}