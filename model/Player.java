package project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Player. Stores all player's data CS 2340 : Fall 2014
 * 
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Player {

    /**
     * name instance
     */
    private String name;

    /**
     * basic instance of a player
     */
    private int combat;
    /**
     * basic instance of a player
     */
    private int negotiate;
    /**
     * basic instance of a player
     */
    private int escape;

    /**
     * Alternate constructor
     */
    public Player() {
        // Intentionally left empty
    }

    /**
     * Player's constructor
     * 
     * @param name player's name
     * @param combat player's combat skill point
     * @param negotiate player's negotiate skill point
     * @param escape player's escape skill point
     */
    public Player(String name, int combat, int negotiate, int escape) {
        this.name = name;
        this.combat = combat;
        this.negotiate = negotiate;
        this.escape = escape;
    }

    /**
     * Getter for name
     * 
     * @return name player's name
     */
    @XmlElement
    public String getName() {
        return name;
    }

    /**
     * Getter for combat
     * 
     * @return name player's combat point
     */
    @XmlElement
    public int getCombat() {
        return combat;
    }

    /**
     * Getter for negotiate
     * 
     * @return name player's negotiate point
     */
    @XmlElement
    public int getNegotiate() {
        return negotiate;
    }

    /**
     * Getter for escape
     * 
     * @return name player's escape point
     */
    @XmlElement
    public int getEscape() {
        return escape;
    }

    /**
     * Setter for name
     * 
     * @param name
     *            player's new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for combat
     * 
     * @param combat
     *            player's new combat point
     */
    public void setCombat(int combat) {
        this.combat = combat;
    }

    /**
     * Setter for negotiate
     * 
     * @param negotiate
     *            player's new negotiate point
     */
    public void setNegotiate(int negotiate) {
        this.negotiate = negotiate;
    }

    /**
     * Setter for escape
     * 
     * @param escape
     *            player's new escape point
     */
    public void setEscape(int escape) {
        this.escape = escape;
    }

    /**
     * Override toString method
     * 
     * @return a string
     */
    public String toString() {
        final String temp = "Your user name: " + getName()
                + "\nYour combat points: " + getCombat()
                + "\nYour negotiate points: " + getNegotiate() + "\nYour escape points: "
                + getEscape();
        return temp;
    }
}
