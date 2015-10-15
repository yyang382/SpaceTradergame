package project.model;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * SolarSystem. Locates in the universe and owns some stars
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class SolarSystem {
    
    /**
     * coordinate of solar system
     */
    private int xloc;
    /**
     * coordinate of solar system
     */
    private int yloc;
    /**
     * name of solarsystem
     */
    private String name;
    /**
     * star list of solar system
     */
    private ArrayList<Star> starList;
    
    /**
     * SolarSystem's default constructor
     */
    public SolarSystem(){
        //Intentionally left empty
    }
    
    /**
     * SolarSystem's constructor
     * @param xloc xloc coordinate
     * @param yloc yloc coordinate
     */
    public SolarSystem(int xloc, int yloc, String name) {
        this.xloc = xloc;
        this.yloc = yloc;
        this.name = name;
        starList = new ArrayList<Star>();
    }
    
    /**
     * Getter for name
     * @return name
     */
    @XmlElementWrapper
    public ArrayList<Star> getStars() {
        return starList;
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
     * Setter for name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Setter for starList
     * @param name new starList
     */
    public void setStars(ArrayList<Star> data) {
        starList = data;
    }
    
    /**
     * Setter for xloc
     * @param name new xloc
     */
    public void setX(int data) {
        xloc = data;
    }
    
    /**
     * Setter for yloc
     * @param name new yloc
     */
    public void setY(int data) {
        yloc = data;
    }
    
    /**
     * Add stars
     * @param the star to add to solar system
     */
    public void addStar(Star star) {
        starList.add(star);
    }
    
    /**
     * Getter for Star
     * @return Star
     */
    public Star getStar(int index) {
        return starList.get(index);
    }
    
    /**
     * Getter for size
     * @return size
     */
    public int getSize() {
        return starList.size();
    }
    
    /**
     * get the index of a certain star in solar system
     * @param data
     * @return the index
     */
    public int indexOf(Star data) {
        return starList.indexOf(data);
    }
    
    /**
     * Getter for StringProperty of name
     * @return StringProperty of name
     */ 
    public StringProperty getN() {
        return new SimpleStringProperty(name);
    }
     
    /**
     * Override toString()
     * @return string representation of solar system
     */
    public String toString() {
        String data = "its name is " + getName() + ", and it has " + getSize();
        if (getSize() == 1) {
            data += " star\n";
        } else { 
            data += " stars\n";
        }
        return data;
    }
}