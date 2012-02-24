import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Encapsulate a set of grammar rules. Specifically, we define which characters 
 * are "forbidden" to follow other characters. 
 * @author psholtz
 *
 * @param <T>
 */
public class Taboo<T> {
	private List<T> rules;				// collection of rules to enforce
	
	/**
	 * Encapsulate a list of (grammar) rules to enforce, and specifically, define
	 * which characters are "forbidden" to follow other characters. An example rule 
	 * might be a list like {"a", "c", "a", "b"}, which specifies that 
	 * "c" should not follow "a", that "a" should not follow "c", and 
	 * that "b" should not follow "a".
	 * 
	 * @param rules List of rules to enforce
	 */
	public Taboo(List<T> rules ) {
		this.rules = rules;
	}
	
	/**
	 * Given an element of type T, generate the set of characters which are "forbidden" 
	 * from following the argument character. 
	 * 
	 * For instance, suppose we are given the rule {"a", "b", "a", "c"}. From this, we can 
	 * surmise that "b" may not follow "a", and that "c" may not follow "a". Therefore, 
	 * noFollow("a") should return the set {"b", "c"}. 
	 * 
	 * Conversely, suppose that there are no restrictions on the character which may follow 
	 * the argument "elem". In this case, we return the empty set. So for instance, using the 
	 * above grammar, invoking noFollow("x") should return the empty set. 
	 * 
	 * @param elem Element of type T. Method will generate the set of elements which may not follow this argument element.
	 * @return Set<T> Set of elements which may not follow the argument element. 
	 */
	public Set<T> noFollow(T elem) {
		// create set in which to collect elements
		Set<T> set = new HashSet<T>();
		
		// step through the rules, and add rules that meet our constraints
		Iterator<T> it = rules.iterator();
		T t = null, u = null;
		while ( it.hasNext() ) {
			t = it.next();
			if ( t != null && t.equals(elem) && it.hasNext() ) {
				u = it.next();
				if ( u != null ) { set.add(u); }
			}
		}
		
		// return the set
		return set;
	}
	
	/**
	 * Given a List of elements, reduce the set in such a way that all "taboo" elements are removed.
	 * 
	 * For instance, given the grammar {"a", "c", "a", "b"}, and the argument list 
	 * {"a", "c", "b", "x", "c", "a"} will reduce to {"a", "x", "c"}. The reasoning is as follows:
	 * 
	 *  -> Element 0, "a", remains
	 *  -> Element 1, "c", is removed since it may not follow "a"
	 *  -> Element 2, "b", is removed since it may not follow "a"
	 *  -> Element 3, "x", remains
	 *  -> Element 4, "c", remains
	 *  -> Element 5, "a", is removed since it may not follow "c"
	 *  
	 * @param list List of elements to be reduced, according to the grammar rules specified in constructor. 
	 */
	public void reduce(List<T> list) {
		reduceFromIndex(list,0);
	}
	
	/**
	 * Recursive function which computes the set reduction from a specific index. 
	 * 
	 * @param list List of elements we are going to reduce. 
	 * @param index Index of the set, at which to begin the reduction. 
	 */
	private void reduceFromIndex(List<T> list, int index) {
		// determine if and where we need to "halt and reduce"
		int halt = -1;
		for ( int i=index; i < list.size()-1; ++i ) {
			T t = list.get(i);
			T u = list.get(i+1);
			if ( noFollow(t).contains(u) ) {
				halt = i;
				break; 
			}
		}
		
		if ( halt != -1 ) {
			list.remove(halt+1);
			reduceFromIndex(list,halt);
		}
	}
}
