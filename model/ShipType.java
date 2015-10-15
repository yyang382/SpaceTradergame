package project.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * class ShipType. Stores all the ship properties and methods.
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
public class ShipType {
    /**
     * name of shiptype
     */
    private final String name;
    /**
     * attributes of shiptype
     */
    private final int cargoSpace;
    /**
     * attributes of shiptype
     */
    private final int fuel;
    /**
     * attributes of shiptype
     */
    private final int fuelCost;
    /**
     * attributes of shiptype
     */
    private final int price;
    /**
     * attributes of shiptype
     */
    private final int hullStrength;
    /**
     * attributes of shiptype
     */
    private final int weaponSlots;
    /**
     * attributes of shiptype
     */
    private final int shieldSlots;
    /**
     * attributes of shiptype
     */
    private final int gadgetSlots;
    
    /**
     * ShipType's constructor
     * @param name shipType data
     * @param cargoSpace shipType data
     * @param fuel shipType data
     * @param fuelCost shipType data
     * @param price shipType data
     * @param hullStrength shipType data
     * @param weaponSlots shipType data
     * @param shieldSlots shipType data
     * @param gadgetSlots shipType data
     */
    public ShipType(String name, int cargoSpace, int fuel,
    		int fuelCost, int price, int hullStrength,
                   int weaponSlots, int shieldSlots, int gadgetSlots) {
        this.name = name;
        this.cargoSpace = cargoSpace;
        this.fuel = fuel;
        this.fuelCost = fuelCost;
        this.price = price;
        this.hullStrength = hullStrength;
        this.weaponSlots = weaponSlots;
        this.shieldSlots = shieldSlots;
        this.gadgetSlots = gadgetSlots;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getCargoSpace() {
        return cargoSpace;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getPrice() {
        return price;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getFuel() {
        return fuel;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getFuelCost() {
        return fuelCost;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getHullStrength() {
        return hullStrength;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getWeaponSlots() {
        return weaponSlots;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getShieldSlots() {
        return shieldSlots;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public int getGadgetSlots() {
        return gadgetSlots;
    }
    /**
     * Getter for name
     * @return ShipType's name
     */
    public StringProperty getN() {
        return new SimpleStringProperty(name);
    }
    /**
     * Getter for cargoSpace
     * @return ShipType's cargoSpace
     */
    public IntegerProperty getCS() {
        return new SimpleIntegerProperty(cargoSpace);
    }
    /**
     * Getter for fuel
     * @return ShipType's fuel
     */
    public IntegerProperty getFU() {
        return new SimpleIntegerProperty(fuel);
    }
    /**
     * Getter for fuelCost
     * @return ShipType's fuelCost
     */
    public IntegerProperty getFC() {
        return new SimpleIntegerProperty(fuelCost);
    }
    /**
     * Getter for price
     * @return ShipType's price
     */
    public IntegerProperty getP() {
        return new SimpleIntegerProperty(price);
    }
    /**
     * Getter for hullStrength
     * @return ShipType's hullStrength
     */
    public IntegerProperty getHS() {
        return new SimpleIntegerProperty(hullStrength);
    }
    /**
     * Getter for weaponSlots
     * @return ShipType's weaponSlots
     */
    public IntegerProperty getWS() {
        return new SimpleIntegerProperty(weaponSlots);
    }
    /**
     * Getter for shieldSlots
     * @return ShipType's shieldSlots
     */
    public IntegerProperty getSS() {
        return new SimpleIntegerProperty(shieldSlots);
    }
    /**
     * Getter for gadgetSlots
     * @return ShipType's gadgetSlots
     */
    public IntegerProperty getGS() {
        return new SimpleIntegerProperty(gadgetSlots);
    }
}
