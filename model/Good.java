package project.model;

import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
/**
 * Good. The items that can be bought and sold 
 * between ship and marketplaces in stars
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Good {
    
    /**
     * name of good
     */
    private String name;
    /**
     * Basic property of a good
     */
    private int baseprice;
    /**
     * Basic property of a good
     */
    private int mtlp;
    /**
     * Basic property of a good
     */
    private int mtlu;
    /**
     * Basic property of a good
     */
    private int ttp;
    /**
     * Basic property of a good
     */
    private int ipl;
    /**
     * Basic property of a good
     */
    private int var;
    /**
     * Basic property of a good
     */
    private int price;
    /**
     * Basic property of a good
     */
    private int quantity;
    /**
     * Basic property of a good
     */
    private int crppt;
    /**
     * Basic property of a good
     */
    private int erppt;
    /**
     * Property of er and crppt
     */
    private boolean crPresent;
    /**
     * Property of er and crppt
     */
    private boolean erPresent;
    /**
     * integerproperty of good
     */
    private IntegerProperty aquantity;
    /**
     * Alternate constructor for Good
     */ 
    public Good() {
        //Intentionally left empty
    }
    /**
     * Constructor for Good
     */ 
    public Good(String name, int baseprice, int mtlp, int mtlu, int ttp, int ipl, int var,
                int crppt, int erppt) {
        this.name = name;
        this.baseprice = baseprice;
        this.mtlp = mtlp;
        this.mtlu = mtlu;
        this.ttp = ttp;
        this.ipl = ipl;
        this.var = var;
        this.crppt = crppt;
        this.erppt = erppt;
        aquantity = new SimpleIntegerProperty(quantity);
    }
    /**
     * Getter for name
     * @return Good's name
     */
    @XmlElement
    public String getName() {
        return name;
    }
    /**
     * Getter for name
     * @return Good's name
     */
    @XmlElement
    public int getBasePrice() {
        return baseprice;
    }
    /**
     * Getter for MTLP
     * @return Good's name
     */
    @XmlElement
    public int getMTLP() {
        return mtlp;
    }
    /**
     * Getter for MTLU
     * @return Good's name
     */
    @XmlElement
    public int getMTLU() {
        return mtlu;
    }
    
    /**
     * Getter for TTP
     * @return Good's name
     */
    @XmlElement
    public int getTTP() {
        return ttp;
    }
    
    /**
     * Getter for IPL
     * @return Good's name
     */
    @XmlElement
    public int getIPL() {
        return ipl;
    }
    
    /**
     * Getter for VAR
     * @return Good's name
     */
    @XmlElement
    public int getVar() {
        return var;
    }
    /**
     * Getter for price
     * @return Good's name
     */
    @XmlElement
    public int getPrice() {
        return price;
    }
    /**
     * Getter for quantity
     * @return Good's name
     */
    @XmlElement
    public int getQuantity() {
        return quantity;
    }
    /**
     * Getter for crppt
     * @return Good's name
     */
    @XmlElement
    public int getCR() {
        return crppt;
    }
    /**
     * Getter for erppt
     * @return Good's name
     */
    @XmlElement
    public int getER() {
        return erppt;
    }
    /**
     * Getter for crPresent
     * @return Good's name
     */
    @XmlElement
    public boolean getCRPresent() {
        return crPresent;
    }
    /**
     * Getter for erPresent
     * @return Good's name
     */
    @XmlElement
    public boolean getERPresent() {
        return erPresent;
    }
    /**
     * Setter for name
     * @param name name to be set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Setter for price
     * @param price price to be set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * Setter for quantity
     * @param quant quantity to be set
     */
    public void setQuantity(int quant) {
        this.quantity = quant;
        setQ(quantity);
    }
    /**
     * Setter for crppt
     * @param crppt crppt to be set
     */
    public void setCR(int crppt) {
        this.crppt = crppt;
    }
    /**
     * Setter for erPresent
     * @param a erPresent to be set
     */
    public void setER(int erppt) {
        this.erppt = erppt;
    }
    /**
     * Setter for crPresent
     * @param crpr crPresent to be set
     */
    public void setCRPresent(boolean crpr) {
        crPresent = crpr;
    }
    /**
     * Setter for erPresent
     * @param erpr erPresent to be set
     */
    public void setERPresent(boolean erpr) {
        erPresent = erpr;
    }
    
    /**
     * Increase quantity
     * @param increaseQ number to be increased
     */
    public void increaseQuantity(int increaseQ) {
        quantity += increaseQ;
        setQ(quantity);
    }
    
    /**
     * Decrease quantity
     * @param decreaseQ number to be decreased
     */
    public void decreaseQuantity(int decreaseQ) {
        quantity -= decreaseQ;
        setQ(quantity);
    }
    
    /**
     * getter the total price
     * @return the total price
     */
    public int total() {
        return quantity * price;
    }
    
    /**
     * Set price to final price on star with certain techLevel
     * @param techLevel the techLevel of the marketPlace
     */
    public void calFinalPrice(int techLevel) {
        final Random rand = new Random();
        final Boolean ifincrease = rand.nextBoolean();
        int vari = rand.nextInt(var + 1);
        if (ifincrease) {
            vari = -vari;
        }
        price = baseprice + ipl * (techLevel - mtlp) + vari;
        if (crPresent) {
            price = (price * 2) / 5;
        }
        if (erPresent) {
            price *= 2;
        }
    }
    
    /**
     * get IntegerProperty of price
     * @return IntegerProperty of price
     */
    public IntegerProperty getP() {
        return new SimpleIntegerProperty(price);
    }
    
    /**
     * get IntegerProperty of quantity
     * @return IntergerProperty of Quantity
     */
    public IntegerProperty getQ() {
        return aquantity;
    }
    
    /**
     * get StringProperty of name
     * @return StringProperty of name
     */
    public StringProperty getN() {
        return new SimpleStringProperty(name);
    }
    
    /**
     * set quantity
     * @param quantity to set
     */
    public void setQ(int quantity) {
        aquantity.set(quantity);
    }
    
    /**
     * Override equals method
     * @param o Object to compare with
     * @return if equal, true; else, false
     */
    public boolean equals(Object object) {
        if (null == object) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof Good)) {
            return false;
        }
        final Good aGood = (Good) object;
        return this.name.equals(aGood.name);
    }
    
    /**
     * override hashCode
     * @return hashCode
     */
    public int hashCode() {
        return 0;
    }
    
    /**
     * return a copy of Good
     * @return a copy of game
     * @change
     */
    public Good copy() {
        return null;
    }
}