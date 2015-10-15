package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * BeamLaser, weapon's sub class
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class BeamLaser extends Weapon{
    /**
     * Constructor for Weapon
     */ 
    public BeamLaser() {
        super("Beam Laser", 11250, 15);
    }
}
