/**Interfata Visitable folosita pentru a implementa Visitor Pattern;
 * 
 * @author ndr;
 */
public interface Visitable 
{
	/**Metoda abstracta ce accepta un vizitator;
	 * 
	 * @param v vizitatorul acceptat;
	 */
	public String accept(Visitor v);

}
