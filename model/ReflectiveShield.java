package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * ReflectiveShield, Shield's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class ReflectiveShield extends Shield{
    
    /**
     * ReflectiveShield's constructor
     */
    public ReflectiveShield() {
        super("Reflective Shield", 15000, 26);
    }
}