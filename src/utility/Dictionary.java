package utility;

/**
 * @author Derek
 *
 * Utility class for names of chemistry terms
 */
public class Dictionary {
	
	// Names of commonly used elements
	public static final String HYDROGEN = "Hydrogen";
	public static final String OXYGEN = "Oxygen";
	public static final String CARBON = "Carbon";
	public static final String NITROGEN = "Nitrogen";
	
	// Names of commonly used functional groups
	public static final String CARBONYL = "Carbonyl";
	public static final String ALCOHOL = "Alcohol";
	public static final String ALKYL_HALIDE = "Alkyl Halide";
	
	// List of all known functional groups so we can map them together
	public static final String[] FUNCTIONAL_GROUPS = { CARBONYL, ALCOHOL, ALKYL_HALIDE };

}
