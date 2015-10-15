package project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * GameWrapper, used to save game data. Used when save game and reload game.
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class GameWrapper {
  
	/**
     * basic field of GameWrapper
     */
    private Player user;
    /**
     * basic field of GameWrapper
     */
    private Ship ship;
    /**
     * basic field of GameWrapper
     */
    private Universe univ;
    /**
     * basic field of GameWrapper
     */
    private SolarSystem currSol;
    /**
     * basic field of GameWrapper
     */
    private Star currStar;
    
    /**
     * Constructor for GameWrapper
     * @param user assigning this field
     * @param ship assigning this field
     * @param univ assigning this field
     * @param currSol assigning this field
     * @param currStar assigning this field
     */
    public GameWrapper(Player user, Ship ship, Universe univ, SolarSystem currSol, Star currStar) {
        this.user = user;
        this.ship = ship;
        this.univ = univ;
        this.currSol = currSol;
        this.currStar = currStar;
    }
    
    /**
     * default constructor
     */
    public GameWrapper() {
    	//intentionally left blank
    }
    
    /**
     * Getter for Player
     * @return user saved user;
     */
    @XmlElement
    public Player getPlayer() {
        return user;
    }
    
    /**
     * Getter for Ship
     * @return ship saved ship;
     */
    @XmlElement
    public Ship getShip() {
        return ship;
    }
    
    /**
     * Getter for Universe
     * @return univ saved universe;
     */
    @XmlElement
    public Universe getUniv() {
        return univ;
    }
    
    /**
     * Getter for SolarSystem
     * @return currSol saved current solar system;
     */
    @XmlElement
    public SolarSystem getSolarSystem() {
        return currSol;
    }
    
    /**
     * Getter for Star
     * @return currStar saved current star;
     */
    @XmlElement
    public Star getStar() {
        return currStar;
    }
    
    /**
     * Setter for player
     * @param player the player to set to
     */
    public void setPlayer(Player player) {
        user = player;
    }
    
    /**
     * Setter for ship
     * @param ship the ship to set to
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    /**
     * Setter for universe
     * @param univ the universe to set to
     */
    public void setUniv(Universe univ) {
        this.univ = univ;
    }
    
    /**
     * Setter for solar system
     * @param currSol the SolarSystem to set to
     */
    public void setSolarSystem(SolarSystem currSol) {
        this.currSol = currSol;
    }
    
    /**
     * Setter for Star
     * @param star the Star to set to
     */
    public void setStar(Star star) {
        currStar = star;
    }
}
