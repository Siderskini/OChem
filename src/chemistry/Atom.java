package chemistry;
import java.util.ArrayList;

import utility.Bondable;

/**
 * Holds an Atom object
 */
public class Atom implements Bondable {
	// All atoms have valence electrons and subatomic particles
	private int valence, protons, neutrons, electrons;

	// List of bonds on the atom
	private ArrayList<Bond> bonds;

	// Name of this atom belongs to
	private String name;

	// Default Constructor
	public Atom(String element) {
		this(element, 1);
	}

	// Main Constructor
	public Atom(String name, int atomicNum) {
		this.name = name;
		electrons = atomicNum;
		bonds = new ArrayList<>();
		valence = computeValence(electrons);
	}

	// Bonding Constructor
	public Atom(String name, int atomicNum, ArrayList<Bond> bonds) {
		this.name = name;
		electrons = atomicNum;
		this.bonds = bonds;
		valence = computeValence(electrons);
	}

	// Computes number of valence electrons based on number of electrons
	private int computeValence(int electrons) {
		int valence = 0;
		if (electrons < 3) {
			valence = electrons;
		} else if (electrons < 21) {
			valence = (electrons + 6) % 8;
		} else if (electrons < 57) {
			if ((electrons - 3) % 18 < 10) {
				valence = -1;
			} else {
				if (electrons % 18 < 3) {
					valence = electrons % 18;
				} else {
					valence = (electrons + 8) % 18;
				}
			}
		}
		if (valence == 0) {
			if (electrons > 2) {
				return 8;
			}
		}
		return valence;
	}

	// Returns the number of valence electrons
	public int getValence() {
		return valence;
	}

	// Returns the name of this atom
	public String getName() {
		return name;
	}

	// Returns the formal charge on the atom
	public int formalCharge() {
		return valence - loners() - numBonds();
	}

	/**
	 * Returns the total number of bonded electrons divided by 2
	 * This is equal to the number of bonds, counting double/triple bonds
	 * accordingly
	 */
	public int numBonds() {
		int total = 0;
		for (Bond bond : bonds) {
			switch (bond.getBondType()) {
			case TRIPLE:
				total++;
			case DOUBLE:
				total++;
			case SINGLE:
				total++;
			default:
				break;
			}
		}
		return total;
	}

	// Returns the number of lone electrons surrounding the atom
	public int loners() {
		if (protons > 2) {
			return 8 - 2 * numBonds();
		} else {
			return 0;
		}
	}

	// Adds a bond to the list of bonds
	@Override
	public boolean add(Bond bond) {
		return bonds.add(bond);
	}

	// Removes a bond from the list of bonds
	@Override
	public boolean remove(Bond bond) {
		return bonds.remove(bond);
	}

	// Returns the bond in bonds with the given name and type, or returns null if not found
	public Bond getBond(String name, Bond.BOND_TYPE type) {
		for (Bond b: bonds) {
			if (b.getBondType().equals(type) && b.getOther().getName().equals(name)) {
				return b;
			}
		}
		return null;
	}

	// Returns true if this atom contains a bond of the specified type
	public boolean contains(String name, Bond.BOND_TYPE type) {
		for (Bond b: bonds) {
			if (b.getBondType().equals(type) && b.getOther().getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

}
