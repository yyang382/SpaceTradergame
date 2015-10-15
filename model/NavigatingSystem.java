package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * a class of navigating system
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class NavigatingSystem extends Gadget{
    
    /**
     * Constructor for NavigatingSystem
     */ 
    public NavigatingSystem() {
        super("Navigating System", 1500);
    }
}
