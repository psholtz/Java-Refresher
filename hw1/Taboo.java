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
	 * "c" should not follow "a", and "b" should not follow "a". [working]
	 * 
	 * @param rules List of rules to enforce
	 */
	public Taboo(List<T> rules ) {
		this.rules = rules;
	}
	
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
	
	public void reduce(List<T> list) {
		reduceFromIndex(list,0);
	}
	
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
