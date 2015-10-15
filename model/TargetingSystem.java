package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * The targeting system to travel to
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class TargetingSystem extends Gadget{
    /**
     * The constructor for targeting system
     */
    public TargetingSystem() {
        super("Targeting System", 1500);
    }
}
