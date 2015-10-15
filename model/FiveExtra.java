package project.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 * FiveExtra, Gadget's subclass
 * CS 2340 : Fall 2014
 * @author Xiaoxi Han
 * @version 1.0
 */
public class FiveExtra extends Gadget{
    /**
     * Constructor for FiveExtra
     */ 
    public FiveExtra() {
        super("5 extra cargoes", 500);
    }
}
