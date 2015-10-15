package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Narcotics, Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Narcotics extends Good {
    /**
     * Constructor for Narcotics
     */ 
    public Narcotics() {
        super("Narcotics", 3500, 5, 0, 5, -125, 150, 9, -1);
    }
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Narcotics();
    }
}