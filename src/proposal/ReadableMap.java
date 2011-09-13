package proposal;

public interface ReadableMap<K, V> {

  int size();

  boolean isEmpty();

  boolean containsKey(Object key);

  boolean containsValue(Object value);

  V get(Object key);

  ReadableSet<K> keySet();

  ReadableCollection<V> values();

  int hashCode();

}
