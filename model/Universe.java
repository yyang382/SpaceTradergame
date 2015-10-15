package project.model;

import java.util.ArrayList;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Universe. Everything locates in it
 * CS 2340 : Fall 2014
 * @author Jiateng Xie
 * @version 1.0
 */
@XmlRootElement
public class Universe {
    
    /**
     * attributes of universe
     */
    private final int height;
    /**
     * attributes of universe
     */
    private final int width;
    /**
     * attributes of universe
     */
    private ArrayList<SolarSystem> solarL;
    /**
     * attributes of universe
     */
    private final ArrayList<String> solar;
    /**
     * attributes of universe
     */
    private final ArrayList<String> star;
    /**
     * attributes of universe
     */
    public static ObservableList<Good> goodList = FXCollections.observableArrayList();
    /**
     * random generator
     */
    public static final Random RAND = new Random();
    /**
     * Techlevel enum
     * @author Jiateng Xie
     *
     */
    public enum TechLevels {PRE_AGRICULTURE, AGRICULTURE, MEDIEVAL, RENAISSANCE,
                            EARLY_INDUSTRIAL, INDUSTRIAL, POST_INDUSTRIAL, HI_TECH}
    /**
     * Solar sys enum
     * @author Jiateng Xie
     *
     */
    public enum SolarNames {ACAMAR, BALOSNEE, CALONDIA, DENEB, IRALIUS, JANUS, POKER, NIX, WJW}
    /**
     * star names enum
     * @author Jiateng Xie
     *
     */
    public enum StarNames {ADAHN, ALDEA, ANDEVIAN, ANTEDI, BARATAS, BRAX, BRETEL, CAMPOR,
        CAPELLE, CARZON, CASTOR, CESTUS, CHERON, COURNENEY, DALED, DAMAST, DAVLOS, DENEVA,
        DEVIDIA, DRAYLON,DREMA, ENDOR, ESMEE, EXO, FERRIS, FESTEN, FOURMI, FROLIX, GEMULON,
        GUINIFER, HADES, HAMLET, HELENA, HULST, IODINE, JAPORI, JARADA, JASON, KAYLON, KHEFKA,
        IRA, KLAATU, KORMA, KRAVAT, KRIOS, LAERTES, LARGO, LIGON, MINTAKA, MAGRAT, MALCORIA,
        MELINA, NELVANA, ODET, OG, OTHELLO, PARADE, QUATOR, STYRIS, TITAN, TORIN, TRIACUS,
        TYRUS, UMBERLEE, UTOPIA, VAGRA, XENON, XERXES, YEW, YOJIMBO, ZALKON, ZUUL}
    
    /**
     * constructor for universe
     */
    public Universe() {
        height = 220;
        width = 220;
        solarL = new ArrayList<SolarSystem>();
        solar = new ArrayList<String>();
        star = new ArrayList<String>();
        for (int i = 0; i < SolarNames.values().length; i++) {
            solar.add(SolarNames.values()[i].name());
        }
        for (int j = 0; j < StarNames.values().length; j++) {
            star.add(StarNames.values()[j].name());
        }
        goodList.clear();
        goodList.add(new Water());
        goodList.add(new Furs());
        goodList.add(new Food());
        goodList.add(new Ore());
        goodList.add(new Games());
        goodList.add(new Firearms());
        goodList.add(new Medicine());
        goodList.add(new Machines());
        goodList.add(new Narcotics());
        goodList.add(new Robots());
        generateSolarSystem();
    }
    
    /**
     * Add solar systems
     * @param s solar system to be added
     */
    public void addSolarSystem(SolarSystem solarSys) {
        solarL.add(solarSys);
    }
    
    /**
     * getter for size
     * @return the universe
     */
    public int getSize() {
        return solarL.size();
    }
    
    /**
     * getter for size
     * @return the height
     */
    @XmlElement
    public int getHeight() {
        return height;
    }
    
    /**
     * getter for width
     * @return the width
     */
    @XmlElement
    public int getWidth() {
        return width;
    }
    
    /**
     * getter for solarL
     * @return the solarL
     */
    @XmlElementWrapper
    public ArrayList<SolarSystem> getSolarSystems() {
        return solarL;
    }
    
    /**
     * getter for SolarSystem
     * @return the SolarSystem
     */
    public SolarSystem getSolarSystem(int index) {
        return solarL.get(index);
    }
    
    /**
     * Getter for the index of certain solar system
     * @param data the solar system
     * @return index
     */
    public int indexOf(SolarSystem data) {
        return solarL.indexOf(data);
    }
    
    /**
     * setter for the solar system
     * @param data solar system
     */
    public void setSolarSystem(ArrayList<SolarSystem> data) {
        solarL = data;
    }
    
    /**
     * generate n solarSystems
     * @param n the number of solarSystems to generate
     */
    private void generateSolarSystem() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solarL.add(new SolarSystem(40 + 70 * j, 40 + 70 * i, solar.remove(0)));
                solarL.get(i * 3 + j).addStar(new Star(RAND.nextInt(25) + 10 + 70 * j,
                                                  RAND.nextInt(25) + 10 + 70 * i,
                                                  star.remove(RAND.nextInt(star.size()))));
                int data = RAND.nextInt(25) + 10 + 70 * j;
                int dataB = RAND.nextInt(25) + 10 + 70 * i;
                Star astar = solarL.get(i * 3 + j).getStar(0);
                while ((data - astar.getX()) * (data - astar.getX())
                      + (dataB - astar.getY()) * (dataB - astar.getY()) < 100) {
                    data = RAND.nextInt(25) + 10 + 70 * j;
                    dataB = RAND.nextInt(25) + 10 + 70 * i;
                }
                solarL.get(i * 3 + j).addStar(new Star(data, dataB,
                                                  star.remove(RAND.nextInt(star.size()))));
                solarL.get(i * 3 + j).addStar(new Star(RAND.nextInt(25) + 45 + 70 * j,
                                                  RAND.nextInt(25) + 10 + 70 * i,
                                                  star.remove(RAND.nextInt(star.size()))));
                data = RAND.nextInt(25) + 45 + 70 * j;
                dataB = RAND.nextInt(25) + 10 + 70 * i;
                astar = solarL.get(i * 3 + j).getStar(2);
                while ((data - astar.getX()) * (data - astar.getX())
                      + (dataB - astar.getY()) * (dataB - astar.getY()) < 100) {
                    data = RAND.nextInt(25) + 45 + 70 * j;
                    dataB = RAND.nextInt(25) + 10 + 70 * i;
                }
                solarL.get(i * 3 + j).addStar(new Star(data, dataB,
                                                  star.remove(RAND.nextInt(star.size()))));
                solarL.get(i * 3 + j).addStar(new Star(RAND.nextInt(25) + 10 + 70 * j,
                                                  RAND.nextInt(25) + 45 + 70 * i,
                                                  star.remove(RAND.nextInt(star.size()))));
                data = RAND.nextInt(25) + 10 + 70 * j;
                dataB = RAND.nextInt(25) + 45 + 70 * i;
                astar = solarL.get(i * 3 + j).getStar(4);
                while ((data - astar.getX()) * (data - astar.getX())
                      + (dataB - astar.getY()) * (dataB - astar.getY()) < 100) {
                    data = RAND.nextInt(25) + 10 + 70 * j;
                    dataB = RAND.nextInt(25) + 45 + 70 * i;
                }
                solarL.get(i * 3 + j).addStar(new Star(data, dataB,
                                                  star.remove(RAND.nextInt(star.size()))));
                solarL.get(i * 3 + j).addStar(new Star(RAND.nextInt(25) + 45 + 70 * j,
                                                  RAND.nextInt(25) + 45 + 70 * i,
                                                  star.remove(RAND.nextInt(star.size()))));
                data = RAND.nextInt(25) + 45 + 70 * j;
                dataB = RAND.nextInt(25) + 45 + 70 * i;
                astar = solarL.get(i * 3 + j).getStar(6);
                while ((data - astar.getX())
                        * (data - astar.getX())
                        + (dataB - astar.getY())
                        * (dataB - astar.getY()) < 100) {
                    data = RAND.nextInt(25) + 45 + 70 * j;
                    dataB = RAND.nextInt(25) + 45 + 70 * i;
                }
                solarL.get(i * 3 + j).addStar(new Star(data, dataB,
                                                  star.remove(RAND.nextInt(star.size()))));
            }
        }
    }
    
    /**
     * Override toString()
     * @return the String representation of universe
     */
    public String toString() {
        String data = "It has " + getSize() + " solar systems: \n";
        for (int i = 0; i < getSize(); i++) {
            data += "Solar system " + (i + 1) + ": " + solarL.get(i).toString();
        }
        return data;
    }
}