package chemistry.functionalgroup;

import utility.Dictionary;
import chemistry.Atom;
import chemistry.Bond;
import chemistry.Bond.BOND_TYPE;
import chemistry.FunctionalGroup;

/**
 * @author Derek
 * a carbonyl is the group C=O
 */
public class Carbonyl extends FunctionalGroup {

	/**
	 * Carbonyl constructor
	 * 
	 * @param peripherals any peripheral bonds EXCLUDING
	 * the C=O bond
	 */
	public Carbonyl(Bond[] peripherals) {
		super(Dictionary.CARBONYL, new Atom(Dictionary.CARBON), peripherals);

		// add the double bonded oxygen
		add(new Bond(new Atom(Dictionary.OXYGEN), BOND_TYPE.DOUBLE));
	}

}
