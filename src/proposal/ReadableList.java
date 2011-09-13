package proposal;

public interface ReadableList<E> extends ReadableCollection<E> {

  int size();

  boolean isEmpty();

  boolean contains(Object o);

  ReadableIterator<E> iterator();

  Object[] toArray();

  <T> T[] toArray(T[] a);

  boolean equals(Object o);

  int hashCode();

  E get(int index);

  int indexOf(Object o);

  int lastIndexOf(Object o);

  ReadableList<E> subList(int fromIndex, int toIndex);

}
