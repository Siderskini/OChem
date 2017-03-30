/**
 * @author Derek
 * 
 * Any atom or structure that has a chemical bond
 * with another atom or structure
 *
 */
public class Bond {
	
	// Type of chemical bond
	private BOND_TYPE bond;
	
	// the other atom/structure in the bond
	private Bondable other;
	
	/**
	 * Bond constructor
	 * 
	 * @param other the other Atom in the bond
	 * @param type single/double/triple
	 */
	public Bond(Bondable other, BOND_TYPE type) {
		bond = type;
	}
	
	/**
	 * enum BOND_TYPE
	 * 
	 * There are three types of bonds:
	 * sp3, sp2, and sp
	 */
	public enum BOND_TYPE {
		SINGLE, DOUBLE, TRIPLE
	}
	
	
	/**
	 * getBondType()
	 * 
	 * @return the bond type
	 */
	public BOND_TYPE getBondType() {
		return bond;
	}

	/**
	 * getOther()
	 * 
	 * @return the atom/group at the end of the bond
	 */
	public Bondable getOther() {
		return other;
	}
}
