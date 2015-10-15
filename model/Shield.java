package project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Abstract class shield
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Shield {
    
    /**
     * name of shield
     */
    private String name;
    /**
     * basic field of shield
     */
    private int price;
    
    /**
     * basic field of shield
     */
    private int strength;
    
    /**
     * Alternate constructor
     */
    public Shield() {
        //Intentionally left blank
    }

    /**
     * Shield's constructor
     * @param name shield's name
     * @param price shield's price
     * @param strength shield's strength
     */
    public Shield(String name, int price, int strength) {
        this.name = name;
        this.price = price;
        this.strength = strength;
    }
    
    /**
     * Getter for name
     * @return shield's name
     */
    @XmlElement
    public String getName() {
        return name;
    }
    
    /**
     * Getter for price
     * @return shield's price
     */
    @XmlElement
    public int getPrice() {
        return price;
    }
    
    /**
     * Getter for strength
     * @return shield's strength
     */
    @XmlElement
    public int getStrength() {
        return strength;
    }
    
    /**
     * Getter for name
     * @return shield's name
     */
    public StringProperty getN() {
        return new SimpleStringProperty(name);
    }
    
    /**
     * IntegerProperty representation of price
     * @return IntegerProperty of price
     */
    public IntegerProperty getP() {
        return new SimpleIntegerProperty(price);
    }
    
    /**
     * IntegerProperty representation of strength
     * @return IntegerProperty of strength
     */
    public IntegerProperty getS() {
        return new SimpleIntegerProperty(strength);
    }
    
    /**
     * Setter for name
     * @param name Shield's new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter for price
     * @param name Shield's new price
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /**
     * Setter for strength
     * @param name Shield's new strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }
}