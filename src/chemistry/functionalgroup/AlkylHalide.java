package chemistry.functionalgroup;

import utility.Dictionary;
import chemistry.Atom;
import chemistry.Bond;
import chemistry.Bond.BOND_TYPE;
import chemistry.FunctionalGroup;

/**
 * @author Derek
 * an alkyl halide is C-X
 */
public class AlkylHalide extends FunctionalGroup {

	/**
	 * Alkyl Halide constructor
	 * 
	 * @param peripherals any peripheral bonds EXCLUDING
	 * the C-X bond
	 * @param halogen a halogen
	 */
	public AlkylHalide(Bond[] peripherals, Atom halogen) {
		super(Dictionary.ALKYL_HALIDE, new Atom(Dictionary.CARBON), peripherals);

		// add the C-X bond
		add(new Bond(halogen, BOND_TYPE.SINGLE));
	}

}
