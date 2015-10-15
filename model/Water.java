package project.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Water. Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Water extends Good {
    
    /**
     * Water's constructor
     */
    public Water() {
        super("Water", 30, 0, 0, 2, 3, 4, 4, 3);
    }
    
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Water();
    }
}