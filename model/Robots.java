package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Robots. Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Robots extends Good {
    
    /**
     * Robots' constructor
     */
    public Robots() {
        super("Robots", 5000, 6, 4, 7, -150, 100, -1, -1);
    }
    
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Robots();
    }
}