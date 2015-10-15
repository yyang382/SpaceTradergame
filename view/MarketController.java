package project.view;

import org.controlsfx.dialog.Dialogs;

import project.MainApp;
import project.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
/**
 * Controller for Market display
 * @author Xie Jiateng
 */
public class MarketController {
    /**
     * attributes of MarketController
     */
    @FXML
    private TableView<Good> itemTable1;
    /**
     * attributes of MarketController
     */
    @FXML
    private TableView<Good> itemTable2;
    /**
     * attributes of MarketController
     */
    @FXML
    private TableColumn<Good, String> itemColumn1;
    /**
     * attributes of MarketController
     */
    @FXML
    private TableColumn<Good, String> itemColumn2;
    /**
     * attributes of MarketController
     */
    @FXML
    private TableColumn<Good, Number> priceColumn1;
    /**
     * attributes of MarketController
     */
    @FXML
    private TableColumn<Good, Number> priceColumn2;
    /**
     * attributes of MarketController
     */
    @FXML
    private TableColumn<Good, Number> quantityColumn2;
    /**
     * attributes of MarketController
     */
    private Stage marketStage;
    /**
     * attributes of MarketController
     */
    private MainApp mainApp;
    /**
     * Setter for mainApp
     * @param mainApp the mainApp
     */
    public void setMarketStage(Stage marketStage) {
        this.marketStage = marketStage;
    }
    /**
     * Show the Market on teh screen
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * The method to show the market to user
     */
    public void show() {
        itemColumn1.setCellValueFactory(cellData -> cellData.getValue().getN());
        itemColumn2.setCellValueFactory(cellData -> cellData.getValue().getN());
        priceColumn1.setCellValueFactory(cellData -> cellData.getValue().getP());
        priceColumn2.setCellValueFactory(cellData -> cellData.getValue().getP());
        quantityColumn2.setCellValueFactory(cellData -> cellData.getValue().getQ());
    }
    /**
     * Setter for items of itemTable1
     * @param data list of goods
     */
    public void setItemTable1(ObservableList<Good> data) {
        itemTable1.setItems(data);
    }
    /**
     * Stter for items of itemTable2
     * @param data list of goods
     */
    public void setItemTable2(ObservableList<Good> data) {
        itemTable2.setItems(data);
    }
    
    /**
     * The handler to close the marketStage
     */
    @FXML
    private void buttonHandler() {
        marketStage.close();
    }
    
    
    @FXML
    private void buttonHandler1() {
        Good temp = itemTable1.getSelectionModel().getSelectedItem();
        boolean nulltemp = temp != null;
        if (nulltemp) {
            if (mainApp.getShip().getCargoSpace() - mainApp.getShip().size() == 0) {
                Dialogs.create()
                        .title("Error!")
                        .message("Cargo is full")
                        .showError();
            } else {
                Good data = temp.copy();
                data.setPrice(temp.getPrice());
                mainApp.showGoodQuantity(mainApp.getShip().getCargoSpace()
                                         - mainApp.getShip().size(), "Buy", data, true, itemTable2);
            } 
        } else {
            Dialogs.create()
                    .title("Error!")
                    .message("No item to be bought is selected!")
                    .showError();
        }
    }
    
    @FXML
    private void buttonHandler2() {
        Good temp = itemTable2.getSelectionModel().getSelectedItem();
        boolean nulltemp = temp != null;
        if (nulltemp) {
            Good data = temp.copy();
            data.setPrice(temp.getPrice());
            ObservableList<Good> hdata = mainApp.getShip().getCargoList();
            mainApp.showGoodQuantity(
                    hdata.get(
                            hdata.indexOf(data)).getQuantity(), "Sell",
                            data, false, itemTable2);
        } else {
            Dialogs.create()
                    .title("Error!")
                    .message("No item to be sold is selected!")
                    .showError();
        }
    }
}