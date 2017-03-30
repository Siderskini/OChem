package chemistry.functionalgroup;

import utility.Acidic;
import utility.Dictionary;
import chemistry.Atom;
import chemistry.Bond;
import chemistry.Bond.BOND_TYPE;
import chemistry.FunctionalGroup;

/**
 * @author Derek
 * An Alcohol is a functional group with -OH
 */
public class Alcohol extends FunctionalGroup implements Acidic {

	// the acid dissociation constant of an alcohol
	private int pKa = 17;

	/**
	 * Alcohol constructor
	 * 
	 * @param peripherals any peripheral bonds EXCLUDING
	 * the -OH bond
	 */
	public Alcohol(Bond[] peripherals) {
		super("Alcohol", new Atom(Dictionary.OXYGEN), peripherals);

		// add the acidic hydrogen
		add(new Bond(new Atom(Dictionary.HYDROGEN), Bond.BOND_TYPE.SINGLE));
	}

	/**
	 * getPka()
	 * 
	 * @return the pKa of the alcohol group
	 */
	public int getPka() {
		return pKa;
	}

	/**
	 * setPka()
	 * Changes the pKa of the group
	 */
	public void setPka(int pka) {
		this.pKa = pka;
	}

	/**
	 * Protonates an alcohol with a hydrogen bond
	 */
	public void protonate() {
		
		// check if the center atom has a lone pair of electrons
		if (hasLonePair()) {
			add(new Bond(new Atom(Dictionary.HYDROGEN), BOND_TYPE.SINGLE));
		}
	}

	/**
	 * Deprotonates the hydrogen in an
	 * acid-base reaction
	 */
	public void deprotonate() {
		
		// check if a hydrogen is present
		if (contains(Dictionary.HYDROGEN, BOND_TYPE.SINGLE)) {
			remove(getBond(Dictionary.HYDROGEN, BOND_TYPE.SINGLE));
		}

	}

}
