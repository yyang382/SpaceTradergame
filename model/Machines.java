package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Machines, Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Machines extends Good {
    /**
     * Constructor for Machine
     */ 
    public Machines() {
        super("Machines", 900, 4, 3, 5, -10, 5, -1, -1);
    }
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Machines();
    }
}