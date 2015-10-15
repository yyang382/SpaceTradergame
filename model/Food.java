package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Food, Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Food extends Good {
    /**
     * Constructor for Food
     */ 
    public Food() {
        super("Food", 100, 1, 0, 1, 5, 5, 5, 6);
    }
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Food();
    }
}