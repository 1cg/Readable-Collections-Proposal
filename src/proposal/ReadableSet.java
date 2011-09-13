package proposal;

public interface ReadableSet<E> extends ReadableCollection<E> {

  int size();

  boolean isEmpty();

  boolean contains(Object o);

  ReadableIterator<E> iterator();

  <T> T[] toArray(T[] a);

  boolean equals(Object o);

  int hashCode();

}
