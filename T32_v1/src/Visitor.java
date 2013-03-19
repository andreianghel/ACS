/**Interfata Visitor folosita pentru a implementa Visitor Pattern;
 * 
 * @author ndr;
 */
public interface Visitor
{
	/**Metoda abstracta -> cand va fi definita, va prelucra nodul vizitat conform cerintei;
	 * 
	 * @param n o instanta a clasei Node, ce va fi vizitata;
	 */
	public String visit(Node n);
	
	
	/**Metoda abstracta -> cand va fi definita, va prelucra nodul vizitat conform cerintei;
	 * 
	 * @param ov o instanta a clasei OperandValoare, ce va fi vizitata;
	 */
	public String visit(OperandValoare ov);

	/**Metoda abstracta -> cand va fi definita, va prelucra nodul vizitat conform cerintei;
	 * 
	 * @param ov o instanta a clasei OperandVariabila, ce va fi vizitata; 
	 */
	public String visit(OperandVariabila ov);
	
	/**Metoda abstracta -> cand va fi definita, va prelucra nodul vizitat conform cerintei;
	 * 
	 * @param oa o instanta a clasei OperatorAsterisc, ce va fi vizitata; 
	 */
	public String visit(OperatorAsterisc oa);
	
	/**Metoda abstracta -> cand va fi definita, va prelucra nodul vizitat conform cerintei;
	 * 
	 * @param oa o instanta a clasei OperatorAtribuire, ce va fi vizitata; 
	 */
	public String visit(OperatorAtribuire oa);
	
	/**Metoda abstracta -> cand va fi definita, va prelucra nodul vizitat conform cerintei;
	 * 
	 * @param op o instanta a clasei OperatorPlus, ce va fi vizitata; 
	 */
	public String visit(OperatorPlus op);
}