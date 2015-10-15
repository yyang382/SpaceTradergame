package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Ore, Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Ore extends Good {
    /**
     * Constructor of Ore
     */
    public Ore() {
        super("Ore", 350, 2, 2, 3, 20, 10, 1, 2);
    }
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Ore();
    }
}