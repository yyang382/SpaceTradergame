package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Star. Locates in the solar system
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Star {
    /**
     * attributes of Star
     */
    private int xloc;
    /**
     * attributes of Star
     */
    private int yloc;
    /**
     * attributes of Star
     */
    private int techLevel;
    /**
     * attributes of Star
     */
    private int resource;
    /**
     * attributes of Star
     */
    private int pirateLevel;
    /**
     * attributes of Star
     */
    private int policeLevel;
    /**
     * attributes of Star
     */
    private String name;
    /**
     * attributes of Star
     */
    private String techLevelName;
    /**
     * attributes of Star
     */
    private String resourceName;
    /**
     * attributes of Star
     */
    private String color;
    /**
     * attributes of Star
     */
    private ObservableList<Good> goods = FXCollections.observableArrayList();
    /**
     * enum for techlevels
     */
    public enum TechLevels {PRE_AGRICULTURE, AGRICULTURE, MEDIEVAL, RENAISSANCE, EARLY_INDUSTRIAL,
        INDUSTRIAL, POST_INDUSTRIAL, HI_TECH}
    /**
     * enum for resources
     */
    public enum Resources {NONSPECIALRESOURCES, MINERALRICH, MINERALPOOR, DESERT, LOTSOFWATER,
        RICHSOIL, POORSOIL, RICHFAUNA, LIFELESS, WEIRDMUSHRROOMS, LOTSOFHERBS, ARTISTIC, WARLIKE}
    
    /**
     * no-arg constructor
     */
    public Star(){
        //intentionally left blank
    }
    
    /**
     * Star's constructor
     * @param xloc xloc coordinate
     * @param yloc yloc coordinate
     * @param name the name of the star
     */
    public Star(int xloc, int yloc, String name) {
        this.xloc = xloc;
        this.yloc = yloc;
        this.name = name;
        policeLevel = Universe.RAND.nextInt(3) + 3;
        pirateLevel = Universe.RAND.nextInt(6) + 2;
        if (pirateLevel >= 5) {
            color = Color.CADETBLUE.toString();
        } else if (pirateLevel == 2) {
            color = Color.RED.toString();
        } else {
            color = Color.VIOLET.toString();
        }
        techLevel = Universe.RAND.nextInt(8);
        techLevelName = TechLevels.values()[techLevel].name();
        resource = Universe.RAND.nextInt(7) > 1 ? 0 : Universe.RAND.nextInt(12) + 1;
        resourceName = Resources.values()[resource].name();
        for (Good b : Universe.goodList) {
            goods.add(b.copy());
        }
        for (Good data : goods) {
            if (data.getCR() == resource) {
                data.setCRPresent(true);
            }
            if (data.getER() == resource) {
                data.setERPresent(true);
            }
        }
    }
    /**
     * Getter for xloc
     * @return xloc
     */
    @XmlElement
    public int getX() {
        return xloc;
    }
    /**
     * Getter for yloc
     * @return yloc
     */
    @XmlElement
    public int getY() {
        return yloc;
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
     * Getter for techLevel
     * @return techLevel
     */
    @XmlElement
    public int getTechLevel() {
        return techLevel;
    }
    /**
     * Getter for techLevelName
     * @return techLevelName
     */
    @XmlElement
    public String getTechLevelName() {
        return techLevelName;
    }
    /**
     * Getter for resource
     * @return resource
     */
    @XmlElement
    public int getResource() {
        return resource;
    }
    /**
     * Getter for pirateLevel
     * @return pirateLevel
     */
    @XmlElement
    public int getPirateLevel() {
        return pirateLevel;
    }
    /**
     * Getter for policeLevel
     * @return policeLevel
     */
    @XmlElement
    public int getPoliceLevel() {
        return policeLevel;
    }
    /**
     * Getter for resourceName
     * @return resourceName
     */
    @XmlElement
    public String getResourceName() {
        return resourceName;
    }
    /**
     * Getter for goods
     * @return goods
     */
    @XmlElementWrapper
    @XmlAnyElement(lax = true)
    public ObservableList<Good> getGoodList() {
        return goods;
    }
    /**
     * Getter for color
     * @return color
     */
    @XmlElement
    public String getColor() {
        return color;
    }
    
    public Color getPaint() {
        return Color.valueOf(color);
    }
    /**
     * Setter for xloc
     * @param xloc new xloc
     */
    public void setX(int data) {
        xloc = data;
    }
    /**
     * Setter for yloc
     * @param xloc new yloc
     */
    public void setY(int data) {
        yloc = data;
    }
    /**
     * Setter for name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Setter for techLevelName
     * @param techLevelName new techLevelName
     */
    public void setTechLevelName(String techLevelName) {
        this.techLevelName = techLevelName;
    }
    /**
     * Setter for techLevel
     * @param techLevel new techLevel
     */
    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }
    /**
     * Setter for resourceName
     * @param resourceName new resourceName
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    /**
     * Setter for resource
     * @param resource new resource
     */
    public void setResource(int resource) {
        this.resource = resource;
    }
    /**
     * Setter for pirateLevel
     * @param pirateLevel new pirateLevel
     */
    public void setPirateLevel(int pirateLevel) {
        this.pirateLevel = pirateLevel;
    }
    /**
     * Setter for policeLevel
     * @param policeLevel new policeLevel
     */
    public void setPoliceLevel(int policeLevel) {
        this.policeLevel = policeLevel;
    }
    /**
     * Setter for goods
     * @param data new goods
     */
    public void setGoodList(ObservableList<Good> data) {
        goods = data;
    }
    /**
     * Setter for color
     * @param color new color
     */
    public void setColor(String color) {
        this.color = color;
    }
    /**
     * Getter for StringProperty of name
     * @return StringProperty of name
     */
    public StringProperty getN() {
        return new SimpleStringProperty(name);
    }
    /**
     * calculate the price of goods
     */
    public void calPrice() {
        for (Good data : goods) {
            data.calFinalPrice(techLevel);
        }
    }
    /**
     * Getter for SellableList
     * @return SellableList
     */
    public ObservableList<Good> getSellableList() {
        ObservableList<Good> temp = FXCollections.observableArrayList();
        for (Good data : goods) {
            if (data.getMTLP() <= techLevel) {
                temp.add(data);
            }
        }
        return temp;
    }
    /**
     * judge if the star is hit by mouse
     * @param xloc the xloc value of star
     * @param yloc the yloc value of star
     * @param size size of star
     * @return true if the star is hit, false if not
     */
    public boolean isHit(int xloc, int yloc, int size) {
        if (xloc > (this.xloc - size)
        		&& xloc < (this.xloc + size)
        		&& yloc > (this.yloc - size)
        		&& yloc < (this.yloc + size)) {
            return true;
        }
        return false;
    }
}