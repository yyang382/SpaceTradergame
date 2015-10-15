package project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Weapon. Can be used on ship and is used to fight enemies
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Weapon {
    /**
     * attribute of water
     */
    private String name;
    /**
     * attribute of water
     */
    private int price;
    /**
     * attribute of water
     */
    private int damage;
    /**
     * Weapon's constructor
     */
    public Weapon() {
        //intentionally left blank
    }
    /**
     * Weapon's constructor
     * @param name
     * @param price
     * @param damage
     */
    public Weapon(String name, int price, int damage) {
        this.name = name;
        this.price = price;
        this.damage = damage;
    }
    /**
     * Getter for name
     * return name
     */
    @XmlElement
    public String getName() {
        return name;
    }
    /**
     * Getter for price
     * return price
     */
    @XmlElement
    public int getPrice() {
        return price;
    }
    /**
     * Getter for damage
     * return damage
     */
    @XmlElement
    public int getDamage() {
        return damage;
    }
    /**
     * Getter for StringProperty of name
     * return StringProperty of name
     */
    public StringProperty getN() {
        return new SimpleStringProperty(name);
    }
    /**
     * Getter for IntegerProperty of price
     * return IntegerProperty of price
     */
    public IntegerProperty getP() {
        return new SimpleIntegerProperty(price);
    }
    /**
     * Getter for IntegerProperty of name
     * return IntegerProperty of name
     */
    public IntegerProperty getD() {
        return new SimpleIntegerProperty(damage);
    }
    /**
     * Setter for name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Setter for price
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Setter for damage
     * @param damage the pdamagerice to set
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
}