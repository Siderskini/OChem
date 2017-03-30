package chemistry;
import java.util.Arrays;

import utility.Bondable;

/**
 * @author Derek
 * 
 * A Functional Group is a set of bonded atoms that have special
 * chemical properties
 */
public class FunctionalGroup implements Bondable {
	
	// All functional groups have a name
	private final String name;
	
	// all functional groups have a center atom
	private final Atom center;
	
	/**
	 * Functional Group constructor
	 * 
	 * @param name The name of the functional group
	 * @param center the center atom of the functional group
	 * @param peripherals all bonds connected to the center atom
	 */
	public FunctionalGroup(String name, Atom center, Bond... peripherals) {
		
		// assign instance data
		this.name = name;
		this.center = center;
		
		// add each bond to the center atom
		Arrays.asList(peripherals).stream().forEach(e -> center.add(e));
	}
	
	/**
	 * getName
	 * 
	 * @return the name of the functional group
	 */
	public String getName() {
		return name;
	}

	/**
	 * add()
	 * 
	 * Adds a bond to the central atom
	 * 
	 * @return true if operation was successful
	 */
	public boolean add(Bond bond) {
		return center.add(bond);
	}

	/**
	 * remove()
	 * 
	 * Removes a bond from the central atom
	 */
	public boolean remove(Bond bond) {
		return center.remove(bond);
	}

}
