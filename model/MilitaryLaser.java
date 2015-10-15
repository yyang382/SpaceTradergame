package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * MilitaryLaser, Weapon's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class MilitaryLaser extends Weapon{
    /**
     * Constructor for Milistarylaser
     */ 
    public MilitaryLaser() {
        super("Military Laser", 27500, 35);
    }
}
