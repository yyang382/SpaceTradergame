package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * PulseLaser, weapon's sub class
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class PulseLaser extends Weapon{
    
    /**
     * Constructor for PulseLaser
     */ 
    public PulseLaser() {
        super("Pulser Laser", 3500, 8);
    }
}
