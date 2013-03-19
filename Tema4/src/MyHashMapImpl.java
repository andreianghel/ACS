import java.util.*;


@SuppressWarnings("all")
public class MyHashMapImpl<K, V> implements MyHashMap<K, V> 
{
	Bucket<K, V>[] bucketArray;
	int bucketSize;
	int bucketsNum;
	
	/**Constructor pt MyHashImpl;
	 * 
	 * @param numBuckets numarul de celule ale vectorului de bucket;
	 */
	public MyHashMapImpl(int numBuckets)
	{
		bucketArray = new Bucket[numBuckets];
		while(bucketsNum < numBuckets)
			bucketArray[bucketsNum++] = new Bucket<K, V>();
	}
	
	/**Metoda ce calculeaza indexul fiecarei chei in vectorul de bucket;
	 * 
	 * @param key cheia;
	 * @return indexul;
	 */
	public int index(K key)
	{
		return Math.abs(key.hashCode()) % bucketsNum;
	}
	
	/**Metoda ce intoarce din tabel valoarea cheii cautate sau null daca aceasta nu exista;
	 * 
	 * @param key cheia dupa care se face cautarea;
	 * @return valoarea cheii cautate sau null;
	 */
	@Override
	public V get(K key)
	{	
		for(Entry<K, V> eAux : bucketArray[index(key)].entryList)
			if(eAux.key.equals(key))
				return eAux.value;
		return null;
	}

	/**Metoda ce depune in tabel o pereche: cheie-valoare sau actualizeaza valoarea unei cheii daca 
	 * 									   aceasta exista in prealabil in tabel;
	 * 
	 * @param key cheia de depus;
	 * @param value valoarea de depus;
	 * @return valoarea cheii de adaugat daca exista deja, sau null;
	 */
	@Override
	public V put(K key, V value)
	{
		//bucketul la indicele respectiv e creat din constructor;
		for(Entry<K, V> eAux : bucketArray[index(key)].entryList)
			if(eAux.key.equals(key))	//daca exista deja in lista, ii actualizez valoarea, size ramane acelasi;
			{
				V vAux = eAux.value;
				eAux.value = value;
				return vAux;
			}
		
		bucketArray[index(key)].entryList.add(new Entry<K, V>(key, value));		  //adaug Entry nou;
		bucketSize++;
		return null;
	}

	/**Metoda ce sterge din tabel un Entry; intoarce valoarea strearsa sau null daca cheia nu se gaseste in tabel;
	 * 
	 * @param key cheia elementului ce trebuie sters; 
	 * @return null sau valoarea stearsa;
	 */
	@Override
	public V remove(K key)
	{
		int iAux = -1;
		V vAux = null;
		
		for(Entry<K, V> e : bucketArray[index(key)].entryList)
			if(e.key.equals(key))
			{
				vAux = e.value;
				iAux = bucketArray[index(key)].entryList.indexOf(e);
				bucketSize--;
				break;
			}
		
		if(iAux != -1)	//s-a gasit valoare in bucketul respectiv;
			bucketArray[index(key)].entryList.remove(iAux);
		
		return vAux;
	}

	/**Metoda ce intoarce numarul de bucket;
	 * 
	 * @return numarul de bucket;
	 */
	@Override
	public int size()
	{
		return bucketSize;
	}

	/**Metoda ce intoarce o lista a tuturor bucket-urilor;
	 * 
	 * @return lista(vectorul sub forma de lista);
	 */
	@Override
	public List<? extends MyHashMap.Bucket<K, V>> getBuckets()
	{
		return Arrays.asList(bucketArray);
	}
	
	/**Clasa interna Entry, implementeaza MyHashMap.Entry;
	 * 
	 * @author ndr
	 *
	 * @param <K>
	 * @param <V>
	 */
	public class Entry<K, V> implements MyHashMap.Entry<K, V>
	{
		private K key;
		private V value;
		
		/**Constructor pt Entry;
		 * 
		 * @param key cheie;
		 * @param value valoare;
		 */
		public Entry(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		
		/**Metoda ce intoarce cheia unei instante a clasei Entry;
		 */
		@Override
		public K getKey()
		{
			return key;
		}

		/**Metoda ce intoarce valoarea unei instante a clasei Entry;
		 */
		@Override
		public V getValue() 
		{
			return value;
		}
	}
	
	/**Clasa interna Bucket;
	 * 
	 * @author ndr
	 *
	 * @param <K>
	 * @param <V>
	 */
	public class Bucket<K, V> implements MyHashMap.Bucket<K, V>
	{
		private ArrayList<Entry<K, V>> entryList;
		
		/**Constructor pt Bucket;
		 */
		public Bucket() 
		{
			entryList = new ArrayList<Entry<K, V>>();
		}
		
		/**Metoda ce intoarce o lista a Entry din bucketul respectiv;
		 */
		@Override
		public List<? extends MyHashMap.Entry<K, V>> getEntries() 
		{
			return entryList;
		}
	}
}