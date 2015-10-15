package project.view;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import org.controlsfx.dialog.Dialogs.CommandLink;

import project.MainApp;
import project.model.*;
/**
 * Configure the basic planet information and show to user
 * @author Xie Jiateng
 */
public class PlanetInformationController {
	
	/**
	 * data of this controller
	 */
	@FXML
	private Canvas canvas;
	/**
	 * data of this controller
	 */
	@FXML
	private Label planetName;
	/**
	 * data of this controller
	 */
	@FXML
	private Label solarSystemName;
	/**
	 * data of this controller
	 */
	@FXML
	private Label techLevel;
	/**
	 * data of this controller
	 */
	@FXML
	private Label specialResource;
	/**
	 * data of this controller
	 */
	@FXML
	private Label disLabel;
	/**
	 * data of this controller
	 */
	@FXML
	private Label policeLabel;
	/**
	 * data of this controller
	 */
	@FXML
	private Label pirateLabel;
	/**
	 * data of this controller
	 */
	@FXML
	private Label fuelLeftLabel;
	/**
	 * data of this controller
	 */
	@FXML
	private MainApp mainApp;
	/**
	 * data of this controller
	 */
	@FXML
	private Star star;
	/**
	 * data of this controller
	 */
	@FXML
	private SolarSystem solarSystem;
	/**
	 * data of this controller
	 */
	@FXML
	private int distance;
	
	/**
     * Setter for mainApp
     * @param mainApp
     */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
     * Setter for star
     * @param star
     */
	public void setStar(Star star) {
		this.star = star;
	}
	
	/**
     * Setter for solarSystem
     * @param solarSystem
     */
	public void setSolarSystem(SolarSystem solarSystem) {
		this.solarSystem = solarSystem;
	}
	
	/**
     * Setter for distance
     * @param distance
     */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/**
	 * show this planetInformation to user
	 */
	public void show() {
		planetName.setText(star.getName());
		solarSystemName.setText(solarSystem.getName());
		disLabel.setText("Distance: " + distance);
		String pira = "";
		String poli = "";
		if (star.getPirateLevel() == 2) {
			pira += "Swarms";
		} else if (star.getPirateLevel() >= 5) {
			pira += "Present";
		} else {
			pira += "Abundant";
		}
		if (star.getPoliceLevel() == 3) {
			poli += "Swarms";
		} else if (star.getPoliceLevel() == 4) {
			poli += "Abundant";
		} else {
			poli += "Present";
		}
		fuelLeftLabel.setText("Fuel left: " + mainApp.getShip().getFuelLeft());
		pirateLabel.setText("Pirate: " + pira);
		policeLabel.setText("Police: " + poli);
		techLevel.setText("Tech level: " + star.getTechLevelName());
		specialResource.setText("Resource: " + star.getResourceName());
		GraphicsContext gcc = canvas.getGraphicsContext2D();
		gcc.setFill(Color.BLACK);
		gcc.fillRect(0, 0, 160, 160);
		gcc.setFill(star.getPaint());
		gcc.fillOval(10, 10, 140, 140);
	}
	
	/**
	 * button handler used by javaFX
	 */
	@FXML
	private void buttonHandler() {
		mainApp.showShortRangeChart();
	}
	
	/**
	 * button handler used by javaFX
	 */
	@FXML
	private void buttonHandler1() {
		if (mainApp.getShip().travel(distance)) {
			int pirate = Universe.RAND.nextInt(star.getPirateLevel()) + 1;
			if (pirate == star.getPirateLevel()) {
				List<CommandLink> option = new ArrayList<>();
				option.add(new CommandLink("Fight", "If you are more of "
							 + "a combat character, you better fight."));
				option.add(new CommandLink("Negotiate", "If you are good"
							 + "at negotiating, you better negotiate."));
				option.add(new CommandLink("Flee", "If you think your "
						 	 + "escape skill is good, flee."));
				option.add(new CommandLink("Surrender", "Worst case"
							 + " scenario."));
				Pirate pira = new Pirate();
				String message = pira.toString() +" What do you wanna do?";
				Action response = Dialogs.create()
						.owner(mainApp.getTravelStage())
				        .title("Encounter Pirate")
				        .masthead("You encounter pirate!")
				        .message(message)
				        .showCommandLinks(option.get(3), option);
				if (response == option.get(0)) {
					pira.fight(mainApp.getPlayer(), mainApp.getShip());
				} else if (response == option.get(1)) {
					pira.negotiate(mainApp.getPlayer(), mainApp.getShip());
				} else if (response == option.get(2)) {
					pira.flee(mainApp.getPlayer(), mainApp.getShip());
				} else if (response == option.get(3)) {
					pira.surrender(mainApp.getShip());
				}
			}
			int police = Universe.RAND.nextInt(star.getPoliceLevel()) + 1;
			if (police == star.getPoliceLevel()) {
				List<CommandLink> choice = new ArrayList<>();
				choice.add(new CommandLink("Let them search", "I got "
						   + "nothing illegal. Just let them come in."));
				choice.add(new CommandLink("Bribe", "If you are a good neg"
							 + "otiater, you may test their morality."));
				choice.add(new CommandLink("Flee", "If you think your "
						 	 + "escape skill is good, flee."));
				String result = "";
				Action reaction = Dialogs.create()
						.owner(mainApp.getTravelStage())
				        .title("Encounter Pirate")
				        .masthead("You encounter police!")
				        .message("What do you wanna do?")
				        .showCommandLinks(choice.get(2), choice);
				Firearms fire= new Firearms();
				Narcotics narc = new Narcotics();
				if (reaction == choice.get(0)) {
					if (!mainApp.getShip().getCargoList().contains(fire)
						&& !mainApp.getShip().getCargoList().contains(narc)) {
						result += "You are clean. They let you go!";
						Dialogs.create()
								.owner(mainApp.getTravelStage())
								.title("Clean")
								.message(result)
								.showInformation();
					} else {
						result += "You got something illegal on your ship!";
						if (mainApp.getShip().getCargoList().contains(fire)) {
							mainApp.getShip().getCargoList().remove(fire);
							result += " They take all your fireams!";
						}
						if (mainApp.getShip().getCargoList().contains(narc)) {
							mainApp.getShip().getCargoList().remove(narc);
							result += " They take all your narcotics!";
						}
						int moneyfined = 1000;
						if (moneyfined >= mainApp.getShip().getMoney()) {
							moneyfined = mainApp.getShip().getMoney();
							mainApp.getShip().setMoney(0);
						} else {
							mainApp.getShip().setMoney(mainApp.getShip().getMoney() - 1000);
						}
						mainApp.getShip().setCargoSpaceLabel("" + (mainApp.getShip().getCargoSpace() - mainApp.getShip().size()) + "/"
															 + mainApp.getShip().getCargoSpace());
						result += " And you get a fine of " + moneyfined
								  + " for traffickering!";
						Dialogs.create()
								.owner(mainApp.getTravelStage())
								.title("Got caught!")
								.message(result)
								.showInformation();
					}
				} else if (reaction == choice.get(1)) {
					int bribe = Universe.RAND.nextInt(16);
					int moneyused = 0;
					if (mainApp.getPlayer().getNegotiate() >= bribe) {
						moneyused = bribe * 100;
						if (mainApp.getShip().getMoney() < moneyused) {
							result += "They want more than you have! They still come in!";
							if (mainApp.getShip().getCargoList().contains(fire)) {
								mainApp.getShip().getCargoList().remove(fire);
								result += " They take all your fireams!";
							}
							if (mainApp.getShip().getCargoList().contains(narc)) {
								mainApp.getShip().getCargoList().remove(narc);
								result += " They take all your narcotics!";
							}
							mainApp.getShip().setCargoSpaceLabel("" + (mainApp.getShip().getCargoSpace() - mainApp.getShip().size()) + "/"
																 + mainApp.getShip().getCargoSpace());
							int moneyfined = 1000;
							if (moneyfined >= mainApp.getShip().getMoney()) {
								moneyfined = mainApp.getShip().getMoney();
								mainApp.getShip().setMoney(0);
							} else {
								mainApp.getShip().setMoney(mainApp.getShip().getMoney() - 1000);
							}
							result += " And you get a fine of " + moneyfined
									  + "!";
							Dialogs.create()
									.owner(mainApp.getTravelStage())
									.title("Got caught!")
									.message(result)
									.showInformation();
						} else {
							result += "They were the slaves of your money."
									  + "Good job! It only cost you "
									  + moneyused + " to avoid the loss of"
								      + "all your illgal goods!";
							mainApp.getShip().setMoney(mainApp.getShip().getMoney() - moneyused);
							Dialogs.create()
									.owner(mainApp.getTravelStage())
									.title("Politician!!")
									.message(result)
									.showInformation();
						}
					} else {
						result += "You are not so proficient at playing a little politics. They still come in!";
						if (mainApp.getShip().getCargoList().contains(fire)) {
							mainApp.getShip().getCargoList().remove(fire);
							result += " They take all your fireams!";
						}
						if (mainApp.getShip().getCargoList().contains(narc)) {
							mainApp.getShip().getCargoList().remove(narc);
							result += " They take all your narcotics!";
						}
						mainApp.getShip().setCargoSpaceLabel("" + (mainApp.getShip().getCargoSpace() - mainApp.getShip().size()) + "/"
															 + mainApp.getShip().getCargoSpace());
						int moneyfined = 1000;
						if (moneyfined >= mainApp.getShip().getMoney()) {
							moneyfined = mainApp.getShip().getMoney();
							mainApp.getShip().setMoney(0);
						} else {
							mainApp.getShip().setMoney(mainApp.getShip().getMoney() - 1000);
						}
						result += " And you get a fine of " + moneyfined
								  + "!";
						Dialogs.create()
								.owner(mainApp.getTravelStage())
								.title("Got caught!")
								.message(result)
								.showInformation();
					}
				} else if (reaction == choice.get(2)) {
					int escape = Universe.RAND.nextInt(5);
					if (escape == 0) {
						result += "You got lucky this time. They are drunk and have to let you go!";
						Dialogs.create()
								.owner(mainApp.getTravelStage())
								.title("Escaped")
								.message(result)
								.showInformation();
					} else {
						result += "Just remember, never try to flee from a police!";
						if (mainApp.getShip().getCargoList().contains(fire)) {
							mainApp.getShip().getCargoList().remove(fire);
							result += " They take all your fireams!";
						}
						if (mainApp.getShip().getCargoList().contains(narc)) {
							mainApp.getShip().getCargoList().remove(narc);
							result += " They take all your narcotics!";
						}
						mainApp.getShip().setCargoSpaceLabel("" + (mainApp.getShip().getCargoSpace() - mainApp.getShip().size()) + "/"
															 + mainApp.getShip().getCargoSpace());
						int moneyfined = 1000;
						if (moneyfined >= mainApp.getShip().getMoney()) {
							moneyfined = mainApp.getShip().getMoney();
							mainApp.getShip().setMoney(0);
						} else {
							mainApp.getShip().setMoney(mainApp.getShip().getMoney() - 1000);
						}
						result += " And you get a fine of " + moneyfined
								  + "!";
						Dialogs.create()
								.owner(mainApp.getTravelStage())
								.title("Got caught!")
								.message(result)
								.showInformation();
					}
				}
			}
			mainApp.setStar(star);
			mainApp.setSolarSystem(solarSystem);
			mainApp.showShortRangeChart();
			Action response = Dialogs.create()
									  .title("Warning")
									  .message("Do you want to fill up the tank?")
									  .showConfirm();
			if (response == Dialog.Actions.YES) {
				mainApp.showFuelStation();
			}
		}
	}
}