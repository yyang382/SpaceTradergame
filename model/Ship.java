package project.model;

import java.util.ArrayList;

import org.controlsfx.dialog.Dialogs;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
/**
 * Ship. Has weapon, can travel, can buy and sell goods
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
@XmlSeeAlso( {Firearms.class, Food.class, Furs.class, Games.class, Machines.class,
              Medicine.class, Narcotics.class, Ore.class, Robots.class, Water.class,
              AutorepairSystem.class, BeamLaser.class, CloakingDevice.class, EnergyShield.class,
              FiveExtra.class, MilitaryLaser.class, PulseLaser.class, ReflectiveShield.class,
              TargetingSystem.class,
              } )
public class Ship {
    
    /**
     * String property data
     */
    private StringProperty moneyLabel;
    /**
     * String property data
     */
    private StringProperty cargoSpaceLabel;
    /**
     * String property data
     */
    private StringProperty fuelLabel;
    /**
     * String property data
     */
    private StringProperty  hullStrengthLabel;
    /**
     * double property of ship
     */
    private DoubleProperty fuelPercentage;
    /**
     * basic int fields
     */
    private int cargoSpace;
    /**
     * basic int fields
     */
    private int fuel;
    /**
     * basic int fields
     */
    private int fuelCost;
    /**
     * basic int fields
     */
    private int price;
    /**
     * basic int fields
     */
    private int hullStrength;
    /**
     * basic int fields
     */
    private int money;
    /**
     * basic int fields
     */
    private int fuelLeft;
    /**
     * basic int fields
     */
    private int weaponSlots;
    /**
     * basic int fields
     */
    private int shieldSlots; 
    /**
     * basic int fields
     */
    private int gadgetSlots;
    /**
     * basic int fields
     */
    private int hullDamaged;
    /**
     * name of ship
     */
    private String name;
    /**
     * cargo list
     */
    private ObservableList<Good> cargo = FXCollections.observableArrayList();
    /**
     * sellable list
     */
    private final ObservableList<Good> sellable = FXCollections.observableArrayList();
    /**
     * wepon list
     */
    private ArrayList<Weapon> weapon;
    /**
     * shield list
     */
    private ArrayList<Shield> shield;
    /**
     * badget list
     */
    private ArrayList<Gadget> gadget;
    
    /**
     * no-arg constructor
     */
    public Ship() {
        //Intentionally left blank
    	fuelPercentage = new SimpleDoubleProperty(0);
    	moneyLabel = new SimpleStringProperty(null);
    	cargoSpaceLabel = new SimpleStringProperty(null);
    	fuelLabel = new SimpleStringProperty(null);
    	hullStrengthLabel = new SimpleStringProperty(null);
    }
    
    /**
     * Ship's constructor
     * @param shiptype ship type
     */
    public Ship(ShipType shiptype) {
        this.name = shiptype.getName();
        this.cargoSpace = shiptype.getCargoSpace();
        this.fuel = shiptype.getFuel();
        this.fuelCost = shiptype.getFuelCost();
        this.price = shiptype.getPrice();
        this.hullStrength = shiptype.getHullStrength();
        this.weaponSlots = shiptype.getWeaponSlots();
        this.shieldSlots = shiptype.getShieldSlots();
        this.gadgetSlots = shiptype.getGadgetSlots();
        weapon = new ArrayList<Weapon>();
        shield = new ArrayList<Shield>();
        gadget = new ArrayList<Gadget>();
        money = 100000;
        fuelLeft = fuel;
        hullDamaged = 0;
        fuelPercentage = new SimpleDoubleProperty((double) fuelLeft / (double) fuel);
        moneyLabel = new SimpleStringProperty("" + money);
        cargoSpaceLabel = new SimpleStringProperty("" + (cargoSpace - size()) + "/" + cargoSpace);
        fuelLabel = new SimpleStringProperty("Fuel: " + fuelLeft + "/" + fuel);
        hullStrengthLabel = new SimpleStringProperty("" + (hullStrength - hullDamaged)
        											 + "/" + hullStrength);
    }
    
    /**
     * Getter for name
     * @return name
     */
    @XmlElement
    public String getName() {
        return name;
    }
    
    /**
     * Getter for cargoSpace
     * @return cargoSpace
     */
    @XmlElement
    public int getCargoSpace() {
        return cargoSpace;
    }
    
    /**
     * Getter for fuel
     * @return fuel
     */
    @XmlElement
    public int getFuel() {
        return fuel;
    }
    
    /**
     * Getter for fuelCost
     * @return fuelCost
     */
    @XmlElement
    public int getFuelCost() {
        return fuelCost;
    }
    
    /**
     * Getter for price
     * @return price
     */
    @XmlElement
    public int getPrice() {
        return price;
    }
    
    /**
     * Getter for hullStrength
     * @return hullStrength
     */
    @XmlElement
    public int getHullStrength() {
        return hullStrength;
    }
    
    /**
     * Getter for weaponSlots
     * @return weaponSlots
     */
    @XmlElement
    public int getWeaponSlots() {
        return weaponSlots;
    }
    
    /**
     * Getter for shieldSlots
     * @return shieldSlots
     */
    @XmlElement
    public int getShieldSlots() {
        return shieldSlots;
    }
    
    /**
     * Getter for gadgetSlots
     * @return gadgetSlots
     */
    @XmlElement
    public int getGadgetSlots() {
        return gadgetSlots;
    }
    
    /**
     * Getter for money
     * @return money
     */
    @XmlElement
    public int getMoney() {
        return money;
    }
    
    /**
     * Getter for cargo
     * @return cargo
     */
    @XmlElementWrapper
    @XmlAnyElement(lax = true)
    public ObservableList<Good> getCargoList() {
        return cargo;
    }
    
    /**
     * Getter for weapon
     * @return weapon
     */
    @XmlElementWrapper
    @XmlAnyElement(lax = true)
    public ArrayList<Weapon> getWeaponList() {
        return weapon;
    }
    
    /**
     * Getter for shield
     * @return shield
     */
    @XmlElementWrapper
    @XmlAnyElement(lax = true)
    public ArrayList<Shield> getShieldList() {
        return shield;
    }
    
    /**
     * Getter for gadget
     * @return gadget
     */
    @XmlElementWrapper
    @XmlAnyElement(lax = true)
    public ArrayList<Gadget> getGadgetList() {
        return gadget;
    }
    
    /**
     * Getter for fuelLeft
     * @return fuelLeft
     */
    @XmlElement
    public int getFuelLeft() {
        return fuelLeft;
    }
    /**
     * Getter for hullDamaged
     * @return hullDamaged
     */
    @XmlElement
    public int getHullDamaged() {
        return hullDamaged;
    }
    /**
     * Setter for name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Setter for cargoSpace
     * @param cargoSpace new cargoSpace
     */
    public void setCargoSpace(int cargoSpace) {
        this.cargoSpace = cargoSpace;
    }
    /**
     * Setter for fuel
     * @param fuel new fuel
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    /**
     * Setter for fuelCost
     * @param fcost new fuelCost
     */
    public void setFuelCost(int fcost) {
        fuelCost = fcost;
    }
    /**
     * Setter for price
     * @param price new price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Setter for hullStrength
     * @param hstr new hullStrength
     */
    public void setHullStrength(int hstr) {
        hullStrength = hstr;
        setHullStrengthLabel("" + (hullStrength - hullDamaged) + "/" + hullStrength);
    }
    /**
     * Setter for weaponSlots
     * @param wslot new weaponSlots
     */
    public void setWeaponSlots(int wslot) {
        weaponSlots = wslot;
    }
    /**
     * Setter for shieldSlots
     * @param sslot new shieldSlots
     */
    public void setShieldSlots(int sslot) {
        shieldSlots = sslot;
    }
    /**
     * Setter for gadgetSlots
     * @param gslot new gadgetSlots
     */
    public void setGadgetSlots(int gslot) {
        gadgetSlots = gslot;
    }
    /**
     * Setter for money
     * @param name new money
     */
    public void setMoney(int money) {
        this.money = money;
        setMoneyLabel("" + money);
    }
    /**
     * Setter for cargo
     * @param glist new cargo
     */
    public void setCargoList(ObservableList<Good> glist) {
        cargo = glist;
    }
    /**
     * Setter for weapon
     * @param wlist new weapon
     */
    public void setWeaponList(ArrayList<Weapon> wlist) {
        weapon = wlist;
    }
    /**
     * Setter for shield
     * @param slist new shield
     */
    public void setShieldList(ArrayList<Shield> slist) {
        shield = slist;
    }
    /**
     * Setter for gadget
     * @param glist new gadget
     */
    public void setGadgetList(ArrayList<Gadget> glist) {
        gadget = glist;
    }
    /**
     * Setter for fuelLeft
     * @param fleft new fuelLeft
     */
    public void setFuelLeft(int fleft) {
        fuelLeft = fleft;
    }
    /**
     * Setter for hullDamaged
     * @param hdmg new hullDamaged
     */
    public void setHullDamaged(int hdmg) {
        hullDamaged = hdmg;
        setHullStrengthLabel("" + (hullStrength - hullDamaged) + "/" + hullStrength);
    }
    /**
     * get the size of goods on ship
     * @return the size of goods on ship
     */
    public int size() {
        int size = 0;
        for (Good good : cargo) {
            size += good.getQuantity();
        }
        return size;
    }
    
    /**
     * get the total damage points of this ship
     * @return the damage points
     */
    public int getDamage() {
		int ret = 0;
		for (Weapon w: weapon) {
			ret += w.getDamage();
		}
		return ret;
	}
	
    /**
     * get the total shield points of this ship
     * @return the shield points
     */
	public int getShield() {
		int ret = 0;
		for (Shield s: shield) {
			ret += s.getStrength();
		}
		return ret;
	}
	
    /**
     * buy a good to ship. If no enough space or no enough money, show error
     * @param  good to buy
     * @return if the purchase is successful then return true, false if not
     */
    public boolean buy(Good good) {
        if ((cargoSpace - size() - good.getQuantity()) < 0) {
                Dialogs.create()
                        .title("Error!")
                        .message("No enough spaces left!")
                        .showError();
        } else if (money < good.total()) {
                Dialogs.create()
                        .title("Error!")
                        .message("Money is not enough!");
                     //   .showError();
        } else {
            if (!cargo.contains(good)) {
                cargo.add(good);
            } else {
                for (Good agood : cargo) {
                    if (agood.getName() == good.getName()) {
                        agood.increaseQuantity(good.getQuantity());
                    }
                }
            }
            this.setMoney(this.getMoney() - good.getPrice());
            money = money - good.total();
            setMoneyLabel("" + money);
            setCargoSpaceLabel("" + (cargoSpace - size()) + "/" + cargoSpace);
            //Dialogs.create()
              //      .title("Bought")
                //    .message(this.toString())
                 //   .showInformation();
            return true;
        }
        return false;
    }
    /**
     * Sell a good from ship.
     * @param good good to sell
     */
    public void sell(Good good) {
        if (cargo.get(cargo.indexOf(good)).getQuantity() == good.getQuantity()) { 
            cargo.remove(good);
        } else {
            cargo.get(cargo.indexOf(good)).decreaseQuantity(good.getQuantity());
        }
        money += good.total();
        setMoneyLabel("" + money);
        setCargoSpaceLabel("" + (cargoSpace - size()) + "/" + cargoSpace);
        Dialogs.create()
                .title("Sold")
                .message(this.toString())
                .showInformation();
    }
    /**
     * Travel between stars. If fuel is not enough, show error
     * @return if the travel is successful
     */
    public boolean travel(int mileage) {
		if (hullDamaged == hullStrength) {
			Dialogs.create()
					.title("Emergency!")
					.message("Your ship is broken and is not able to travel!")
					.showError();
			return false;
		}
        if ((fuelLeft - mileage) < 0) {
            Dialogs.create()
                    .title("Emergency!")
                    .message("Do not have enough fuel left!")
                    .showError();
            return false;
        } else {
            fuelLeft -= mileage;
            setFuelLabel("Fuel: " + fuelLeft + "/" + fuel);
            setFuelPercentage((double) fuelLeft / (double) fuel);
            return true;
        }
    }
    /**
     * Override toString method
     * @return the string representation of ship
     */
    public String toString() {
        String temp = "You currently have:\n";
        for (int i = 0; i < cargo.size() - 1; i++) {
            temp += cargo.get(i).getQuantity() + " " + cargo.get(i).getName() + ", ";
        }
        if (cargo.size() >= 1) {
            temp += cargo.get(cargo.size() - 1).getQuantity() + " "
                 + cargo.get(cargo.size() - 1).getName();
        }
        temp += "\nYour cargo space left is " + (cargoSpace - size())
             + "\nYour money left is " + money + ".";
        return temp;
    }
    /**
     * Purchase ship. If money is not enough,
     * or there are too many goods in cargo, show error
     * @param name the name of the ship to buy
     * @return true if the purchase is successful, false if not
     */
    public boolean purchaseShip(ShipType shiptype) {
        if (money + price < shiptype.getPrice()) {
            Dialogs.create()
                    .title("Error!")
                    .message("Money is not enough!")
                    .showError();
            return false;
        }
        this.name = shiptype.getName();
        money = money - shiptype.getPrice() + price;
        price = shiptype.getPrice();
        cargoSpace = shiptype.getCargoSpace();
        fuel = shiptype.getFuel();
        fuelCost = shiptype.getFuelCost();
        hullStrength = shiptype.getHullStrength();
        weaponSlots = shiptype.getWeaponSlots();
        shieldSlots = shiptype.getShieldSlots();
        gadgetSlots = shiptype.getGadgetSlots();
        hullDamaged = 0;
        cargo.clear();
        setMoneyLabel("" + money);
        setCargoSpaceLabel("" + (cargoSpace - size()) + "/" + cargoSpace);
        setFuelLabel("Fuel: " + fuelLeft + "/" + fuel);
        setHullStrengthLabel("" + (hullStrength - hullDamaged) + "/" + hullStrength);
        setFuelPercentage((double) fuelLeft / (double) fuel);
        Dialogs.create()
                .title("Succeeded!")
                .message("Got your new ship " + name + "! You got " + money + " money left!")
                .showInformation();
        return true;
    }
    /**
     * Purchase fuel. If money is not enough, show error
     * @param amount the amount of the fuel to buy
     * @return if the purchase is successful
     */
    public boolean purchaseFuel(int amount) {
        if (amount * fuelCost > money) {
            Dialogs.create()
                    .title("Error!")
                    .message("Money is not enough!")
                    .showError();
            return false;
        }
        money -= amount * fuelCost;
        fuelLeft += amount;
        setMoneyLabel("" + money);
        setFuelLabel("Fuel: " + fuelLeft + "/" + fuel);
        setFuelPercentage((double) fuelLeft / (double) fuel);
        return true;
    }
    /**
     * Purchase weapon. If money is not enough,
     * or there are too many weapon in cargo, show error
     * @param aweapon the weapon to buy
     * @return true if the purchase is successful, false if not
     */
    public boolean purchaseWeapon(Weapon aweapon) {
        if (weapon.size() >= weaponSlots) {
            Dialogs.create()
                    .title("Error!")
                    .message("Don't have enough slots left")
                    .showError();
            return false;
        }
        if (aweapon.getPrice() > money) {
            Dialogs.create()
                    .title("Error!")
                    .message("Money is not enough!")
                    .showError();
            return false;
        }
        weapon.add(aweapon);
        money -= aweapon.getPrice();
        setMoneyLabel("" + money);
        return true;
    }
    /**
     * Purchase shield. If money is not enough,
     * or there are too many shield in cargo, show error
     * @param ashield the shield to buy
     * @return true if the purchase is successful, false if not
     */
    public boolean purchaseShield(Shield ashield) {
        if (shield.size() >= shieldSlots) {
            Dialogs.create()
                    .title("Error!")
                    .message("Don't have enough slots left")
                    .showError();
            return false;
        }
        if (ashield.getPrice() > money) {
            Dialogs.create()
                    .title("Error!")
                    .message("Money is not enough!")
                    .showError();
            return false;
        }
        shield.add(ashield);
        money -= ashield.getPrice();
        setMoneyLabel("" + money);
        return true;
    }
    /**
     * Purchase gadget. If money is not enough,
     * or there are too many gadget in cargo, show error
     * @param agadget the gadget to buy
     * @return true if the purchase is successful, false if not
     */
    public boolean purchaseGadget(Gadget agadget) {
        if (gadget.size() >= gadgetSlots) {
            Dialogs.create()
                    .title("Error!")
                    .message("Don't have enough slots left")
                    .showError();
            return false;
        }
        if (agadget.getPrice() > money) {
            Dialogs.create()
                    .title("Error!")
                    .message("Money is not enough!")
                    .showError();
            return false;
        }
        if (gadget.contains(agadget)) {
            Dialogs.create()
                    .title("Error!")
                    .message("You've already got one of this.")
                    .showError();
            return false;
        }
        gadget.add(agadget);
        money -= agadget.getPrice();
        setMoneyLabel("" + money);
        return true;
    }
    /**
     * Repair hull
     * @param number number of damage to repair
     */
    public void hullRepair(int number) {
        money -= number;
        hullDamaged -= number;
        setMoneyLabel("" + money);
        setHullStrengthLabel("" + (hullStrength - hullDamaged) + "/" + hullStrength);
    }
    /**
     * setter for good price
     * @param list the data to be set
     */
    public void setGoodPrice(ObservableList<Good> list) {
        for (Good agood : list) {
            if (cargo.contains(agood)) {
                cargo.get(cargo.indexOf(agood)).setPrice(agood.getPrice());
            }
        }
    }
    
    /**
     * getter for good sellablelist
     * @param techlevel the techlevel of cargo
     * @return the sellable list
     */
    public ObservableList<Good> getSellableList(int techLevel) {
        sellable.clear();
        for (Good good : cargo) {
            if (good.getMTLU() <= techLevel) {
                sellable.add(good);
            }
        }
        return sellable;
    }
    /**
     * getter for good moneyLabel
     * @return the moneyLabel
     */
    @XmlElement
    public String getMoneyLabel() {
        return moneyLabel.get();
    }
    /**
     * getter for good cargoSpaceLabel
     * @return the cargoSpaceLabel
     */
    @XmlElement
    public String getCargoSpaceLabel() {
        return cargoSpaceLabel.get();
    }
    /**
     * getter for good fuelLabel
     * @return the fuelLabel
     */
    @XmlElement
    public String getFuelLabel() {
        return fuelLabel.get();
    }
    /**
     * getter for good hullStrengthLabel
     * @return the hullStrengthLabel
     */
    @XmlElement
    public String getHullStrengthLabel() {
        return hullStrengthLabel.get();
    }
    /**
     * getter for good fuelPercentage
     * @return the fuelPercentage
     */
    @XmlElement
    public double getFuelPercentage() {
        return fuelPercentage.get();
    }
    
    /**
     * setter for good moneyLabel
     * @param moneylabel the data to be set
     */
    public void setMoneyLabel(String moneylabel) {
        moneyLabel.set(moneylabel);
    }
    
    /**
     * setter for good cargoSpaceLabel
     * @param cargospacelabel the data to be set
     */
    public void setCargoSpaceLabel(String cargospacelabel) {
        cargoSpaceLabel.set(cargospacelabel);
    }
    
    /**
     * setter for good fuelLabel
     * @param flabel the data to be set
     */
    public void setFuelLabel(String flabel) {
        fuelLabel.set(flabel);
    }
    
    /**
     * setter for good hullStrengthLabel
     * @param hslabel the data to be set
     */
    public void setHullStrengthLabel(String hslabel) {
        hullStrengthLabel.set(hslabel);
    }
    
    /**
     * setter for good fuelPercentage
     * @param apercent the data to be set
     */
    public void setFuelPercentage(double apercent) {
        fuelPercentage.set(apercent);
    }
    /**
     * ship information
     * @return ship information
     */
    public void shipInfo() {
    		String temp = "Ship type: " + name + "\nCargo space: " + (cargoSpace - size())
    				   + "/" + cargoSpace + "\nFuel cost: " + fuelCost + "\nWeapon slots: "
    				   + (weaponSlots - weapon.size()) + "/" + weaponSlots + "\nShield slots: "
    				   + (shieldSlots - shield.size())+ "/" + shieldSlots + "\nGadget slots: "
    				   + (gadgetSlots - gadget.size())+ "/" + gadgetSlots + "\nGood list:\n";
    		for (int i = 0; i < cargo.size() - 1; i++) {
                temp += cargo.get(i).getQuantity() + " " + cargo.get(i).getName() + ", ";
            }
            if (cargo.size() >= 1) {
                temp += cargo.get(cargo.size() - 1).getQuantity() + " "
                     + cargo.get(cargo.size() - 1).getName();
            }
            temp += "\nWeapon list:\n";
            for (int j = 0; j < weapon.size() - 1; j++) {
            	temp += weapon.get(j).getName() + ", ";
            }
            if (weapon.size() >= 1) {
                temp += weapon.get(weapon.size() - 1).getName();
            }
            temp += "\nShield list:\n";
            for (int k = 0; k < shield.size() - 1; k++) {
            	temp += shield.get(k).getName() + ", ";
            }
            if (shield.size() >= 1) {
                temp += shield.get(shield.size() - 1).getName();
            }
            temp += "\nGadget list:\n";
            for (int h = 0; h < gadget.size() - 1; h++) {
            	temp += gadget.get(h).getName() + ", ";
            }
            if (gadget.size() >= 1) {
                temp += gadget.get(gadget.size() - 1).getName();
            }
    		Dialogs.create()
            		.title("Your ship info")
            		.message(temp)
            		.showInformation();
    }
    
    public StringProperty getMoneyLabelProperty() {
        return moneyLabel;
    }
    /**
     * getter for good cargoSpaceLabel
     * @return the cargoSpaceLabel
     */
    public StringProperty getCargoSpaceLabelProperty() {
        return cargoSpaceLabel;
    }
    /**
     * getter for good fuelLabel
     * @return the fuelLabel
     */
    public StringProperty getFuelLabelProperty() {
        return fuelLabel;
    }
    /**
     * getter for good hullStrengthLabel
     * @return the hullStrengthLabel
     */
    public StringProperty getHullStrengthLabelProperty() {
        return hullStrengthLabel;
    }
    /**
     * getter for good fuelPercentage
     * @return the fuelPercentage
     */
    public DoubleProperty getFuelPercentageProperty() {
        return fuelPercentage;
    }
}