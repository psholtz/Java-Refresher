import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Exercises pertaining to Java Collections.
 * 
 * @author psholtz
 *
 */
public class Appearances {

	/**
	 * Given two collection. Return the number of elements which occur
	 * with the same frequency in both sets. 
	 * 
	 * @param a First generic collection
	 * @param b Second generic collection 
	 * @return int representing the number of elements which occur with 
	 * the same frequency in both sets. 
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		// count the occurrences of each element in the respective sets
		Map<Integer,Integer> map1 = countOccurrences(a);
		Map<Integer,Integer> map2 = countOccurrences(b);

		// see where they overlap 
		int count = 0;
		for ( int k : map1.keySet() ) {
			if ( map2.keySet().contains(k) ) {
				if ( map1.get(k) == map2.get(k) ) { count++; }
			}
		}
		return count; 
	}
	
	/**
	 * Given a collection, step through all the elements in the collection. 
	 * Produce a map, indexed by the hashCode of each distinct element in the 
	 * set and mapping to the number of times that element occurs in the set. 
	 * 
	 * @param a Collection in which to count the number of occurrences of each element
	 * @return Map indexed by hashCode() of each element, and mapping to the occurrences of the element in that set. 
	 */
	private static <T> Map<Integer,Integer> countOccurrences(Collection<T> a) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int val = 0, key = 0;
		
		for ( T t : a ) {
			key = t.hashCode();
			if ( map.containsKey(key) ) {
				val = map.get(key);
				map.put(key,val+1);
			} else {
				map.put(key,1);
			}
		}
		
		return map;
	}
}
