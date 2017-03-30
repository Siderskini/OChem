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
	 * @return true on success, false on failure
	 */
	public abstract boolean add(Bond bond);
	
	/**
	 * remove
	 * 
	 * @param bond the bond to remove from the atom
	 * @return true on success, false on failure
	 */
	public abstract boolean remove(Bond bond);

}
