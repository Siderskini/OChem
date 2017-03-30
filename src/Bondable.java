/**
 * @author Derek
 * 
 * Something that is bondable can append a new
 * bond to an atom
 */
public interface Bondable {
	
	/**
	 * add
	 * 
	 * @param bond the bond to add to the
	 * atom or structure
	 */
	public abstract void add(Bond bond);

}
