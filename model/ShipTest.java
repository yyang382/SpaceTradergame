package project.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ShipTest {

	@Test
	public void test() {
		Gnat g = new Gnat();
	    Ship myS = new Ship(g);
		Food food1 = new Food();
		Furs fur1 = new Furs();
		Games game1 = new Games();
		ArrayList<Good> list = new ArrayList<>();
		
		food1.setPrice(10);
		myS.setMoney(30);
		fur1.setPrice(10);
		game1.setPrice(10);
		
		System.out.println(food1.getPrice());
		list.add(food1);
		list.add(fur1);
		list.add(game1);
		
		myS.buy(food1);
		myS.buy(fur1);
		myS.buy(game1);
		
		assertEquals(0,myS.getMoney());
		myS.buy(game1); //check same good
		
		assertEquals(myS.getCargoList().size(),list.size());
		assertEquals(myS.getCargoList(),list);
		assertEquals(g.getCargoSpace()-list.size(),myS.getCargoSpace()-myS.getCargoList().size());
		//Firearms fir = new Firearms();
		//Furs fur2 = new Furs();
		//myS.buy(fur2);
		Ore or = new Ore();
		or.setPrice(10);
		assertFalse(myS.buy(or));
	}
	
	@Test
	public void setUp(){
		// this runs every time before other method executes
		// logics
	}
	
}
