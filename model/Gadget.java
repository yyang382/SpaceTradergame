package project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * Class for gadget, which could be bought in game
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Gadget {
    /**
     * basic field of GameWrapper
     */
    private String name;
    /**
     * basic field of GameWrapper
     */
    private int price;
    
    /**
     * Constructor for Gadget
     */ 
    public Gadget() {
        //intentionally left empty
    }
    
    /**
     * Constructor for Weapon
     */ 
    public Gadget(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    /**
     * Getter of name
     */ 
    @XmlElement
    public String getName() {
        return name;
    }
    
    /**
     * Getter of price
     */ 
    @XmlElement
    public int getPrice() {
        return price;
    }
    
    /**
     * Getter of string property of name
     */ 
    public StringProperty getN() {
        return new SimpleStringProperty(name);
    }
    
    /**
     * Getter of integer property of price
     */ 
    public IntegerProperty getP() {
        return new SimpleIntegerProperty(price);
    }
    
    /**
     * Setter of name
     */ 
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter of price
     */ 
    public void setPrice(int price) {
        this.price = price;
    }
}