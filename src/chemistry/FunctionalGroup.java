package chemistry;

import java.util.Arrays;

import utility.Bondable;
import utility.Dictionary;
import chemistry.Bond.BOND_TYPE;
import chemistry.functionalgroup.Alcohol;
import chemistry.functionalgroup.Carbonyl;

/**
 * @author Derek
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
	 * Adds a bond to the central atom
	 * 
	 * @return true if operation was successful
	 */
	public boolean add(Bond bond) {
		return center.add(bond);
	}

	/**
	 * remove()
	 * Removes a bond from the central atom
	 */
	public boolean remove(Bond bond) {
		return center.remove(bond);
	}

	/**
	 * contains()
	 * 
	 * @param name the atom/group name
	 * @param type the bond type
	 * @return true if the group contains the specified bond
	 */
	public boolean contains(String name, BOND_TYPE type) {
		return center.contains(name, type);
	}

	/**
	 * getBond()
	 * 
	 * @param name the atom/group name
	 * @param type the bond type
	 * @return the bond attached to the atom
	 */
	public Bond getBond(String name, BOND_TYPE type) {
		return center.getBond(name, type);
	}

	/**
	 * hasLonePair()
	 * 
	 * @return true if the atom has a lone pair
	 * of electrons
	 */
	public boolean hasLonePair() {
		return center.loners() > 0;
	}

	/**
	 * parseBonds()
	 * Checks if any atom is actually part of a functional group
	 * 
	 * @param atoms the list of atoms to parse
	 * @return a new Bondable array which is a mixture
	 * of atoms or functional groups
	 */
	public Bondable[] parseBonds(Atom[] atoms) {

		// initialize an array of bondables
		Bondable[] bondables = new Bondable[atoms.length];

		// parse each atom
		for (int i = 0; i < atoms.length; i++) {

			// filter based on atom name
			switch (atoms[i].getName()) {

			// could be alcohol, ester, or ether
			case Dictionary.OXYGEN:

				// only alcohol is implemented right now
				bondables[i] = new Alcohol(null);
				break;

			// could be amine or amide
			case Dictionary.NITROGEN:
				break;

			// many possibilities
			case Dictionary.CARBON:
				bondables[i] = new Carbonyl(null);
				break;

			// unknown center atom
			default:
				System.err.println("Molecule not supported");

			}
		}

		// link all the bonds to each other
		for (int i = 0; i < atoms.length; i++) {

			// link the bond to the previous bond
			if (i > 0) {
				bondables[i].add(new Bond(bondables[i - 1], BOND_TYPE.SINGLE));
			}

			// link the bond to the next bond
			if (i < atoms.length - 1) {
				bondables[i].add(new Bond(bondables[i + 1], BOND_TYPE.SINGLE));
			}
		}
		
		// return the new bondable array
		return bondables;

	}

}
