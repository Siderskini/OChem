/**
 * @author Derek
 * 
 * A Functional Group is a set of bonded atoms that have special
 * chemical properties
 */
public class FunctionalGroup implements Bondable {
	
	// All functional groups have a name
	private String name;
	
	// all functional groups have a center atom
	private Atom center;
	
	// List of bonds in the functional group
	private Bond[] bonds;
	
	/**
	 * Functional Group constructor
	 * 
	 * @param name The name of the functional group
	 * @param center the center atom of the functional group
	 * @param peripherals all bonds connected to the center atom
	 */
	public FunctionalGroup(String name, Atom center, Bond... peripherals) {
		this.name = name;
		this.center = center;
		bonds = peripherals;
	}
	
	/**
	 * getName
	 * 
	 * @return the name of the functional group
	 */
	public String getName() {
		return name;
	}

	public void add(Bond bond) {
		
	}

}
