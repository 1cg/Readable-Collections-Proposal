package proposal;


public interface ReadableCollection<E> extends ReadableIterable<E> {

  int size();

  boolean isEmpty();

  boolean contains(Object o);

  ReadableIterator<E> iterator();

  Object[] toArray();

  <T> T[] toArray(T[] a);

  boolean equals(Object o);

  int hashCode();
}
