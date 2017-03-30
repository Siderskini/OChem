package chemistry;
import java.util.ArrayList;

import utility.Reactions.REACTION_TYPE;

/**
 * @author Derek
 * 
 * The solvent determines what type of reaction can occur
 * 
 */
public class Solvent {
	
	// all solvents have a name
	private String name;
	
	// whether or not it is polar
	private boolean isPolar;
	
	// whether or not it is protic
	private boolean isProtic;
	
	/**
	 * Solvent constructor
	 * 
	 * @param name The name of the solvent
	 * @param isPolar whether or not the solvent is polar
	 * @param isProtic whether or not the solvent is protic
	 */
	public Solvent(String name, boolean isPolar, boolean isProtic) {
		
		// initialize instance data
		this.name = name;
		this.isPolar = isPolar;
		this.isProtic = isProtic;
		
	}
	
	/**
	 * getName()
	 * 
	 * @return the name of the solvent
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return A list of POSSIBLE reactions that
	 * CAN occur in the solvent
	 */
	public ArrayList<REACTION_TYPE> getReactions() {
		
		// list of possible reactions
		ArrayList<REACTION_TYPE> reactions = new ArrayList<REACTION_TYPE>();
		
		// no reactions occur in apolar solvents
		if (!isPolar) {
			return reactions;
		}
		
		// protic solvents promote sn1 or e1
		if (isProtic) {
			reactions.add(REACTION_TYPE.E1);
			reactions.add(REACTION_TYPE.SN1);
		}
		
		// sn2 or e2 can occur in any polar solvent
		reactions.add(REACTION_TYPE.SN2);
		reactions.add(REACTION_TYPE.E2);
		
		// return the list
		return reactions;
	}

}
