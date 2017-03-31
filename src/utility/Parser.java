package utility;

import java.util.ArrayList;
import chemistry.Atom;

/**
 * Parser parses user input
 */
public class Parser {
    // Underlying ArrayList that stores all the bondables
    private ArrayList<Atom> bondables;

    // String array that contains chemical symbols indexed by atomic numbers
    private final String[] symbols = {"", "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne",
            "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe",
            "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo",
            "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe"};

    // Default/Functional constructor initializes bondables to empty ArrayList
    public Parser() {
        bondables = new ArrayList<>();
    }

    public Atom[] Parse(String input) {
        createBondables(input);
        Atom[] atoms = new Atom[bondables.size()];
        for (int i = 0; i < bondables.size(); i++) {
            atoms[i] = bondables.get(i);
        }
        return atoms;
    }


    /**
     * @param input is String input from user
     *
     * Recursively tokenizes and adds functional groups to bondables
     */
    public void createBondables(String input) {
        String symbol = "";
        ArrayList<String> tokens = new ArrayList<>();
        char current;
        boolean first = true;
        for (int i = 1; i < input.length(); i++) {
            current = input.charAt(i);
            if (current == ']') {
                tokens.add(symbol);
                bondables.add(parseToken(tokens));
                createBondables(input.substring(i + 1));
                return;
            } else {
                if (65 <= current && 90 >= current) {
                    if (first) {
                        symbol += current;
                        first = false;
                    } else {
                        tokens.add(symbol);
                        symbol = "" + current;
                    }
                } else {
                    symbol += current;
                }
            }
        }
    }

    // Finds the central atom, adds bonds from it to the other atoms, and returns it
    private Atom parseToken(ArrayList<String> tokens) {
        System.out.println(tokens);
        return new Atom("Hydrogen");
    }
}
