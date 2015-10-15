package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Furs, Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Furs extends Good {
    /**
     * Constructor for Furs
     */ 
    public Furs() {
        super("Furs", 250, 0, 0, 0, 10, 10, 7, 8);
    }
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Furs();
    }
}