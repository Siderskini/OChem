package utility;
/**
 * @author Derek
 * 
 * Required methods for acidic functional groups
 */
public interface Acidic {
	
	/**
	 * @return the pka of the acid
	 */
	public abstract int getPka();
	
	/**
	 * Changes the pka 
	 * pka is influenced by surrounding structure
	 */
	public abstract void setPka(int pka);

	/**
	 * Required work to protonate the acid
	 */
	public abstract void protonate();
	
	/**
	 * Required work to deprotonate the acid
	 */
	public abstract void deprotonate();
}
