package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * EnergyShield, Shield's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class EnergyShield extends Shield{
    /**
     * Constructor for EnergyShield
     */ 
    public EnergyShield() {
        super("Energy Shield", 6000, 13);
    }
}
