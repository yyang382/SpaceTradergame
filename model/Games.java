package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Games, Good's subclass
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Games extends Good {
    /**
     * Constructor for Games
     */ 
    public Games() {
        super("Games", 250, 3, 1, 6, 10, 5, 11, -1);
    }
    /**
     * return a copy of Games
     * @return a copy of Games
     */ 
    public Good copy() {
        return new Games();
    }
}