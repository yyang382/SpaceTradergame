package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * CloakingDevice, Gadget's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class CloakingDevice extends Gadget{
    /**
     * Constructor for Gadget
     */ 
    public CloakingDevice() {
        super("Cloaking Device", 3500);
    }
}
