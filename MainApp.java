package project;

import java.io.IOException;
import java.io.File;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import project.model.*;
import project.view.*;


/**
 * The game class
 * @author Jiateng Xie
 */
public class MainApp extends Application {

    /**
     * attributes of mainApp
     */
    private Stage primaryStage;
    /**
     * attributes of mainApp
     */
    private Stage travelStage;
    /**
     * attributes of mainApp
     */
    private BorderPane rootLayout;
    /**
     * attributes of mainApp
     */
    private BorderPane travelLayout;
    /**
     * attributes of mainApp
     */
    private Player user;
    /**
     * attributes of mainApp
     */
    private Universe univ;
    /**
     * attributes of mainApp
     */
    private SolarSystem currSol;
    /**
     * attributes of mainApp
     */
    private Star currStar;
    /**
     * attributes of mainApp
     */
    private Ship ship;
    /**
     * attributes of mainApp
     */
    private String currentSceneName;
    /**
     * attributes of mainApp
     */
    private StringProperty starloc;
    /**
     * attributes of mainApp
     */
    private StringProperty solloc;
    /**
     * attributes of mainApp
     */
    private StringProperty techLevel;
    /**
     * attributes of mainApp
     */
    private StringProperty resource;
    /**
     * attributes of mainApp
     */
    private final ObservableList<ShipType> shipType = FXCollections.observableArrayList();
    /**
     * attributes of mainApp
     */
    private final ObservableList<Weapon> weapon = FXCollections.observableArrayList();
    /**
     * attributes of mainApp
     */
    private final ObservableList<Shield> shield = FXCollections.observableArrayList();
    /**
     * attributes of mainApp
     */
    private final ObservableList<Gadget> gadget = FXCollections.observableArrayList();
    
    /**
     * Start the game with the specific primary stage
     * @param primaryStage  the stage to start with
     */ 
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Space Trader");
        initRootLayout();
        showWelcomeScreen();
    }
    
    /**
     * Initial the game root layout
     */
    public void initRootLayout() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            final Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            final RootLayoutController rLCtrlr = loader.getController();
            rLCtrlr.setMainApp(this);
            rLCtrlr.setRootStage(primaryStage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * show the welcome screen
     */
	public void showWelcomeScreen() {
		try {
			final FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/WelcomeScreen.fxml"));
            AnchorPane welcomeScreen = (AnchorPane) loader.load();
            rootLayout.setCenter(welcomeScreen);
            WelcomeScreenController wsCtrlr = loader.getController();
            wsCtrlr.setMainApp(this);
            currentSceneName = "WelcomeScreen";
		} catch (IOException e) {
            e.printStackTrace();
        }
	}
    
	/**
     * Display the game configuration pane
     */
	public void showConfigurationPane() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(
					"view/ConfigurationPane.fxml"));
			AnchorPane configurationPane = (AnchorPane) loader.load();
			rootLayout.setCenter(configurationPane);
			ConfigurationController configCtrlr = loader.getController();
			configCtrlr.setMainApp(this);
			currentSceneName = "ConfigurationPane";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	/**
     * Display the universe
     */
	public void showUniverse() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Universe.fxml"));
			AnchorPane universe = (AnchorPane) loader.load();
			rootLayout.setCenter(universe);
			UniverseController univCtrlr = loader.getController();
			univCtrlr.setMainApp(this);
			currentSceneName = "Universe";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     * show the market
     */
    public void showMarket() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Market.fxml"));
            final AnchorPane market = (AnchorPane) loader.load();
            final Scene scene = new Scene(market);
            final Stage marketStage = new Stage();
            marketStage.setTitle("Market");
            marketStage.setScene(scene);
            marketStage.show();
            final MarketController mCtrlr = loader.getController();
            mCtrlr.setMainApp(this);
            mCtrlr.setMarketStage(marketStage);
            if (currStar.getResource() != 0) {
                Dialogs.create()
                        .title("Attention!")
                        .message("This planet has special resource "
                                 + currStar.getResourceName()
                                 + "! Some item's price may soar or sink!")
                        .showInformation();
            }
            mCtrlr.setItemTable1(currStar.getSellableList());
            ship.setGoodPrice(currStar.getGoodList());
            mCtrlr.setItemTable2(ship.getSellableList(currStar.getTechLevel()));
            mCtrlr.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * show the galactic chart
     */
    public void showGalacticChart() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GalacticChart.fxml"));
            final AnchorPane galactic = (AnchorPane) loader.load();
            final Scene scene = new Scene(galactic);
            final Stage galacticStage = new Stage();
            galacticStage.setTitle("Galactic Chart");
            galacticStage.setScene(scene);
            galacticStage.show();
            final GalacticChartController gCCtrlr = loader.getController();
            gCCtrlr.setMainApp(this);
            gCCtrlr.setGalacticStage(galacticStage);
            gCCtrlr.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * show the travel scene
     */
	public void showTravel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/Travel.fxml"));
			travelLayout = (BorderPane) loader.load();
			Scene scene = new Scene(travelLayout);
			travelStage = new Stage();
			travelStage.setTitle("Galactic Chart");
			travelStage.setScene(scene);
			travelStage.show();
			TravelController travelCtrlr = loader.getController();
			travelCtrlr.setTravelStage(travelStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	/**
     * show the short range chart
     */
	public void showShortRangeChart() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/ShortRangeChart.fxml"));
			AnchorPane shortrange = (AnchorPane) loader.load();
			travelLayout.setCenter(shortrange);
			ShortRangeChartController srCtrlr = loader.getController();
			srCtrlr.setMainApp(this);
			srCtrlr.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * show the short range chart
     */
	public void showPlanetInformation(Star star, SolarSystem solarSystem, int distance) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource(
					"view/PlanetInformation.fxml"));
			AnchorPane planetInfo = (AnchorPane) loader.load();
			travelLayout.setCenter(planetInfo);
			PlanetInformationController piCtrlr = loader.getController();
			piCtrlr.setMainApp(this);
			piCtrlr.setStar(star);
			piCtrlr.setSolarSystem(solarSystem);
			piCtrlr.setDistance(distance);
			piCtrlr.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     * show the ship yard
     */
    public void showShipYard() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ShipYard.fxml"));
            final AnchorPane shipYard = (AnchorPane) loader.load();
            final Scene scene = new Scene(shipYard);
            final Stage shipYardStage = new Stage();
            shipYardStage.setTitle("Ship Yard!");
            shipYardStage.setScene(scene);
            shipYardStage.show();
            final ShipYardController sYCtrlr = loader.getController();
            sYCtrlr.setMainApp(this);
            sYCtrlr.setShipYardStage(shipYardStage);
            addShipYard();
            sYCtrlr.show();
            sYCtrlr.setShipTable(shipType);
            sYCtrlr.setWeaponTable(weapon);
            sYCtrlr.setShieldTable(shield);
            sYCtrlr.setGadgetTable(gadget);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * show the fuel Station
     */
    public void showFuelStation() {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/FuelStation.fxml"));
            final AnchorPane fuelStation = (AnchorPane) loader.load();
            final Scene scene = new Scene(fuelStation);
            final Stage fuelStationStage = new Stage();
            fuelStationStage.setTitle("Fuel Station!");
            fuelStationStage.setScene(scene);
            fuelStationStage.show();
            final FuelStationController fSCtrlr = loader.getController();
            fSCtrlr.setMainApp(this);
            fSCtrlr.setFuelStationStage(fuelStationStage);
            fSCtrlr.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * show the quantity of good
     */
    public void showGoodQuantity(int maximum, String text, Good good, boolean buy,
                                 TableView<Good> tvg) {
        try {
            final FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GoodQuantity.fxml"));
            final AnchorPane goodQuantity = (AnchorPane) loader.load();
            final Scene scene = new Scene(goodQuantity);
            final Stage goodQuantityStage = new Stage();
            goodQuantityStage.setTitle("Quantity!");
            goodQuantityStage.setScene(scene);
            goodQuantityStage.show();
            final GoodQuantityController gQCtrlr = loader.getController();
            gQCtrlr.setMainApp(this);
            gQCtrlr.setGoodQuantityStage(goodQuantityStage);
            gQCtrlr.setGood(good);
            gQCtrlr.setBuy(buy);
            gQCtrlr.setView(tvg);
            gQCtrlr.show(maximum, text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * initialize the player
     * @param name the name of the user
     * @param combat the combat skill of the player
     * @param negotiate the negotiate skill of the player
     * @param escape the escape skill of the player
     */
    public void initializeUser(String name, int combat, int negotiate, int escape) {
        ship = new Ship(new Gnat());
        univ = new Universe();
        currSol = univ.getSolarSystem(Universe.RAND.nextInt(9));
        currStar = currSol.getStar(Universe.RAND.nextInt(8));
        currStar.calPrice();
        user = new Player(name, combat, negotiate, escape);
        starloc = new SimpleStringProperty("Planet: " + currStar.getName());
        solloc = new SimpleStringProperty("Solar system: " + currSol.getName());
        techLevel = new SimpleStringProperty("Tech level: " + currStar.getTechLevelName());
        resource = new SimpleStringProperty("Resource: " + currStar.getResourceName());
    }
    
    /**
     * Get the universe
     * @return return the universe
     */
    public Universe getUniv() {
        return univ;
    }
    
    /**
     * Get the ship
     * @return return the ship
     */
    public Ship getShip() {
        return ship;
    }
    
    /**
     * Get the player
     * @return return the player
     */
    public Player getPlayer() {
        return user;
    }
    
    /**
     * Get the solarSystem
     * @return return the solaySystem
     */
    public SolarSystem getSolarSystem() {
        return currSol;
    }
    
    /**
     * Get the star
     * @return return the star
     */
    public Star getStar() {
        return currStar;
    }
    
    /**
     * Get the primary stage
     * @return the primary stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    /**
     * Get the travel stage
     * @return the travel stage
     */
	public Stage getTravelStage() {
        return travelStage;
    }
    
    /**
     * Get the current scene name
     * @return the current scene name
     */
	public String getCurrentSceneName() {
		return currentSceneName;
	}
    
    /**
     * Get the star location
     * @return the starloc
     */
    public StringProperty getStarloc() {
        return starloc;
    }
    
    /**
     * Get the solar system location
     * @return the solloc
     */
    public StringProperty getSolloc() {
        return solloc;
    }
    
    /**
     * Get the techLevel
     * @return the techLevel
     */
    public StringProperty getTechLevel() {
        return techLevel;
    }
    
    /**
     * Get the resource
     * @return the resource
     */
    public StringProperty getResource() {
        return resource;
    }
    /**
     * Setter for universe
     * @param univ the universe to set
     */
    public void setUniv(Universe univ) {
        this.univ = univ;
    }
    
    /**
     * Setter for ship
     * @param ship the ship to set
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    /**
     * Setter for player
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        user = player;
    }
    
    /**
     * Setter for solar system
     * @param solarSys the player to set
     */
    public void setSolarSystem(SolarSystem solarSys) {
        currSol = solarSys;
        setSolloc("Solar system: " + currSol.getName());
    }
    
    /**
     * Setter for star
     * @param star the player to set
     */
    public void setStar(Star star) {
        currStar = star;
        setStarloc("Planet: " + currStar.getName());
        setTechLevel("Tech level: " + currStar.getTechLevelName());
        setResource("Resource: " + currStar.getResourceName());
        currStar.calPrice();
    }
    
    /**
     * Setter for star
     * @param stloc the player to set
     */
    public void setStarloc(String stloc) {
        starloc.set(stloc);
    }
    
    /**
     * Setter for sysLocation
     * @param sysLoc the sysLocation to set
     */
    public void setSolloc(String sysLoc) {
        solloc.set(sysLoc);
    }
    
    /**
     * Setter for techlevel
     * @param techlevel the techlevel to set
     */
    public void setTechLevel(String techlevel) {
        techLevel.set(techlevel);
    }
    
    /**
     * Setter for resource
     * @param resc the resource to set
     */
    public void setResource(String resc) {
        resource.set(resc);
    }
    
    /**
     * Getter for location information
     * @return the current location information
     */
    public String location() {
        final String temp = "You are currently on star " + currStar.getName() + " of solar system "
                    + currSol.getName() + "!";
        return temp;
    }
    
    /**
     * Add a ship yard to the current system
     */
    private void addShipYard() {
        shipType.clear();
        weapon.clear();
        shield.clear();
        gadget.clear();
        if (currStar.getTechLevel() >= 4) {
            shipType.add(new Flea());
            weapon.add(new PulseLaser());
            shield.add(new EnergyShield());
            gadget.add(new FiveExtra());
        }
        if (currStar.getTechLevel() >= 5) {
            shipType.add(new Gnat());
            shipType.add(new Firefly());
            shipType.add(new Mosquito());
            shipType.add(new BumbleBee());
            weapon.add(new BeamLaser());
            weapon.add(new MilitaryLaser());
            shield.add(new ReflectiveShield());
            gadget.add(new NavigatingSystem());
            gadget.add(new AutorepairSystem());
            gadget.add(new TargetingSystem());
            gadget.add(new CloakingDevice());
        }
    }
    
    /**
     * Load a saved game
     * @param file the game to load
     */
    public void loadGame(File file) {
        try {
            final JAXBContext context = JAXBContext.newInstance(GameWrapper.class);
            final Unmarshaller umsllr = context.createUnmarshaller();
            final GameWrapper gwppr = (GameWrapper) umsllr.unmarshal(file);
            user = gwppr.getPlayer();
            ship = gwppr.getShip();
            currSol = gwppr.getSolarSystem();
            currStar = gwppr.getStar();
            univ = gwppr.getUniv();
            starloc = new SimpleStringProperty("Solar system: " + currStar.getName());
            solloc = new SimpleStringProperty("Planet: " + currSol.getName());
            techLevel = new SimpleStringProperty("Tech level: " + currStar.getTechLevelName());
            resource = new SimpleStringProperty("Resource: " + currStar.getResourceName());
        } catch (Exception e) {
            Dialogs.create()
                    .title("Error")
                    .masthead("Could not load data from file:\n" + file.getPath())
                    .showException(e);
        }
    }
    
    /**
     * Save the current game
     * @param file the game to load
     */
    public void saveGame(File file) {
        try {
            final JAXBContext context = JAXBContext.newInstance(GameWrapper.class);
            final Marshaller msllr = context.createMarshaller();
            msllr.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            final GameWrapper gwrppr = new GameWrapper();
            gwrppr.setPlayer(user);
            gwrppr.setShip(ship);
            gwrppr.setSolarSystem(currSol);
            gwrppr.setStar(currStar);
            gwrppr.setUniv(univ);
            msllr.marshal(gwrppr, file);
        } catch (Exception e) {
            Dialogs.create()
                    .title("Error")
                    .masthead("Could not save data to file:\n" + file.getPath())
                    .showException(e);
        }
    }
    
    /**
     * Launch the game
     * @param args 
     * @change
     */ 
    public static void main(String... varargs) {
        launch(varargs);
    }
}