package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Firearms, Good's subclass
 * CS 2340 : Fall 2014
 * @author Xiaoxi Han
 * @version 1.0
 */
@XmlRootElement
public class Firearms extends Good {
    
    /**
     * Constructor for Good
     */ 
    public Firearms() {
        super("Firearms", 1250, 3, 1, 5, -75, 100, 12, -1);
    }
    
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Firearms();
    }
}