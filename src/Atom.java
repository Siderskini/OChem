/**
 * Holds an Atom object
 */
public class Atom {
    //All atoms have valence electrons and subatomic particles
    private int valence, protons, neutrons, electrons;

    //Default Constructor
    public Atom() {
        this(1, 1);
    }

    //Main Constructor
    public Atom(int atomicNum, int atomicMass) {
        this(atomicNum, atomicMass, 0);
    }

    //Constructor if there's a charge
    public Atom(int atomicNum, int atomicMass, int charge) {
        protons = atomicNum;
        neutrons = atomicMass - atomicNum;
        electrons = protons - charge;
        if (electrons < 3) {
            valence = electrons;
        } else if (electrons < 21) {
            valence = Math.floorMod(electrons + 6, 8);
        } else if (electrons < 57) {
            if ((electrons - 3) % 18 < 10) {
                valence = -1;
            } else {
                if (electrons % 18 < 3) {
                    valence = electrons % 18;
                }
                else {
                    valence = (electrons + 8) % 18;
                }
            }
        }
        if (valence == 0) {
            if (atomicNum == 1) {
                valence = 0;
            } else if (atomicNum < 3) {
                valence = 2;
            } else {
                valence = 8;
            }
        }
    }

    //Resturns the number of valence electrons
    public int getValence() {
        return valence;
    }

    //Returns the formal charge on the atom
    public int formalCharge() {
        return valence - loners() - numBonds();
    }

    /**
     * Returns the total number of bonded electrons divided by 2
     *This is equal to the number of bonds, counting double/triple bonds accordingly
    */
    public int numBonds() {
        return 0;
    }

    //Returns the number of lone electrons surrounding the atom
    public int loners() {
        if (protons > 2) {
            return 8 - 2 * numBonds();
        } else {
            return 0;
        }
    }

}
