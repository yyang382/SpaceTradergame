package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Medicine, Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Medicine extends Good {
    /**
     * Constructor for Medicine
     */ 
    public Medicine() {
        super("Medicine", 650, 4, 1, 6, -20, 10, 10, -1);
    }
    /**
     * return a copy of this good
     */
    public Good copy() {
        return new Medicine();
    }
}