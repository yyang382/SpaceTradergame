package project.view;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import project.MainApp;
import project.model.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
/**
 * Controller for shipYard display
 * @author Xie Jiateng
 */
public class ShipYardController {
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableView<ShipType> shipTable;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableView<Weapon> weaponTable;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableView<Shield> shieldTable;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableView<Gadget> gadgetTable;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, String> nameColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number> priceColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number> costColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number> strengthColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number>  fuelColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number> cargoColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number> weaponColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number> shieldColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<ShipType, Number> gadgetColumn;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Weapon, String> weaponName;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Shield, String> shieldName;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Gadget, String> gadgetName;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Weapon, Number> weaponDamage;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Weapon, Number> weaponPrice;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Shield, Number> shieldStrength;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Shield, Number> shieldPrice;
    /**
     * attributes of ShipYardController
     */
    @FXML
    private TableColumn<Gadget, Number> gadgetPrice;
    /**
     * attributes of ShipYardController
     */
    private Stage shipYardStage;
    /**
     * attributes of ShipYardController
     */
    private MainApp mainApp;
    /**
     * show the yard
     */
    public void show() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getN());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().getP());
        strengthColumn.setCellValueFactory(cellData -> cellData.getValue().getHS());
        fuelColumn.setCellValueFactory(cellData -> cellData.getValue().getFU());
        cargoColumn.setCellValueFactory(cellData -> cellData.getValue().getCS());
        costColumn.setCellValueFactory(cellData -> cellData.getValue().getFC());
        weaponColumn.setCellValueFactory(cellData -> cellData.getValue().getWS());
        shieldColumn.setCellValueFactory(cellData -> cellData.getValue().getSS());
        gadgetColumn.setCellValueFactory(cellData -> cellData.getValue().getGS());
        weaponName.setCellValueFactory(cellData -> cellData.getValue().getN());
        weaponDamage.setCellValueFactory(cellData -> cellData.getValue().getD());
        weaponPrice.setCellValueFactory(cellData -> cellData.getValue().getP());
        shieldName.setCellValueFactory(cellData -> cellData.getValue().getN());
        shieldStrength.setCellValueFactory(cellData -> cellData.getValue().getS());
        shieldPrice.setCellValueFactory(cellData -> cellData.getValue().getP());
        gadgetName.setCellValueFactory(cellData -> cellData.getValue().getN());
        gadgetPrice.setCellValueFactory(cellData -> cellData.getValue().getP());
    }
    /**
     * Setter for shipYard
     * @param shipYardStage the shipYardstage to set 
     */
    public void setShipYardStage(Stage shipYardStage) {
        this.shipYardStage = shipYardStage;
    }
    /**
     * Setter for the items of shipTable
     * @param dataA dataA list of good
     */
    public void setShipTable(ObservableList<ShipType> dataA) {
        shipTable.setItems(dataA);
    }
    /**
     * Setter for weaponTable
     * @param dataA the weaponTable to set
     */
    public void setWeaponTable(ObservableList<Weapon> dataA) {
        weaponTable.setItems(dataA);
    }
    /**
     * Setter for shieldTable
     * @param dataA the shieldTable to set
     */
    public void setShieldTable(ObservableList<Shield> dataA) {
        shieldTable.setItems(dataA);
    }
    /**
     * Setter for gadgetTable
     * @param dataA the gadgetTable to set
     */
    public void setGadgetTable(ObservableList<Gadget> dataA) {
        gadgetTable.setItems(dataA);
    }
    /**
     * Setter for mainApp
     * @param mainApp the mainApp to set
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Button handler used in javaFX
     */
    @FXML
    private void buttonHandler() {
        ShipType dataA = shipTable.getSelectionModel().getSelectedItem();
        Weapon bdata = weaponTable.getSelectionModel().getSelectedItem();
        Shield cdata = shieldTable.getSelectionModel().getSelectedItem();
        Gadget ddata = gadgetTable.getSelectionModel().getSelectedItem();
        if (dataA != null) {
            mainApp.getShip().purchaseShip(dataA);
        } else if (bdata != null) {
            mainApp.getShip().purchaseWeapon(bdata);
        } else if (cdata != null) {
            mainApp.getShip().purchaseShield(cdata);
        } else if (ddata != null) {
            mainApp.getShip().purchaseGadget(ddata);
        } else {
            Dialogs.create()
                    .title("Error!")
                    .message("Nothing selected!")
                    .showError();   
        }
    }
    /**
     * Button handler used in javaFX
     */
    @FXML
    private void buttonHandler1() {
        if (mainApp.getShip().getHullDamaged() == 0) {
            Dialogs.create()
                    .title("No need for that.")
                    .message("Your hull is not damaged!")
                    .showInformation();     
        } else if (mainApp.getShip().getMoney() < 10) {
            Dialogs.create()
                    .title("Error!")
                    .message("You don't have enough money!")
                    .showError();   
        } else {
            String dataA = "Repair your hull at cost ";
            int bdata = 0;
            if (mainApp.getShip().getMoney() < mainApp.getShip().getHullDamaged() * 10) {
                bdata = mainApp.getShip().getMoney() / 10;
            } else {
                bdata = mainApp.getShip().getHullDamaged();
            }
            dataA += bdata * 10 + " for " + bdata + " damage point?";
            Action response = Dialogs.create()
                                      .owner(shipYardStage)
                                      .title("Hull Repair")
                                      .message(dataA) 
                                      .showConfirm();
            if (response == Dialog.Actions.YES) {
                mainApp.getShip().hullRepair(bdata);
                Dialogs.create()
                        .title("Hull repaired!")
                        .message("Your ship's hull strength now is "
                                 + (mainApp.getShip().getHullStrength()
                                 - mainApp.getShip().getHullDamaged())
                                 + ". Your money left is " + mainApp.getShip().getMoney())
                                 .showInformation();
            }
        }
    }
    /**
     * Button handler used in javaFX
     */
    @FXML
    private void buttonHandler2() {
        mainApp.showFuelStation();
    }
    /**
     * Button handler used in javaFX
     */
    @FXML
    private void buttonHandler3() {
        shipYardStage.close();
    }
}