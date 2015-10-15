package project.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * System to repair ship automatically
 * @author Jiateng Xie
 */ 
@XmlRootElement
public class AutorepairSystem extends Gadget{
    /**
     * Constructor for Weapon
     */ 
    public AutorepairSystem() {
        super("Auto-repair System", 1500);
    }
}
