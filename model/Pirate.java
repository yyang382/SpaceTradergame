package project.model;

import org.controlsfx.dialog.Dialogs;
/**
 * Pirate class that represent a pirate
 * @author Wenduo Yang
 *
 */
public class Pirate {
	
	/**
	 * data of a Pirate
	 */
	private String name;
	/**
	 * data to be used inside class
	 */
	public final String moneyString = " money!";
	/**
	 * data of a Pirate
	 */
	private int damage;
	/**
	 * data of a Pirate
	 */
	private int reward;
	/**
	 * data of a Pirate
	 */
	private final int level;
	
	/**
	 * Constructor of a Pirate
	 */
	public Pirate() {
		level = Universe.RAND.nextInt(6);
		if (level <= 1) {
			damage = Universe.RAND.nextInt(16) + 5;
			reward = damage * 200;
			name = "OK";
		}
		if (level > 1 && level <= 3) {
			damage = Universe.RAND.nextInt(16) + 20;
			reward = damage * 300;
			name = "fairly strong";
		}
		if (level == 4) {
			damage = Universe.RAND.nextInt(15) + 35;
			reward = damage * 400;
			name = "very strong";
		}
		if (level == 5) {
			damage = Universe.RAND.nextInt(16) + 60;
			reward = damage * 500;
			name = "one of the pirate kings";
		}
	}
	
	/**
	 * Setter of damage
	 * @param damage data to be set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * Setter of reward
	 * @param damage data to be set
	 */
	public void setReward(int reward) {
		this.reward = reward;
	}
	
	/**
	 * Getter of damage
	 * @return the damage of this pirate
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * Getter of reward
	 * @return the reward of this pirate
	 */
	public int getReward() {
		return reward;
	}
	
	/**
	 * The method to handle fight between player and pirate
	 * @param player the player
	 * @param ship the ship
	 */
	public void fight(Player player, Ship ship) {
		String answer = "";
		int shipDamage = ship.getDamage();
		int shipShield = ship.getShield();
		if (shipDamage + (player.getCombat() / 3) > damage) {
			answer = "Good! You beat them and take all their money, " + reward + ".";
			if (shipShield < damage) {
				ship.setHullDamaged(ship.getHullDamaged() + damage - shipShield);
				if (ship.getHullDamaged() >= ship.getHullStrength()) {
					ship.setHullDamaged(ship.getHullStrength());
				}
				answer += " Still, they managed to "
						+ "damage some of your hull. Your remaining hull "
						+ "strength is " + (
								ship.getHullStrength()
								- ship.getHullDamaged()) + ".";
			}
			ship.setMoney(ship.getMoney() + reward);
			Dialogs.create()
						.title("Yay!")
						.message(answer)
						.showInformation();
		} else {
			if ((damage - shipDamage) <= shipShield) {
				answer = "You are not strong enough to beat "
						+ "them, but they can't hurt you either!";
				if (shipShield < damage) {
					ship.setHullDamaged(ship.getHullDamaged()
							+ damage - shipShield);
					if (ship.getHullDamaged() >= ship.getHullStrength()) {
						ship.setHullDamaged(ship.getHullStrength());
					}
					answer += " However, they still damaged some "
							+ "of your hull. Your remaining hull"
							  + " strength is " + 
							(ship.getHullStrength()
									- ship.getHullDamaged())
							  + ".";
				}
				Dialogs.create()
						.title("OK!")
						.message(answer)
						.showInformation();
			} else {
				answer = "You are kind of weak compared to them. You are beat!";
				ship.setHullDamaged(ship.getHullDamaged() + damage - shipShield);
				if (ship.getHullDamaged() >= ship.getHullStrength()) {
					ship.setHullDamaged(ship.getHullStrength());
				}
				answer += " They damaged some of your hull. Your remaining hull "
						  + "strength is " + (
								  ship.getHullStrength()
								  - ship.getHullDamaged())
						  + ". They cleared your cargo";
				ship.getCargoList().clear();
				ship.setCargoSpaceLabel("" + (ship.getCargoSpace() - ship.size()) + "/"
										+ ship.getCargoSpace());
				int moneyrobbed = robmoney(ship);
				answer += " and they robbed you " + moneyrobbed + moneyString;
				Dialogs.create()
						.title("Nah!")
						.message(answer)
						.showInformation();
			}
		}
	}
	
	/**
	 * The method to handle negotiation of player and pirate
	 * @param player the player
	 * @param ship player's ship
	 */
	public void negotiate(Player player, Ship ship) {
		int moneyrobbed = 0;
		if (player.getNegotiate() == 0) {
			ship.getCargoList().clear();
			ship.setCargoSpaceLabel("" + (ship.getCargoSpace() - ship.size()) + "/"
									+ ship.getCargoSpace());
			moneyrobbed = robmoney(ship);
			Dialogs.create()
					.title("Nah!")
					.message("You don't look like much of "
							+ "a negotiater! You basically surrendered!"
							+ "They take all your "
							+ "cargoes and "
							+ moneyrobbed + moneyString)
					.showInformation();
		} else {
			moneyrobbed = (damage / player.getNegotiate()) * 50;
			ship.getCargoList().clear();
			ship.setCargoSpaceLabel("" + (ship.getCargoSpace() - ship.size()) + "/"
									+ ship.getCargoSpace());
			if (moneyrobbed >= ship.getMoney()) {
				moneyrobbed = ship.getMoney();
				ship.setMoney(0);
			} else {
				ship.setMoney(ship.getMoney() - moneyrobbed);
			}
			Dialogs.create()
					.title("Oh!")
					.message("You successfully negotiated the price "
							+ "down to all your cargoes"
							+ "plus " + moneyrobbed + moneyString)
					.showInformation();
		}
	}
	
	/**
	 * The method to handle surrender by player
	 * @param ship player's ship
	 */
	public void surrender(Ship ship) {
		ship.getCargoList().clear();
		ship.setCargoSpaceLabel("" + (ship.getCargoSpace() - ship.size()) + "/"
								+ ship.getCargoSpace());
		int moneyrobbed = robmoney(ship);
		Dialogs.create()
				.title("Nah!")
				.message("They robbed all your cargoes plus "
				+ moneyrobbed + moneyString
						 + " (Tip: you should never surrender!)")
				.showInformation();
	}
	
	/**
	 * The method to handle player fleeing
	 * @param player the player
	 * @param ship player's ship
	 */
	public void flee(Player player, Ship ship) {
		if (player.getEscape() * 2 < damage) {
			int moneyrobbed = robmoney(ship);
			ship.getCargoList().clear();
			ship.setCargoSpaceLabel("" + (ship.getCargoSpace() - ship.size()) + "/"
									+ ship.getCargoSpace());
			Dialogs.create()
					.title("Nah!")
					.message("You failed to escape and they "
							+ "caught you! You paid the price"
							+ " of all your cargoes plus "
							+ moneyrobbed + moneyString)
					.showInformation();
		} else {
		Dialogs.create()
				.title("Yeah!")
				.message("You escaped without a trace! Awesome!")
				.showInformation();
		}
	}
	
	/**
	 * The class to handle pirate robbing player
	 * after winning fight
	 * @param ship player's ship
	 * @return the money robbed
	 */
	public int robmoney(Ship ship) {
		int moneyrobbed = 0;
		if (level == 5) {
			moneyrobbed = 3000;
		}
		if (level == 4) {
			moneyrobbed = 2000;
		}
		if (level > 1 && level <= 3) {
			moneyrobbed = 1500;
		}
		if (level <= 1) {
			moneyrobbed = 1000;
		}
		if (moneyrobbed >= ship.getMoney()) {
			moneyrobbed = ship.getMoney();
			ship.setMoney(0);
		} else {
			ship.setMoney(ship.getMoney() - moneyrobbed);
		}
		return moneyrobbed;
	}
	
	/**
	 * Override Object's toString method
	 */
	public String toString() {
		return "They appear to be " + name + ".";
	}
}